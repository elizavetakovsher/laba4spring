package com.epam.web.logic.validator;

import com.epam.web.exceptions.InputException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {
    public boolean isValidInput(double firstSide,double secondSide,double thirdSide){
        if(firstSide<=0 || secondSide<=0 || thirdSide<=0) {
            return false;
        }
        return true;
    }
}
