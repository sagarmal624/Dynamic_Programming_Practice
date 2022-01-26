package com.example.mongodbpoc.faang;

public class StringToNumber {
    public static void main(String[] args) {
        //String num = "-1234";
        System.out.println(convert(1234567));
    }

    public static String convert(int num) {
        char arr[] = new char[9];
        int i = 0;
        while (num > 0) {
            int n = num % 10;
            arr[i++] = (char) (n + '0');
            num = num / 10;
        }
        return new StringBuilder(new String(arr)).reverse().toString();
    }

    public static void convert(String num) {
        int output = 0;
        boolean minus = false;
        if (num.startsWith("-")) {
            num = num.substring(1);
            minus = true;
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int result = c - '0';
            output = (output * 10) + result;
        }
        if (minus) {
            output = -output;
        }
        System.out.println(output);
    }
}
