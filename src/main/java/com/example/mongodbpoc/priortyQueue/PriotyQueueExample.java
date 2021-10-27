package com.example.mongodbpoc.priortyQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriotyQueueExample {
    public static int findMin(int arr[]) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        return queue.poll();
    }

    public static int findKthSmallest(int arr[], int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        for (int i = 0; i < k - 1; i++)
            queue.poll();
        return queue.poll();
    }

    public static int findKthLargest(int arr[], int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        for (int i = 0; i < k - 1; i++)
            queue.poll();
        return queue.poll();
    }


    public static void KNearlySortedArrar(int arr[], int k) {
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>();
        int n = arr.length;
        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.poll();

            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.poll();

        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
        KNearlySortedArrar(arr, 4);
        Arrays.asList(arr).forEach(System.out::println);
    }
}
