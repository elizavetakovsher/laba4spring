package com.epam.web.logic;

import com.epam.web.entity.Triangle;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.validator.TriangleValidator;
import org.junit.Assert;
import org.junit.Test;


public class TriangleCalculatorTest {
    private final TriangleCalculator calculator = new TriangleCalculator();

    @Test
    public void calculateSquareTest() throws TriangleCalculatorException {
        Triangle triangle = new Triangle(3, 4, 5);
        double actual = calculator.calculateSquare(triangle);
        Assert.assertEquals(6, actual, 0.0001);
    }

    @Test
    public void calculatePerimeterTest() throws TriangleCalculatorException {
        Triangle triangle = new Triangle(3, 5, 7);
        double actual = calculator.calculatePerimeter(triangle);
        Assert.assertEquals(15, actual, 0.0001);
    }

    @Test (expected = TriangleCalculatorException.class)
    public void calculateSquareShouldThrowExceptionTest() throws TriangleCalculatorException {
        Triangle triangle = new Triangle(3, 1, 5);
        double actual = calculator.calculateSquare(triangle);
    }

    @Test(expected = TriangleCalculatorException.class)
    public void calculatePerimeterShouldThrowExceptionTest() throws TriangleCalculatorException {
        Triangle triangle = new Triangle(3, 1, 5);
        double actual = calculator.calculateSquare(triangle);
    }
}
