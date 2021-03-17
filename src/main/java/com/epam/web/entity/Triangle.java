package com.epam.web.entity;

public class Triangle {
    private double fistSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(double fistSide, double secondSide, double thirdSide) {
        this.fistSide = fistSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getFistSide() {
        return fistSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }
}
