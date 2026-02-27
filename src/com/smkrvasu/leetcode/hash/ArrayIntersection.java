package com.smkrvasu.leetcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayIntersection {

    // user roles, IPs
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 5, 1};
        int[] arr2 = {1, 2, 4,};
        System.out.println(Arrays.toString(intersection(arr2, arr1)));

        List<String> wishlist = List.of("TV", "Laptop", "Phone", "Earbuds");
        List<String> discount = List.of("TV", "Laptop", "Headphone");
        System.out.println(intersection(wishlist, discount));
    }

    // Time O(m + n)
    // Space O(min(m , n))
    private static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> smallSet = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(arr2)
                .filter(smallSet::contains)
                .distinct()
                .toArray();
    }

    private static List<String> intersection(List<String> wishlist, List<String> discount) {
        Set<String> smallSet = new HashSet<>(discount);
        return wishlist.stream()
                .filter(smallSet::contains)
                .distinct()
                .toList();
    }
}
