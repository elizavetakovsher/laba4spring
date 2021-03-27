package com.epam.web.logic.calculator;

import com.epam.web.entity.Triangle;
import com.epam.web.exceptions.TriangleCalculatorException;

public interface Calculator<T> {
    double calculatePerimeter(T figure) throws TriangleCalculatorException;
    double calculateSquare(T figure) throws TriangleCalculatorException;
}
