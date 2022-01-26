package com.example.mongodbpoc.hashmap;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Employee, String> map = new HashMap<>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Sachin");
        employee1.setDateOfBirth(new Date(1987, 2, 1));
        employee1.setSalary(new BigDecimal(100000));

//        System.out.println(employee1.hashCode());
//        employee1.setId(2);
//        employee1.setName("Sagar Mal Shankhala");
//        System.out.println(employee1.hashCode());


        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("Sachin");
        employee2.setDateOfBirth(new Date(1987, 2, 1));
        employee2.setSalary(new BigDecimal(100000));

        //map.put(employee2, "India");


        map.put(employee1, "India");
        map.put(employee2, "TEst");
//        System.out.println(employee1.hashCode());
//        System.out.println(employee2.hashCode());
        System.out.println(map.size());
//        employee2.setId(2);
 //       employee1.setName("test");
   //     employee1.setDateOfBirth(new Date(1988, 2, 1));
     //   employee1.setSalary(new BigDecimal(10000));
        System.out.println(map.get(employee1));

        System.out.println(map.get(employee2));

    }
}
