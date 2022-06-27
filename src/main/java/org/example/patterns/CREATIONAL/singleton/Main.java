package org.example.patterns.CREATIONAL.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();
        System.err.println(single1);
        System.err.println(single2);
    }
}
