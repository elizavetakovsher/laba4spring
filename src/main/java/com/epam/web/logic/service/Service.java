package com.epam.web.logic.service;

import com.epam.web.entity.TriangleParameters;
import com.epam.web.exceptions.TriangleCalculatorException;

public interface Service<T,E> {
    T doService(E entity) throws TriangleCalculatorException;
}
