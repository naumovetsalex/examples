package org.example.patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.patterns.strategy.fly_behavior.FlyBehavior;
import org.example.patterns.strategy.quack_behavior.QuackBehavior;

@Data
@AllArgsConstructor
public class Duck {

    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;

    String display() {
        return "I can display";
    }

    String swim() {
        return "I can swim";
    }

    String performFly() {
        return flyBehavior.fly();
    }

    String performQuack() {
        return quackBehavior.quack();
    }
}
