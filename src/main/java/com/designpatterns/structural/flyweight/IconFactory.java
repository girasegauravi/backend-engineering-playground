package com.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {
    static Map<String, Icon> factory = new HashMap<>();

    public static Icon getIcon(String type){
        if(!factory.containsKey(type)) {
            factory.put(type, new FileIcon(type));
        }
        return factory.get(type);
    }
}
