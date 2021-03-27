package com.epam.web.controllers;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.InputException;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.calculator.TriangleCalculator;
import com.epam.web.logic.service.Service;
import com.epam.web.logic.service.TriangleService;
import com.epam.web.logic.validator.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class TriangleController {

    private Logger logger = LoggerFactory.getLogger(TriangleCalculator.class);

    @GetMapping("/calculateTriangle")
    public TriangleParameters calculateTriangle(@RequestParam double firstSide,
                                                @RequestParam double secondSide,
                                                @RequestParam double thirdSide) throws TriangleCalculatorException, InputException {

        if(new InputValidator().isValidInput(firstSide, secondSide, thirdSide)){
            logger.error("One of sides is smaller then 0");
            throw new InputException("One of sides is smaller then 0");
        }
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        Service<TriangleParameters, Triangle> service = new TriangleService();
        return service.doService(triangle);
    }

}
