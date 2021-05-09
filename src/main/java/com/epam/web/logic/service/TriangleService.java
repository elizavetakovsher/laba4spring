package com.epam.web.logic.service;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.InputException;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.TriangleCalculator;
import com.epam.web.logic.counter.AppealsCounter;
import com.epam.web.logic.hash.TriangleHash;
import com.epam.web.logic.validator.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@org.springframework.stereotype.Service
public class TriangleService implements Service<TriangleParameters, Triangle> {

    private final TriangleHash hash;
    private final AppealsCounter appealsCounter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private Logger logger = LoggerFactory.getLogger(TriangleCalculator.class);
    private final InputValidator inputValidator;

    @Autowired
    public TriangleService(TriangleHash hash, AppealsCounter appealsCounter, InputValidator inputValidator) {
        this.hash = hash;
        this.appealsCounter = appealsCounter;
        this.inputValidator = inputValidator;
    }


    @Override
    public TriangleParameters doService(Triangle entity) throws TriangleCalculatorException, InputException {
        if(inputValidator.isValidInput(entity.getFistSide(), entity.getSecondSide(), entity.getThirdSide())){
            logger.error("One of sides is smaller then 0");
            throw new InputException("One of sides is smaller then 0");
        }
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
