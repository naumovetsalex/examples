package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Example {

    private static final int ONE_HUNDRED = 100;

    public static void main(String[] args) {
//        System.out.println(printingMultipleOfThreeAndFive());
//        System.err.println(anagramsCondition("arcc", "carr"));
    }


    //    Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz”
    //    instead of the number and for the multiples of five print “Buzz”.
    //    For numbers which are multiples of both three and five print “FizzBuzz”.
    private static String printingMultipleOfThreeAndFive() {
        var result = new StringBuilder();
        for (int i = 1; i <= ONE_HUNDRED; i++) {
            if (i % 15 == 0) {
                result.append("FizzBuzz\n");
            } else if (i % 3 == 0) {
                result.append("Fizz\n");
            } else if (i % 5 == 0) {
                result.append("Buzz\n");
            } else {
                result.append(i + "\n");
            }
        }
        return result.toString();
    }

    //Write a function that takes two words as an argument and returns true if they are anagrams
    // (contain the exact same letters) and false otherwise.
    // int the Set structure it will fail

    private static boolean anagramsCondition(String wordOne, String wordTwo) {
        if(wordOne.length() != wordTwo.length()) {
            return false;
        }
        var wordArrOne = addingAllLetterToArrayFromString(wordOne);
        var wordArrTwo = addingAllLetterToArrayFromString(wordTwo);
        Collections.sort(wordArrOne);
        Collections.sort(wordArrTwo);
        return wordArrOne.equals(wordArrTwo);
    }

    private static ArrayList<Character> addingAllLetterToArrayFromString(String word) {
        var result = new ArrayList<Character>();
        for (char letter : word.toCharArray()) {
            result.add(letter);
        }
        return result;
    }
}
