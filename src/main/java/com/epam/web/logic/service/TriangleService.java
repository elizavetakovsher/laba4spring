package com.epam.web.logic.service;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.TriangleCalculator;
import com.epam.web.logic.hash.TriangleHash;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TriangleService implements Service<TriangleParameters, Triangle> {

    @Autowired
    private TriangleHash hash;


    @Override
    public TriangleParameters doService(Triangle entity) throws TriangleCalculatorException {
        if(hash.isAlreadyHashed(entity)){
            return hash.getParameters(entity);
        }
        Calculator<Triangle> calculator=new TriangleCalculator();
        double perimeter=calculator.calculatePerimeter(entity);
        double square=calculator.calculateSquare(entity);
        TriangleParameters triangleParameters=new TriangleParameters(square,perimeter);
        hash.addToMap(entity,triangleParameters);
        return triangleParameters;
    }
}
