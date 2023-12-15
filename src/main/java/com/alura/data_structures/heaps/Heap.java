package com.alura.data_structures.heaps;

interface Heap {
    public void insert(int a);
}

interface MaxHeap extends Heap{
    public int extractMax();
    public int maximum();
}

interface MinHeap extends Heap{
    public int extractMin();
    public int minimum();
}
