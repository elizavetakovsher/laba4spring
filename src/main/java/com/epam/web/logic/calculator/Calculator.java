package com.epam.web.logic.calculator;

import com.epam.web.entity.Triangle;

public interface Calculator<T> {
    double calculatePerimeter(T figure);
    double calculateSquare(T figure);
}
