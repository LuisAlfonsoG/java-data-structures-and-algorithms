package com.alura.data_structures.heaps;

import java.util.Arrays;

public class BinaryMaxHeap implements MaxHeap{
    int[] heap;
    int size;
    public BinaryMaxHeap(int max_size){
        this.heap = new int[max_size];
        this.size = 0;
    }
    public static BinaryMaxHeap buildFromArray(int[] arr){
        BinaryMaxHeap heap = new BinaryMaxHeap(arr.length);
        Arrays.stream(arr).forEach(heap::insert);

        return heap;
    }

    @Override
    public void insert(int a) {
        if( size >= heap.length) return;

        size++;

        this.heap[size - 1] = a;
        heapifyUp(size - 1);

    }

    void heapifyDown(int i) {
        while( i < size ){
            int left = left(i);
            int right = right(i);
            int max = i;

            if(left < size && heap[i] < heap[left] ){
                max = left;
            }

            if( right < size && heap[max] < heap[right]) {
                max = right;
            }

            if( max != i ){
                swap(max, i);
            } else {
                break;
            }

            i = max;
        }
    }

    void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    void heapifyUp(int i) {
        if (i >= size) return;
        while( i > 0 ){
            int parent = parent(i);
            if( heap[parent]  < heap[i] ){
                swap(parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i){
        return 1 + 2 * i ;
    }

    public int right(int i){
        return 1 + 2 * i + 1;
    }

    @Override
    public int extractMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return max;
    }

    public int getSize(){
        return this.size;
    }
    @Override
    public int maximum() {
        return heap[0];
    }

    public int[] asArray(){
        return this.heap;
    }
}
