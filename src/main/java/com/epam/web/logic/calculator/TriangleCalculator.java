package com.epam.web.logic.calculator;

import com.epam.web.entity.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleCalculator implements Calculator<Triangle> {
    public double calculatePerimeter(Triangle triangle) {
        return triangle.getFistSide() + triangle.getSecondSide() + triangle.getThirdSide();
    }

    private double calculateSemiPerimeter(Triangle triangle) {
        return calculatePerimeter(triangle) / 2;
    }

    public double calculateSquare(Triangle triangle) {
        double firstSide = triangle.getFistSide();
        double secondSide = triangle.getSecondSide();
        double thirdSide = triangle.getThirdSide();
        double semiPerimeter=calculateSemiPerimeter(triangle);
        return Math.sqrt(semiPerimeter*(semiPerimeter-firstSide)*(semiPerimeter-secondSide)*(semiPerimeter-thirdSide));
    }
}
