package com.epam.web.logic.service;

import com.epam.web.exceptions.InputException;
import com.epam.web.exceptions.TriangleCalculatorException;
import org.springframework.stereotype.Component;

public interface Service<T,E> {
    T doService(E entity) throws TriangleCalculatorException, InputException;
}
