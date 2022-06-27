package org.example.patterns.strategy;

import org.example.patterns.strategy.ducks.RedheadDuck;
import org.example.patterns.strategy.fly_behavior.FlyBehavior;
import org.example.patterns.strategy.fly_behavior.FlyWithWings;
import org.example.patterns.strategy.quack_behavior.QuackBehavior;
import org.example.patterns.strategy.quack_behavior.Squek;

public class Main {

    public static void main(String... args) {
        FlyBehavior flyBehavior = new FlyWithWings();
        QuackBehavior quackBehavior = new Squek();
        Duck duck = new RedheadDuck(quackBehavior, flyBehavior);
        System.err.println(duck.performFly());
        System.err.println(duck.performQuack());
    }

}

