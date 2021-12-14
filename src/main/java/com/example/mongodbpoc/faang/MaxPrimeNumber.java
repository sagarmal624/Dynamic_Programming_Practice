package com.example.mongodbpoc.faang;

//A number will be given example 74. you have to find the prime numbers which produces that number when you add them.
//3+71 = 74.
public class MaxPrimeNumber {
    public static void main(String[] args) {

        for (int i = 2; i <= 74; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i);
                System.out.println();
            }
        }
    }
}
