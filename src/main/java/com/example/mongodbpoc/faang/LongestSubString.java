package com.example.mongodbpoc.faang;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        bestSolution("abcdcabd");
    }

    public static void bestSolution(String str) {
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new LinkedHashMap<>();
        String longestString = null;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                i = str.charAt(i);
                map.clear();
            } else {
                map.put(str.charAt(i), i);
            }

            if (map.size() > maxLen) {
                maxLen = map.size();
                longestString = map.keySet().toString();
            }
        }
        System.out.println(longestString);
        System.out.println(maxLen);
    }

    public static int optimized(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                j = Math.max(str.charAt(i), j);
            }
            max = Math.max(max, i - j + 1);
            map.put(str.charAt(i), i + 1);
        }
        return max;
    }

    public static int longest(String str) {
        char[] chars = str.toCharArray();
        int mx = 0;
        if (str.length() > 1) {
            for (int i = 0; i < chars.length; i++) {
                String s = chars[i] + "";
                for (int j = i + 1; j < chars.length; j++) {
                    if (s.contains("" + chars[j])) {
                        mx = Math.max(mx, s.length());
                        break;
                    } else {
                        s = s + chars[j];
                        mx = Math.max(mx, s.length());
                    }
                }
            }
            System.out.println(mx);
            return mx;
        }
        return str.length();
    }
}
