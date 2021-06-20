package Graphs.Assignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Islands {
    /*
    An island is a small piece of land surrounded by water .
    A group of islands is said to be connected if we can reach from any
    given island to any other island in the same group . Given V islands
    (numbered from 1 to V) and E connections or edges between islands.

    Can you count the number of connected groups of islands.

    Sample Input 1:
    5 8
    0 1
    0 4
    1 2
    2 0
    2 4
    3 0
    3 2
    4 3
    Sample Output 1:
    1

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        // now to store it in a matrix we can create an array
        int[][] adjMatrix = new int[v][v];
        for (int i=0;i<e;i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        System.out.println(numConnected1(adjMatrix,adjMatrix.length));

    }
   static HashMap<Integer,Boolean> map = new HashMap<>();
    // BFT
    public static void help(int source,int[][] edges){
        Queue<Integer> pending = new LinkedList<>() ;
        for (int i=0;i<edges.length;i++){
            if (edges[source][i]==1 && !map.containsKey(i)){
                pending.add(i);
                map.put(i,true);
            }
        }
        if (!pending.isEmpty()) help(pending.poll(),edges);

    }
    public static int numConnected(int[][] edges, int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    int count =0;
    map.clear();
    for (int i=0;i<edges.length;i++){
        if (!map.containsKey(i)){
            count++;
            map.put(i,true);
            help(i,edges);
        }
    }
    return count;

    }

    //DFT
    public static void help1(int source,int[][] edge){
        if (map.containsKey(source)) return;
        map.put(source,true);
        for (int i=0;i<edge.length;i++){
            if (edge[source][i]==1 ) help1(i,edge);
        }
    }
    public static int numConnected1(int[][] edges, int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int count =0;
        map.clear();
       for (int i=0;i<edges.length;i++){
           if (!map.containsKey(i)){
               count++;
            help1(i,edges);
           }
       }
           return count;

    }

}
