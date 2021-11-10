package com.example.mongodbpoc.faang;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;

public class ConsecutiveNumber {

    public static boolean isConsecutive(String str) {
        int n = str.length();
        String temp = null;
        for (int i = 0; i < n / 2; i++) {
            temp = str.substring(0, i + 1);
            int num = Integer.parseInt(temp);

            while (temp.length() < n) {
                num++;
                temp = temp + String.valueOf(num);
            }
            if (temp.equals(str))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isConsecutive("9190"));
    }
}
