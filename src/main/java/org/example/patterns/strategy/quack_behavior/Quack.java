package org.example.patterns.strategy.quack_behavior;

public class Quack implements QuackBehavior{
    @Override
    public String quack() {
        return "quack!!!";
    }
}
