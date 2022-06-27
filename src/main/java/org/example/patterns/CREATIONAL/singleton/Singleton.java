package org.example.patterns.CREATIONAL.singleton;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Singleton {

    private static Singleton instance;

    private Singleton(){};

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
