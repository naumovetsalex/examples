package org.example.language.multithreading;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String... args) {
        ThreadDuplicationRunning threadDuplicationRunning = new ThreadDuplicationRunning();
//        ThreadDuplicationRunning threadDuplicationRunning1 = new ThreadDuplicationRunning();
        threadDuplicationRunning.run();
//        threadDuplicationRunning1.run(); //work like usual method calling
        threadDuplicationRunning.start();
        //threadDuplicationRunning.start(); //can't do this because thread ThreadDuplicationRunning
        //is already dead
        var nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
//        System.err.println("Synchronized resource usage");
//        TestResource testResource = new TestResource(nums);
//        Thread1 thread1 = new Thread1(testResource);
//        Thread2 thread2 = new Thread2(testResource);
//        Thread firstThread = new Thread(thread1);
//        Thread secondThread = new Thread(thread2);
//        firstThread.start();
//        secondThread.start();
//        System.err.println("Non synchronized");
//        Thread1 thread11 = new Thread1(nums);
//        Thread2 thread22 = new Thread2(nums);
//        Thread firstThreadWithNums = new Thread(thread11);
//        Thread secondThreadWithNums = new Thread(thread22);
//        firstThreadWithNums.start();
//        secondThreadWithNums.start();
//        System.err.println("Threadsafe resource usage");
//        CopyOnWriteArrayList<Integer> nums_two = new CopyOnWriteArrayList<>(nums);
//        Thread1 thread111 = new Thread1(nums);
//        Thread2 thread222 = new Thread2(nums);
//        Thread firstThreadWithConcurrentNums = new Thread(thread111);
//        Thread secondThreadWithConcurrentNums = new Thread(thread222);
//        firstThreadWithConcurrentNums.start();
//        secondThreadWithConcurrentNums.start();
//        System.err.println("Threadsafe resource usage");
//        TestResource2 testResource2 = new TestResource2(nums);
//        Thread1 thread1111 = new Thread1(testResource2);
//        Thread2 thread2222 = new Thread2(testResource2);
//        Thread firstThreadWithConcurrentResource = new Thread(thread1111);
//        Thread secondThreadWithConcurrentResource = new Thread(thread2222);
//        firstThreadWithConcurrentResource.start();
//        secondThreadWithConcurrentResource.start();

    }


}

class TestResource {

    private List<Integer> nums;

    TestResource(List<Integer> nums) {
        this.nums = nums;
    }

    synchronized void print(List<Integer> nums) {
        nums.forEach(System.out::println);
    }
}


class TestResource2 {

    private volatile List<Integer> nums;

    TestResource2(List<Integer> nums) {
        this.nums = nums;
    }

    void print() {
        nums.forEach(System.out::println);
    }
}

class Thread1 implements Runnable {

    private List<Integer> nums;
    private TestResource testResource;
    private CopyOnWriteArrayList<Integer> nums_two;
    private TestResource2 testResource2;

    Thread1(List<Integer> nums) {
        this.nums = nums;
    }

    Thread1(TestResource testResource) {
        this.testResource = testResource;
    }

    Thread1(CopyOnWriteArrayList<Integer> nums_two) {
        this.nums_two = nums_two;
    }

    Thread1(TestResource2 testResource2) {
        this.testResource2 = testResource2;
    }

    @Override
    public void run() {
        Random random = new Random();
        if (nums != null) {
            nums.forEach(System.out::println);
        } else if (testResource != null) {
            testResource.print(Arrays.asList(1, 2, 4, 5));
        } else {
            testResource2.print();
        }
    }
}

class Thread2 implements Runnable {

    private List<Integer> nums;
    private TestResource testResource;
    private CopyOnWriteArrayList<Integer> nums_two;
    private TestResource2 testResource2;

    Thread2(List<Integer> nums) {
        this.nums = nums;
    }

    Thread2(TestResource testResource) {
        this.testResource = testResource;
    }

    Thread2(CopyOnWriteArrayList<Integer> nums_two) {
        this.nums_two = nums_two;
    }

    Thread2(TestResource2 testResource2) {
        this.testResource2 = testResource2;
    }

    @Override
    public void run() {
        Random random = new Random();
        if (nums != null) {
            nums.forEach(System.out::println);
        } else if (testResource != null) {
            testResource.print(Arrays.asList(1, 2, 4, 5));
        } else {
            testResource2.print();
        }
    }
}