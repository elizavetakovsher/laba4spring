package com.epam.web.logic.calculator;

import com.epam.web.entity.Rectangle;

public class RectangleCalculator implements Calculator<Rectangle>{

    @Override
    public double calculatePerimeter(Rectangle figure) {
        return (figure.getFirstSide()+ figure.getSecondSide())*2;
    }

    @Override
    public double calculateSquare(Rectangle figure) {
        return figure.getFirstSide()* figure.getSecondSide();
    }
}
