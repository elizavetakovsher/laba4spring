package com.epam.web.logic.calculator;

import com.epam.web.entity.Triangle;
import com.epam.web.exceptions.TriangleCalculatorException;
import com.epam.web.logic.validator.TriangleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TriangleCalculator implements Calculator<Triangle> {
    private TriangleValidator triangleValidator = new TriangleValidator();
    private Logger logger = LoggerFactory.getLogger(TriangleCalculator.class);

    public double calculatePerimeter(Triangle triangle) throws TriangleCalculatorException {
        if (triangleValidator.isValidTriangle(triangle)) {
            logger.error("Triangle is not exist");
            throw new TriangleCalculatorException("Triangle is not exist");
        }
        return triangle.getFistSide() + triangle.getSecondSide() + triangle.getThirdSide();
    }

    private double calculateSemiPerimeter(Triangle triangle) throws TriangleCalculatorException {
        return calculatePerimeter(triangle) / 2;
    }

    public double calculateSquare(Triangle triangle) throws TriangleCalculatorException {
        if (triangleValidator.isValidTriangle(triangle)) {
            logger.error("Triangle is not exist");
            throw new TriangleCalculatorException("Triangle is not exist");
        }
        double firstSide = triangle.getFistSide();
        double secondSide = triangle.getSecondSide();
        double thirdSide = triangle.getThirdSide();
        double semiPerimeter = calculateSemiPerimeter(triangle);
        return Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
    }
}

