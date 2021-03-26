package com.epam.web.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RectangleParameters {
    @JsonProperty("Rectangle Square")
    private double square;
    @JsonProperty("Rectangle Perimeter")
    private double perimeter;

    public RectangleParameters(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }
}
