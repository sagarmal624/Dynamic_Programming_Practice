package com.example.mongodbpoc.faang;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private final int CAPACITY;
    private LinkedHashMap<String, String> cache;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public void set(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.getOrDefault(key, null);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set("1", "10");
        cache.set("2", "20");
        cache.set("3", "30");
        cache.set("4", "40");
        System.out.println(cache.cache);
    }
}
