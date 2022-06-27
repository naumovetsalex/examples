package org.example.TESTS.TASK.bauhaus;

public class BauhausTask3 {

    public static void main(String... args) {
        int[] nums4 = {1, 2, 2, 2, 3, 4, 5};
        int[] nums5 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        System.err.println(solution1(nums4, 5));

    }

    public static boolean solution1(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1])
                return false;
        }
        if (A[n - 1] > K || A[n - 1] < K || A[0] < 0)
            return false;
        else
            return true;
    }
}

