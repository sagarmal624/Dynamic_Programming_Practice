package com.example.mongodbpoc.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackDemo {
    public static int getMin(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() > arr[i]) {
                stack.push(arr[i]);
            } else {
                stack.push(stack.peek());
            }
        }
        return stack.peek();
    }

    public static void stockSpan(int arr[]) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int span[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && stack.peek() < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(i);
            }
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            span[i] = i - list.get(i);
        }
        Arrays.asList(span).forEach(System.out::println);
    }

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist) {
        for (int i = 0; i < alist.size() / 2; i++) {
            Integer temp = alist.get(i);
            alist.set(i, alist.get(alist.size() - i - 1));
            alist.set(alist.size() - i - 1, temp);
        }
        return alist;
    }

    public static ArrayList<Integer> gretestNearToLeft(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (j = 0; j < n; j++) {
            while (s.size() > 0 && s.peek() < arr[j]) {
                s.pop();
            }
            if (s.size() == 0) {
                list.add(-1);
            } else {
                list.add(s.peek());
            }
            s.push(arr[j]);
        }
        return list;
    }

    public static ArrayList<Integer> gretestNearToRight(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (j = n - 1; j >= 0; j--) {
            while (s.size() > 0 && s.peek() < arr[j]) {
                s.pop();
            }
            if (s.size() == 0) {
                list.add(-1);
            } else {
                list.add(s.peek());
            }
            s.push(arr[j]);
        }
        return reverseArrayList(list);
    }

    public static ArrayList<Integer> smallestNearToLeft(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (j = 0; j < n; j++) {
            while (s.size() > 0 && s.peek() > arr[j]) {
                s.pop();
            }
            if (s.size() == 0) {
                list.add(-1);
            } else {
                list.add(s.peek());
            }
            s.push(arr[j]);
        }
        return list;
    }

    public static String removeMinBrackets(String str) {
        String[] arr = str.split("");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else if (str.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (str.charAt(i) == ')') {
                arr[i] = "";
            }
        }
        while (!stack.isEmpty()) {
            var i = stack.pop();
            arr[i] = "";
        }
        return Arrays.stream(arr).collect(Collectors.joining(""));
    }

    public static ArrayList<Integer> smallestNearToRight(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (j = n - 1; j >= 0; j--) {
            while (s.size() > 0 && s.peek() > arr[j]) {
                s.pop();
            }
            if (s.size() == 0) {
                list.add(-1);
            } else {
                list.add(s.peek());
            }
            s.push(arr[j]);
        }
        return reverseArrayList(list);
    }

    public static void infixEvalution(String infix) {
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        for (Character c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                operand.push(Integer.parseInt(c + ""));
            } else if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    char op = operator.pop();
                    int a = operand.pop();
                    int b = operand.pop();
                    int result = binaryresult(op, a, b);
                    operand.push(result);
                }
                operator.pop();

            } else {
                if (!operator.isEmpty() && getPriortyofChar(operator.peek()) >= getPriortyofChar(c.charValue())) {
                    int a = operand.pop();
                    int b = operand.pop();
                    int result = binaryresult(operator.peek(), a, b);
                    operand.push(result);
                    operator.pop();
                    operator.push(c);
                } else {
                    operator.push(c);
                }

            }

        }
        while (!operator.isEmpty()) {
            int a = operand.pop();
            int b = operand.pop();
            int result = binaryresult(operator.peek(), a, b);
            operand.push(result);
            operator.pop();
        }
        System.out.println(operand.pop());
    }

    public static boolean isBinaryOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int binaryresult(char c, int a, int b) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
        }
        return -1;
    }

    public static void postfixEvalution(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Integer.valueOf(c + ""));
            } else if (isBinaryOperator(c)) {
                int a = stack.pop();
                int b = stack.pop();
                int result = binaryresult(c, a, b);
                stack.push(result);
            }
        }
        System.out.println(stack.pop());
    }

    public static int getPriortyofChar(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (c >= 65 && c <= 90) {
                System.out.print(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char ch = stack.pop();
                    System.out.print(ch);
                }
                stack.pop();

            } else if (c == '(') {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && getPriortyofChar(c) <= getPriortyofChar(stack.peek())) {
                    char ch = stack.pop();
                    System.out.print(ch);
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            System.out.print(ch);
        }

    }


    public static int factorial(int n, int total) {
        if (total == 0)
            return total;
        else
            return factorial(n - 1, total * n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4, 1));


    }
}
