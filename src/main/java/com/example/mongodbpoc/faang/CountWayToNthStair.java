package com.example.mongodbpoc.faang;

public class CountWayToNthStair {
    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static int count(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        return nums[n];
    }
}
