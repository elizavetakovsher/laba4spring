package com.epam.web.logic.validator;

import org.springframework.stereotype.Component;

@Component
public class InputValidator {
    public boolean isValidInput(double firstSide,double secondSide,double thirdSide){
        return (firstSide<=0 || secondSide<=0 || thirdSide<=0) ;
    }
}
