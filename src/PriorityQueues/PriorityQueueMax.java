package PriorityQueues;

import java.util.ArrayList;

public class PriorityQueueMax <V>{
    private ArrayList<Element<V>> heap;  // this array will store the heap for priority queue.
    private int capacity;

    PriorityQueueMax(){
        this(16); // default capacity assumed to be 16;
    }

    PriorityQueueMax(int capacity){
        this.heap = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    void insert(int priority, V value){
        Element<V> ele = new Element<>(priority, value);

        this.heap.add(ele);
        if(this.heap.size()==1) return;
        // now we will do up hipfy process.
        int index = this.heap.size()-1, parentIndex = 0;
        while(index>0){
            parentIndex = (index-1)/2;  // leftnode = 2p+1  and rightnode = 2p+2;
            int child = this.heap.get(index).priority;
            int parent = this.heap.get(parentIndex).priority;
            if(child>parent){
                Element<V> swap = this.heap.get(parentIndex);
                this.heap.set(parentIndex,this.heap.get(index));
                this.heap.set(index,swap);
            }
            index = parentIndex;
        }
    }

    // getting values from Priority queue;
    V getMax() throws NullPointerException{
        if(this.isEmpty()) throw new NullPointerException();
        return this.heap.get(0).value;
    }
    boolean isEmpty(){
        return this.heap.isEmpty();
    }

    // remove elements from the priority queue;

    boolean removeMax(){
        if(this.heap.size()==0) throw new NullPointerException();
        // replacing first item to last item in the heap and removing last
        Element<V> last = this.heap.remove(this.heap.size()-1);
        if(this.heap.size()==0) return true;

        this.heap.set(0,last);
        // fixing the heap order property. by forward hipify.
        int index = 0, leftChild = 0, rightChild = 0;
        while(index<this.heap.size()){
            leftChild = index*2+1;  // leftnode = 2p+1  and rightnode = 2p+2;
            rightChild = index*2+2;
            if(	leftChild>=this.heap.size() ||
                    (rightChild>=this.heap.size() &&  this.heap.get(index).priority>this.heap.get(leftChild).priority) ||
                    (this.heap.get(index).priority>=this.heap.get(leftChild).priority && this.heap.get(index).priority>=this.heap.get(rightChild).priority)) {
                return true;
            }

            Element<V> swap = null;
            if(rightChild>=this.heap.size()){
                swap = this.heap.get(leftChild);
                this.heap.set(leftChild,this.heap.get(index));
                this.heap.set(index,swap);
                return true;
            }
            leftChild = this.heap.get(leftChild).priority>this.heap.get(rightChild).priority?rightChild:leftChild;
            swap = this.heap.get(leftChild);
            this.heap.set(leftChild,this.heap.get(index));
            this.heap.set(index,swap);
            index = leftChild;
        }
        return true;
    }

    int size(){
        return heap.size();
    }
    void print(){
        for(int i = 0; i<this.size();i++){
            System.out.print("["+this.heap.get(i).priority);
            System.out.print(" -> "+this.heap.get(i).value+"]");
        }
    }
}
