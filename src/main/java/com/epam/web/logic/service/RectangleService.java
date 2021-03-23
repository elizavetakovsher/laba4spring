package com.epam.web.logic.service;

import com.epam.web.entity.Rectangle;
import com.epam.web.entity.RectangleParameters;
import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.logic.calculator.Calculator;
import com.epam.web.logic.calculator.RectangleCalculator;
import com.epam.web.logic.calculator.TriangleCalculator;

@org.springframework.stereotype.Service
public class RectangleService implements Service<RectangleParameters,Rectangle>{

    @Override
    public RectangleParameters doService(Rectangle entity) {
        Calculator<Rectangle> calculator=new RectangleCalculator();
        double perimeter=calculator.calculatePerimeter(entity);
        double square=calculator.calculateSquare(entity);
        return new RectangleParameters(square,perimeter);
    }
}
