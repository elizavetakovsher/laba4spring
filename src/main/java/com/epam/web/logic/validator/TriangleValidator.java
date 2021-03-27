package com.epam.web.logic.validator;

import com.epam.web.entity.Triangle;
import org.springframework.stereotype.Component;

public class TriangleValidator {
    public boolean isValidTriangle(Triangle triangle){
        double firstSide= triangle.getFistSide();
        double secondSide=triangle.getSecondSide();
        double thirdSide=triangle.getThirdSide();
        return (firstSide > secondSide+thirdSide || secondSide > firstSide+thirdSide || thirdSide > firstSide+secondSide);
    }
}
