package com.example.mongodbpoc.priortyQueue;

public class KeyValue {
    Integer key,value;

    public KeyValue(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key=" + key +
                '}';
    }
}
