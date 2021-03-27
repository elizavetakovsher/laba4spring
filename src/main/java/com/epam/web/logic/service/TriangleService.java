package com.epam.web.logic.service;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.TriangleCalculator;

@org.springframework.stereotype.Service
public class TriangleService implements Service<TriangleParameters, Triangle> {
    @Override
    public TriangleParameters doService(Triangle entity) throws TriangleCalculatorException {
        Calculator<Triangle> calculator=new TriangleCalculator();
        double perimeter=calculator.calculatePerimeter(entity);
        double square=calculator.calculateSquare(entity);
        return new TriangleParameters(square,perimeter);
    }
}
