package com.alura.algorithms.sorting;

import com.alura.data_structures.heaps.BinaryMaxHeap;

public class HeapSort {

    public static int[] sort(int[] arr){
        BinaryMaxHeap heap = BinaryMaxHeap.buildFromArray(arr);
        int[] sorted = new int[heap.getSize()];

        while( heap.getSize() > 0 )
            sorted[heap.getSize() - 1] = heap.extractMax();

        return sorted;
    }

}
