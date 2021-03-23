package com.epam.web.controllers;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import com.epam.web.logic.calculator.TriangleCalculator;
import com.epam.web.logic.service.Service;
import com.epam.web.logic.service.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class TriangleController {
    @Autowired
    private TriangleCalculator calculator;

    @GetMapping("/calculateTriangle")
    public TriangleParameters calculateTriangle(@RequestParam double firstSide,
                            @RequestParam double secondSide,
                            @RequestParam double thirdSide) {
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        Service<TriangleParameters,Triangle> service=new TriangleService();
        return service.doService(triangle);
    }

}
