package org.example.paradoxes.interfaces;

public interface B {
    default void bar(){
        System.err.println("class B, method bar");
    }
}
