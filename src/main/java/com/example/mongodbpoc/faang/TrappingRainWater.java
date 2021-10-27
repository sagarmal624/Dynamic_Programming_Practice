package com.example.mongodbpoc.faang;

public class TrappingRainWater {

    public static void main(String[] args) {
        int arr[] = {3, 0, 2, 0, 4};
        System.out.println(bruteForce(arr));
    }

    public static int bruteForce(int arr[]) {
        int total = 0, maxL = 0, maxR = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftMax = getMax(0, i, arr);
            int rightMax = getMax(i + 1, arr.length, arr);
            int currentWater = (Math.min(leftMax, rightMax)) - arr[i];
            if (currentWater >= 0) {
                total = total + currentWater;
            }
        }
        return total;
    }

    public static int ntime(int arr[]) {

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], left[i]);
        }
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], right[i]);
        }
        int currentWater = 0;
        for (int i = 0; i < arr.length; i++) {
            currentWater = currentWater + Math.min(left[i], right[i]) - arr[i];
        }
        return currentWater;
    }

    public static int optimzed(int arr[]) {
        int left = 0, right = arr.length - 1, leftMax = 0, rightMax = 0, total = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    total = total + leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    total = total + rightMax - arr[right];
                }
                right--;
            }
        }
        return total;
    }

    public static int getMax(int start, int end, int arr[]) {
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
