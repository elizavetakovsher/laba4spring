package com.epam.web.controllers;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.InputException;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.TriangleCalculator;
import com.epam.web.logic.validator.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private TriangleCalculator calculator;
    @Autowired
    private InputValidator inputValidator;
    private Logger logger = LoggerFactory.getLogger(RestController.class);
    @GetMapping("/calculateTriangle")
    public TriangleParameters calculateTriangle(@RequestParam(name = "firstSide") double firstSide,
                            @RequestParam(name = "secondSide") double secondSide,
                            @RequestParam(name = "thirdSide") double thirdSide) throws InputException, TriangleCalculatorException {



        if(!inputValidator.isValidInput(firstSide, secondSide, thirdSide)){
            logger.error("Invalid Input error,One of sides is smaller then 0");
            throw new InputException("One of sides is smaller then 0");
        }
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        double perimeter=calculator.calculatePerimeter(triangle);
        double square=calculator.calculateSquare(triangle);
        return new TriangleParameters(square,perimeter);
    }
}
