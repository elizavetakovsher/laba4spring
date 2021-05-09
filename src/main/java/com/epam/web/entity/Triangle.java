package com.epam.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;


@Data
@AllArgsConstructor
public class Triangle {
    private double fistSide;
    private double secondSide;
    private double thirdSide;

}
