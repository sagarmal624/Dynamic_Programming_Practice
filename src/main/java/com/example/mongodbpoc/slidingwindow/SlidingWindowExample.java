package com.example.mongodbpoc.slidingwindow;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowExample {

    public static void minSumSubArraySizek(int arr[], int k) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < arr.length) {
            if (j - i + 1 < k) {
                sum = sum + arr[j];
                j++;
            } else if (j - i + 1 == k) {
                sum = sum + arr[j];
                min = Math.min(min, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        System.out.println(min);
    }

    public static int largestSubStringWithoutRepeatingChars(String str) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        while (j < str.length()) {
            if (set.add(str.charAt(j))) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (str.charAt(i) != str.charAt(j)) {
                    set.remove(str.charAt(i));
                    i++;
                }
                set.remove(str.charAt(j));
                i++;
            }
        }
        return max;
    }

    // need to fix one bug .. not working properly
    public static void longestSubStringWithKUniqueChar(char arr[], int k) {

        int mx = 0, i = 0, j = 0, size = arr.length, max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (j < size) {

            if (map.containsKey(arr[j])) {
                map.put(arr[j], map.get(arr[j]) + 1);
            } else {
                map.put(arr[j], 1);
            }

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (map.size() > k) {

                while (map.size() > k) {
                    if (map.containsKey(arr[i])) {
                        map.put(arr[i], map.get(arr[i]) - 1);
                    }
                    if (map.get(arr[i]) == null || map.get(arr[i]) == 0) {
                        map.remove(arr[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        System.out.println(max);
    }

    //it will work for positive nums only
    public static void largestSumArrayOfSumK(int arr[], int k) {
        int mx = 0, i = 0, j = 0, size = arr.length;
        int sum = 0;

        while (j < size) {
            sum = sum + arr[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                mx = Math.max(mx, j - i + 1);
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }

                if (sum == k) {
                    mx = Math.max(mx, j - i + 1);

                }


                j++;
            }
        }
        System.out.println(mx);
    }

    public static void findMaxNumFromSubarrayOfWindowSizeK(int arr[], int k) {
        int j = 0, i = 0, max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        while (j < arr.length) {
            if (j - i + 1 < k) {
                list.add(arr[j]);
                max = Math.max(max, arr[j]);
                j++;
            } else if (j - i + 1 == k) {
                list.add(arr[j]);
                max = Math.max(max, arr[j]);
                System.out.println(max);
                if (list.get(0) == max) {
                    list.remove(0);
                    max = Integer.MIN_VALUE;
                }
                i++;
            }

        }
    }

    public static void countOccuranceOfAnagram(String A, String B) {
        char strA[] = A.toCharArray();
        char strB[] = B.toCharArray();
        Arrays.sort(strB);
        char c[] = new char[strB.length];
        int j = 0, i = 0, k = B.length(), count = 0;
        String str = "";
        int index = 0;
        while (j < A.length()) {
            if (j - i + 1 < k) {
                str = str + strA[j];
                j++;
            } else if (j - i + 1 == k) {
                str = str + strA[j];
                c = str.toCharArray();
                //we can also use tree set to store and compare in n times
                Arrays.sort(c);
                if (Arrays.equals(c, strB)) {
                    count++;
                }
                str = str.substring(1, str.length());
                j++;
                i++;
            }
        }
        System.out.println(count);
    }

    public static void firstNegativeNumberOfSubArraySizeK(int arr[], int k) {
        int i = 0, j = 0;
        List<Integer> negatives = new ArrayList<>();
        while (j < arr.length) {
            if (j - i + 1 < k) {
                if (arr[j] < 0) {
                    negatives.add(arr[j]);
                }
                j++;
            } else if (j - i + 1 == k) {
                if (arr[j] < 0) {
                    negatives.add(arr[j]);
                }
                if (negatives.isEmpty()) {
                    System.out.println(0);
                } else
                    System.out.println(negatives.get(0));
                negatives = new LinkedList<>();
                i++;
            }

        }
    }

    public static void maxSumSubArrayOfSizeK(int arr[], int k) {
        int i = 0, j = 0, sum = 0, max = 0;
        while (j < arr.length) {
            if (j - i + 1 < k) {
                sum = sum + arr[j];
                j++;
            } else if (j - i + 1 == k) {
                sum = sum + arr[j];
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        System.out.println(max);
    }

    public static int largestMaxSubStringNonRepeatingChars(String str) {
        char[] chars = str.toCharArray();
        String s = "";
        int max = 0;
        int i = 0, p = 0;
        while (p < chars.length && i < chars.length) {
            if (s.contains(chars[i] + "")) {
                p++;
                i = p;
                max = Math.max(max, s.length());
                s = "";
            } else
                s = s + chars[i];
            i++;
        }
        return Math.max(max, s.length());
    }

    public static void main(String[] args) {
        int arr[] = {5, 8, -14, 2, 4, 12};
        System.out.println(largestSubStringWithoutRepeatingChars("aabbcc"));
    }
}
