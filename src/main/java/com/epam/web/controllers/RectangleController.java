package com.epam.web.controllers;

import com.epam.web.entity.Rectangle;
import com.epam.web.entity.RectangleParameters;
import com.epam.web.logic.service.RectangleService;
import com.epam.web.logic.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RectangleController {
    @GetMapping("/calculateRectangle")
    public RectangleParameters calculateTriangle(@RequestParam double firstSide,
                                                 @RequestParam double secondSide) {
        Rectangle rectangle = new Rectangle(firstSide, secondSide);
        Service<RectangleParameters,Rectangle> service=new RectangleService();
        return service.doService(rectangle);
    }
}
