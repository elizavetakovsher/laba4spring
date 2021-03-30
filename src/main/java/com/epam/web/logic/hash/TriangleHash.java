package com.epam.web.logic.hash;

import com.epam.web.entity.Triangle;
import com.epam.web.entity.TriangleParameters;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TriangleHash {
    private Map<Triangle, TriangleParameters> map = new HashMap<>();

    public boolean isAlreadyHashed(Triangle triangle) {
        return map.containsKey(triangle);
    }

    public void addToMap(Triangle triangle,TriangleParameters triangleParameters) {
        map.put(triangle,triangleParameters);
    }

    public TriangleParameters getParameters(Triangle triangle){
        return map.get(triangle);
    }
}
