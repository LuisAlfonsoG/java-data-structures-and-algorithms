package com.alura;

import com.alura.algorithms.sorting.HeapSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[10];

        arr = Arrays.stream(arr)
                .map(a -> (int) Math.abs(Math.random() * 1000))
                .toArray();

        System.out.println(Arrays.toString(arr));

        arr = HeapSort.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}