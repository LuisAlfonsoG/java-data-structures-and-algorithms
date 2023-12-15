package com.alura.data_structures;

public class Heap {
    int[] heap;
    int size;

    public Heap(int default_size){
        this.size = 0;
        this.heap = new int[default_size];
    }

    static Heap buildHeapFromArray(int [] arr) {
        Heap heap = new Heap(arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        return heap;

    }

    public void insert(int value){
        if (this.size == this.heap.length) return;
        this.heap[this.size] = value;
        this.size++;
        this.heapify_up(this.size - 1);
    }

    public int parent(int i){
        if( i == 0 ) throw new Error("Heap underflow");
        return (int) Math.ceil( (i / 2.0) ) - 1;
    }

    public int left(int i){
        return 1 + (2 * i);
    }

    public int right(int i){
        return 1 + (2 * i + 1);
    }

    public void heapify_up(int i){
        if( i == 0 || i >= this.size) return;
        while( !(i < 1) && (this.heap[this.parent(i)] > this.heap[i])){
            int parent = this.parent(i);
            int temp = this.heap[parent];
            this.heap[parent] = this.heap[i];
            this.heap[i] = temp;

            i = parent;
        }

    }

    public void heapify_down(int i) {
        if( i >= this.size ) return;
        while( !(i >= this.size) ){
            int left = this.left(i);
            int right = this.right(i);
            int max = i;

            if( left < this.size && this.heap[i] > this.heap[left]) {
                max = left;
            }

            if( right < this.size && this.heap[right] < this.heap[max]) {
                max = right;
            }

            if( max != i ){
                int temp = this.heap[max];
                this.heap[max] = this.heap[i];
                this.heap[i] = temp;
            } else {
                break;
            }
        }
    }

    public int[] asArray(){
        int[] heap = new int[this.size];
        for( int i = 0; i < size; i++){
            heap[i] = this.heap[i];
        }

        return heap;
    }

    public int extract_min(){
        if( this.size == 0) throw new Error("Heap underflow");
        int min = this.heap[0];

        this.heap[0] = this.heap[this.size - 1];
        this.size--;
        this.heapify_down(0);

        return min;
    }

    public int getSize(){
        return this.size;
    }
}
