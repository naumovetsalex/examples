package org.example.algoritms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Easiest {

    private static int sumOddFibonacci = 0;

    public static void main(String[] args) {
//        System.err.println(sumOfMultipleDigits(3, 5, 1000));
//        System.err.println(fibonacciFirst(6));
//        System.err.println(sumOddFibonacci(400));
//        System.err.println(fibonacciFirst(8));
//        System.err.println(fibonacciSecond(8));
//        System.err.println(sumOddFibonacciSecond(100));
//        System.err.println(greaterFactor(600851475143l));

//        System.err.println(maxPalindrome(3));

    }

    private static String sumOfMultipleDigits(int num1, int num2, int max) {
        int sum = 0;
        for (int i = 0; i < max; i++) {
            if ((i % num1 == 0) || (i % num2 == 0)) {
                sum += i;
            }
        }
        return Integer.toString(sum);
    }

    private static int sumOddFibonacciFirst(int positionInSequence) {
        if (positionInSequence == 1) {
            return 1;
        } else if (positionInSequence == 2) {
            return 1;
        }
        int member = sumOddFibonacciFirst(positionInSequence - 1) + sumOddFibonacciFirst(positionInSequence - 2);
        if ((member <= 4000000) && (member % 2 == 0)) {
            sumOddFibonacci += member;
        }
        return member;
    }

    private static long sumOddFibonacciSecond(int positionInSequence) {
        long sum = 0;
        long memberBeforePrevious = 0;
        long previous = 1;
        long result;
        for (int i = 1; i < positionInSequence; i++) {
            result = memberBeforePrevious + previous;
            memberBeforePrevious = previous;
            previous = result;
            if ((result <= 4000000) && (result % 2 == 0)) {
                sum += result;
            }
        }
        return sum;
    }

    private static int fibonacciFirst(int positionInSequence) {
        if (positionInSequence == 1) {
            return 1;
        } else if (positionInSequence == 2) {
            return 1;
        }
        return fibonacciFirst(positionInSequence - 1) + fibonacciFirst(positionInSequence - 2);
    }

    private static int fibonacciSecond(int positionInSequence) {
        int memberBeforePrevious = 0;
        int previous = 1;
        int result = 0;
        for (int i = 1; i < positionInSequence; i++) {
            result = memberBeforePrevious + previous;
            memberBeforePrevious = previous;
            previous = result;
        }
        return result;
    }

    private static ArrayList<Long> greaterFactor(long number) {
        var factors = new ArrayList<Long>();
        long result = number;
        for (long i = 1; i < result; i++) {
            if (result % i == 0) {
                factors.add(i);
                result /= i;
            }
        }
        return factors;
    }

    private static long maxPalindrome(long numberOfDigits) {
        var maxForNumbersString = new StringBuilder();
        for (int j = 0; j < numberOfDigits; j++) {
            maxForNumbersString.append(9);
        }
        int maxForNumbers = Integer.parseInt(maxForNumbersString.toString());
        var results = new ArrayList<Integer>();
        mark:
        for (int i = maxForNumbers; 0 <= i; i--) {
            for (int j = maxForNumbers; 0 <= j; j--) {
                var tmp = Integer.toString(i * j);
                var reverse = new StringBuilder(tmp).reverse();
                if (tmp.compareToIgnoreCase(reverse.toString()) == 0) {
                    results.add(Integer.parseInt(tmp));
                }
            }
        }
        return Collections.max(results);
    }


}