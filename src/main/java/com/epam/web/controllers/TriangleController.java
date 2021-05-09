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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class TriangleController {

    @Autowired
    private Service<TriangleParameters, Triangle> service;

    @GetMapping("/calculateTriangle")
    public TriangleParameters calculateTriangle(@RequestParam double firstSide,
                                                @RequestParam double secondSide,
                                                @RequestParam double thirdSide) throws TriangleCalculatorException, InputException{

        return service.doService(new Triangle(firstSide, secondSide, thirdSide));
    }

}
