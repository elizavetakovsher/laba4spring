package com.epam.web.controllers;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.logic.TriangleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private TriangleCalculator calculator;

    @GetMapping("/calculateTriangle")
    public TriangleParameters calculateTriangle(@RequestParam(name = "firstSide") double firstSide,
                            @RequestParam(name = "secondSide") double secondSide,
                            @RequestParam(name = "thirdSide") double thirdSide) {
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        double perimeter=calculator.calculatePerimeter(triangle);
        double square=calculator.calculateSquare(triangle);
        return new TriangleParameters(square,perimeter);
    }

}
