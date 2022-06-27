package org.example.patterns.strategy.fly_behavior;

public class FlyNoWay implements FlyBehavior{
    @Override
    public String fly() {
        return "No fly!!!";
    }
}
