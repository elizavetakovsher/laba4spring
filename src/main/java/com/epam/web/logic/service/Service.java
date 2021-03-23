package com.epam.web.logic.service;

import com.epam.web.entity.TriangleParameters;

public interface Service<T,E> {
    T doService(E entity);
}
