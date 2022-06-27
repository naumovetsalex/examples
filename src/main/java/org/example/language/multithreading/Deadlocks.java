package org.example.language.multithreading;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deadlocks {

    public static void main(String[] args) {
        /**       DEADLOCKS       */
        /**       First type      */
//        System.err.println("deadlock"); //1 type of deadlock
//        int[] ints = {1, 2, 3};
//        DeadlockThread1 deadlockThread1 = new DeadlockThread1(nums, ints);
//        DeadlockThread2 deadlockThread2 = new DeadlockThread2(nums, ints);
//        Thread firstDeadlockThread = new Thread(deadlockThread1);
//        Thread secondDeadlockThread = new Thread(deadlockThread2);
//        firstDeadlockThread.start();
//        secondDeadlockThread.start();
        /**       Second type      */
        Dispatcher dispatcher = new Dispatcher();
        Plane plane = new Plane(dispatcher);
        Point point = new Point("1.2", "2.3");
        DeadlockThread3 deadlockThread3 = new DeadlockThread3(dispatcher);
        DeadlockThread4 deadlockThread4 = new DeadlockThread4(plane, point);
        Thread thirdDeadlockThread = new Thread(deadlockThread3);
        Thread fourthDeadlockThread = new Thread(deadlockThread4);
        fourthDeadlockThread.start();
        thirdDeadlockThread.start();

    }
}

/**
 * FIRST TYPE
 */

class DeadlockThread1 implements Runnable {

    private List<Integer> nums;
    private int[] ints;

    DeadlockThread1(List<Integer> nums, int[] ints) {
        this.nums = nums;
        this.ints = ints;
    }

    @Override
    public void run() {
        print(nums, ints);
    }

    void print(List<Integer> nums, int[] ints) {
        synchronized (nums) {
            nums.forEach(System.out::println);
            synchronized (ints) {
                Arrays.stream(ints).forEach(System.out::println);
            }
        }
    }
}

class DeadlockThread2 implements Runnable {

    private List<Integer> nums;
    private int[] ints;

    DeadlockThread2(List<Integer> nums, int[] ints) {
        this.nums = nums;
        this.ints = ints;
    }

    @Override
    public void run() {
        print(nums, ints);
    }

    void print(List<Integer> nums, int[] ints) {
        synchronized (ints) {
            Arrays.stream(ints).forEach(System.out::println);
            synchronized (nums) {
                nums.forEach(System.out::println);
            }
        }
    }
}

/**
 * SECOND TYPE
 */

class Dispatcher {
    private final Set<Plane> planes;
    private final Set<Plane> planesPendingLanding;

    public Dispatcher() {
        planes = new HashSet<>();
        planesPendingLanding = new HashSet<>();
    }

    public synchronized void requestLanding(Plane plane) {
        planesPendingLanding.add(plane);
    }

    public synchronized Image getMap() {
        Image image = new Image();
        for (Plane plane : planes)
            image.drawMarker(plane.getLocation());
        return image;
    }
}

class Plane {
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Plane(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public synchronized void setLocation(Point location) {
        this.location = location;
        if (location.equals(destination)) {
            dispatcher.requestLanding(this);
        }
    }
}

@AllArgsConstructor
class Point {
    private String x;
    private String y;
}

class Image {
    private byte[] content;
    private Point point;

    public void drawMarker(Point point) {

    }
}

@AllArgsConstructor
class DeadlockThread3 implements Runnable {

    private Dispatcher dispatcher;

    @Override
    public void run() {
        dispatcher.getMap();
    }
}

@AllArgsConstructor
class DeadlockThread4 implements Runnable {

    private Plane plane;
    private Point point;

    @Override
    public void run() {
        plane.setLocation(point);
    }
}