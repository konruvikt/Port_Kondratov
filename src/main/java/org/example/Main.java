package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Port port1  = new Port(new String[]{"1,5,8-9", "2-6", "10", "2-3,4-6"});
        System.out.println(Arrays.deepToString(port1.getNumIndexes()));
        for(List<Integer> i : port1.getUniqueArrays()) {
            System.out.println(i.toString());
        }
    }
}