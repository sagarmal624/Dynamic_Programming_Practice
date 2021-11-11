package com.example.mongodbpoc.faang;

import java.util.List;

public class Josephus {
    void Josh(List<Integer> person, int k, int index) {
        if (person.size() == 1) {
            System.out.println(person.get(0));
            return;
        }
        index = ((index + k) % person.size());
        person.remove(index);
        Josh(person, k, index);
    }
}
