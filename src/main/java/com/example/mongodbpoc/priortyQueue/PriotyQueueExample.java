package com.example.mongodbpoc.priortyQueue;

import java.util.*;

public class PriotyQueueExample {
    public static int findMin(int arr[]) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        return queue.poll();
    }

    public static int findKthSmallest(int arr[], int k) {
        //Max Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static int findKthLargest(int arr[], int k) {
        // Min Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a.compareTo(b));
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    public static void frequencySort(int arr[]) {
        //max heap
        PriorityQueue<KeyValue> queue = new PriorityQueue<>((a, b) -> b.value.compareTo(a.value));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new KeyValue(entry.getKey(), entry.getValue()));
        }
        Iterator<KeyValue> itr = queue.iterator();
        int index = 0;
        while (itr.hasNext()) {
            KeyValue keyValue = queue.poll();
            for (int j = 1; j <= keyValue.value; j++) {
                arr[index++] = keyValue.key;
            }
        }
        System.out.println(arr);
    }

    //https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
    public static void minimizeCostForRopes(int arr[]) {
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>();
        int n = arr.length;

        int index = 0;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
        }
        int cost = 0;
        while (priorityQueue.size() >= 2) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            cost = cost + first + second;
            priorityQueue.add(first + second);
        }
        System.out.println(cost);
    }

    public static void topKFrequestElements(int arr[], int k) {
        //min Heap
        //largest
        PriorityQueue<KeyValue> queue = new PriorityQueue<>((a, b) -> a.value.compareTo(b.value));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new KeyValue(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        System.out.println(queue.poll());
    }

    public static void kClosestItems(int arr[], int x, int k) {
        //max heap
        //closest==smallest
        PriorityQueue<KeyValue> queue = new PriorityQueue<>((a, b) -> b.value.compareTo(a.value));
        for (int i = 0; i < arr.length; i++) {
            queue.add(new KeyValue(arr[i], Math.abs(arr[i] - x)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(queue);
    }

    public static void KNearlySortedArrar(int arr[], int k) {
        //min heap
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>();
        int n = arr.length;

        int index = 0;
        for (int i = 0; i < n; i++) {
            priorityQueue.add(arr[i]);
            if (priorityQueue.size() > k) {
                arr[index++] = priorityQueue.poll();
            }
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.poll();
        }
        Arrays.asList(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 6};
        // 3,4,7,10,15,20
        // 20,15,10,7,4,3

        minimizeCostForRopes(arr);
    }
}
