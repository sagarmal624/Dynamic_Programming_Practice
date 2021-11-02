package com.example.mongodbpoc.priortyQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NGE {
    public static String reverse(String str) {
        if(str.length() == 0)
            return "";
        return str.charAt(str.length() - 1) +    reverse(str.substring(0,str.length()-1));
    }

    public static void nextGreatestElement(int A[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = A.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() < A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                int data = stack.peek();
                result.add(data);
            }
            stack.push(A[i]);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }

    }

    public static void main(String[] args) throws Exception {
        new NGE();
        int A[] = {4, 5, 2, 25};
        System.out.println(reverse("sagar"));
    }
}
