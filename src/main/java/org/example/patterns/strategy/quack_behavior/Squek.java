package org.example.patterns.strategy.quack_behavior;

public class Squek implements QuackBehavior{
    @Override
    public String quack() {
        return "squek!!!";
    }
}
