package com.epam.web.logic.service;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.TriangleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriangleService implements com.epam.web.logic.service.Service<TriangleParameters, Triangle> {
    @Override
    public TriangleParameters doService(Triangle entity) {
        Calculator<Triangle> calculator=new TriangleCalculator();
        double perimeter=calculator.calculatePerimeter(entity);
        double square=calculator.calculateSquare(entity);
        return new TriangleParameters(square,perimeter);
    }
}
