package org.example.patterns.strategy.ducks;

import org.example.patterns.strategy.Duck;
import org.example.patterns.strategy.fly_behavior.FlyBehavior;
import org.example.patterns.strategy.quack_behavior.QuackBehavior;

public class RubberDuck extends Duck {

    public RubberDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }
}
