package org.example.patterns.strategy.quack_behavior;

public class MuteQuack implements QuackBehavior{
    @Override
    public String quack() {
        return "!!!";
    }
}
