package com.zy.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream().
                map(n -> n * n).reduce(0,Integer::sum);
        System.out.println(sum);
    }
}
