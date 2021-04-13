package com.epam.web.logic.service;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.TriangleCalculator;
import com.epam.web.logic.counter.AppealsCounter;
import com.epam.web.logic.hash.TriangleHash;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class TriangleService implements Service<TriangleParameters, Triangle> {


    private final TriangleHash hash;
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);


    @Override
    public TriangleParameters doService(Triangle entity) throws TriangleCalculatorException {
        executorService.submit(appealsCounter);
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
