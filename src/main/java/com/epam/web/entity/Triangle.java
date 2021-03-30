package com.epam.web.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.fistSide, fistSide) == 0 && Double.compare(triangle.secondSide, secondSide) == 0 && Double.compare(triangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistSide, secondSide, thirdSide);
    }
}
