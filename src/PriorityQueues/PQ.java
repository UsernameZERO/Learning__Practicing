package PriorityQueues;

import java.util.ArrayList;

public class PQ {
    private ArrayList<Integer> heap;

    public PQ() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        if (isEmpty()){
            throw new PriorityQueueException();
        }
       int removed = heap.get(0);
        int ans = removed;
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int pI= 0;
        int lci = 2*pI+1;
        int rci = 2*pI+2;

        while (lci< heap.size()){
            int minIn = pI;
            if (heap.get(lci) < heap.get(minIn)){
                minIn = lci;
            }
            if (heap.get(rci) < heap.get(minIn)){
                minIn = rci;
            }
            int temp = heap.get(minIn);
            heap.set(minIn,heap.get(pI));
            heap.set(pI,temp);
            pI = minIn;
            lci = 2*pI+1;
            rci = 2*pI+2;
        }
        return ans;

    }

}
class PriorityQueueException extends Exception {

}

