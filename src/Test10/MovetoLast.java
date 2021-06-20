package Test10;

import java.util.Scanner;

class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
        this.data=data;
    }
}
public class MovetoLast {
    /*
    Given a linked list and a key in it, the task is to move all occurrences
    of given key to end of linked list, keeping order of all other elements same.
    Return the updated head of LL.
    Input Format :

        Line 1 : Elements of the linked list ending with -1 (-1 not included)
        Line 2 : Key n, Element which has to shifted

    Output Format :

         Updated linked list

    Constraints :

    1 <= size of list <= 100

    Sample Input 1:

                1 2 2 3 4 5 -1
                2

    Sample Output 1:

                1 3 4 5 2 2
    Sample Input 2:

                1 1 2 3 4 -1
                1

    Sample Output 2:
                2 3 4 1 1
     */

    public static Node<Integer> createlist() {
        Scanner s = new Scanner(System.in);
        Node<Integer> head = null;
        Node<Integer> rear = null;
        int data = s.nextInt();
        while(data != -1) {
            Node<Integer> newnode = new Node<Integer>(data);
            if(head == null) {
                head = newnode;
                rear = head;
            }
            else {
                rear.next = newnode;
                rear = rear.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node<Integer> func(Node<Integer> head,int n) {
        Node<Integer> newHead = head, le = head, ms = null ,me = null,index = head;
        if(index.data==n){
            ms = index;
            while(index!=null && index.data==n){
                me = index;
                index = index.next;
            }
            if(index!=null){
                le = index;
                index = index.next;
                newHead = le;
                newHead.next = ms;
                me.next = index;
            }
        }
        else{
            while(index!=null && index.data!=n){
                le = index;
                index = index.next;
            }
            if(index!=null){
                ms = index;
                me = index;
                while(index!=null && index.data==n){
                    me = index;
                    index = index.next;
                }
            }
        }

        while(index!=null){
            if(index.data ==n){
                me = index;
                index = index.next;
            }else{
                me.next = index.next;
                index.next = ms;
                le.next = index;
                index = me.next;
                le = le.next;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node<Integer> head1 = createlist();
        int n = s.nextInt();
        s.close();
        print(func(head1,n));
    }
}
