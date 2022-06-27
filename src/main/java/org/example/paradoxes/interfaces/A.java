package org.example.paradoxes.interfaces;

public interface A {
    default void bar(){
        System.err.println("class A, method bar");
    }
}
