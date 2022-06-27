package org.example.paradoxes.interfaces;

public class BaseClass implements A, B {

    @Override
    public void bar() {
        A.super.bar();
    }
}
