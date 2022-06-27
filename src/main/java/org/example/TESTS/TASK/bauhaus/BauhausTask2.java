package org.example.TESTS.TASK.bauhaus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BauhausTask2 {

    public static void main(String[] args) {
        int[] nums1 = {-10, -10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 10, 10, 10};
        int[] nums2 = {-1, -1, -1, 1, 1, 1, 1};
        int[] nums3 = {5, -2, -3, -6, 10, 1};
        int[] nums4 = {5, -5, -3, -6, 10, 1};
        int[] nums5 = {10, -7, -2, -1, -1, -1, -1, -1, 8, -1, -2, -1, -1, -1, -2, -1, -1, -5, 10};
        System.err.println(solution1(nums2));
    }

    public static int solution2(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum = sum + A[i];
            if (sum < 0) {
                count++;
                sum -= A[i];
            } else if (sum == 0) {
                if (A[i-1] == -A[i]) {
                    sum = sum - A[i];
                    count++;
                }
            }
        }
        return count;
    }

    public static int solution1(int[] A) {
        int count = 0;
        int sum = 0;
        List<Integer> negative = new ArrayList<>();
        for (int num : A) {
            if (num < 0) {
                negative.add(num);
                negative.sort(Comparator.naturalOrder());
            }

            sum = sum + num;
            if (sum < 0) {
                count++;
                sum -= negative.get(0);
                negative.remove(0);
            }
        }
        return count;
    }

    public static int solution3(int[] A) {
        int count = 0;
        //int sum = 0;
//        if (A[0] < 0) {
//            count++;
//        }
        for (int i = 0; i < A.length - 1; i++) {
            int sum;
            for (int j = 0; j < A.length - 1; j++) {
                int tmp = 0;
                if (i < j) {
                    sum = A[i] + A[j];
                    if (sum <= 0) {
                        tmp = A[j];
                        A[j] = A[A.length - 1];
                        A[A.length - 1] = tmp;
                    }
                }
            }
        }
        return count;
    }

    public static int solution4(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum = sum + A[i];
            if (sum < 0) {
                count++;
            } else {
                if (sum == 0) {
                    if (A[i] < 0) {
                        sum = sum - A[i];
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
