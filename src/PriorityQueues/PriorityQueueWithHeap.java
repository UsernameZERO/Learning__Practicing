package PriorityQueues;

public class PriorityQueueWithHeap {
    public static void main(String[] args) {
        // test min priority queue;
        PriorityQueueMin<String> pq = new PriorityQueueMin<>();
        pq.insert(20, "run");
        System.out.println(pq.getMin());
        pq.insert(1, "on");
        pq.insert(15, "both");
        System.out.println(pq.removeMin());
        pq.insert(15, "bo");
        pq.insert(254, "rt");
        pq.insert(453, "ongf");
        pq.print();
        System.out.println(pq.size());
        pq.insert(13, "bothg");
        pq.insert(4, "bogaf");
        System.out.println(pq.getMin());

        // testing max priority queue;
        PriorityQueueMax<String> pqMax = new PriorityQueueMax<>();
        pqMax.insert(20, "run");
        pqMax.insert(1, "on");
        pqMax.insert(15, "both");
        pqMax.insert(15, "bo");
        pqMax.insert(254, "rt");
        pqMax.insert(453, "ongf");
        System.out.println(pqMax.removeMax());
        pqMax.print();
        System.out.println(pqMax.getMax());
        System.out.println(pqMax.size());
        pqMax.insert(13, "bothg");
        pqMax.insert(4, "bogaf");
        System.out.println(pqMax.getMax());
    }
}
