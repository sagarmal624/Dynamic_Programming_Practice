package com.example.mongodbpoc.faang;

public class QuickSelect {
    public static int quickSort(int arr[], int low, int high, int index) {
        if (low < high) {
            int location = partision(arr, low, high);
            if (location == index) {
                return arr[index];
            } else if (index < location) {
                return quickSort(arr, low, location - 1, index);
            } else
                return quickSort(arr, location + 1, high, index);
        }
        return arr[index];
    }

    public static int partision(int arr[], int low, int high) {
        int p = arr[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (start < high && arr[start] <= p) {
                start++;
            }
            while (arr[end] > p) {
                end--;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;
        return end;
    }

    public static void main(String[] args) {
        int arr[] = {9, 3, 1, 5, 7, 2, 4};
        int kth = quickSort(arr, 0, arr.length - 1, arr.length - 3);
        System.out.println(kth);

    }
}
