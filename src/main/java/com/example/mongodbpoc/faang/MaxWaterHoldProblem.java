package com.example.mongodbpoc.faang;

public class MaxWaterHoldProblem {

    public static void main(String[] args) {
        int arr[] = {4, 8, 1, 2, 3, 9};
        int area = optimzedWay(arr);
        System.out.println(area);

    }

    public static int maxAreaWithBruteForce(int arr[]) {
        if (arr.length == 0 || arr.length == 1)
            return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int area = Math.min(arr[i], arr[j]) * (j - i);
                result = Math.max(area, result);
            }
        }
        return result;
    }

    public static int optimzedWay(int arr[]) {

        int result = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int area = Math.min(arr[i], arr[j]) * (j - i);
            result = Math.max(result, area);
            if (arr[i] <= arr[j])
                i++;
            else
                j--;
        }

        return result;
    }

}
