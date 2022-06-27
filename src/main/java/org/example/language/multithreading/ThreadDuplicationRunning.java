package org.example.language.multithreading;

import java.util.Random;

public class ThreadDuplicationRunning extends Thread{
    @Override
    public void run() {
        Random random = new Random();
        System.err.println("something " + random.nextDouble());
    }
}
