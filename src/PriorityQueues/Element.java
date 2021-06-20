package PriorityQueues;

public class Element<T> {
     T value;
    int priority;

    Element(int priority, T value){
        this.priority = priority;
        this.value = value;
    }
}
