package com.example.mongodbpoc.faang;

public class MergeSort {
    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int b[] = new int[arr.length];
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                b[k++] = arr[i];
                i++;
            } else if (arr[i] == arr[j]) {
                b[k++] = arr[i];
                b[k++] = arr[i];
                i++;
                j++;
            } else {
                b[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            b[k++] = arr[i++];

        }
        while (j <= high) {
            b[k++] = arr[j++];
        }
        for (k = low; k <= high; k++)
            arr[k] = b[k];

    }

    public static void main(String[] args) {
        int arr[] = {9, 3, 1, 5, 7, 2, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(arr);

    }
}
