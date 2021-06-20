package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Isconnected {
    /*
    Given an undirected graph G(V,E), check if the graph G is connected graph or not.
Note:
    1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
    2. E is the number of edges present in graph G.

    Sample Input 1:
    4 4
    0 1
    0 3
    1 2
    2 3
    Sample Output 1:
    true
    Sample Input 2:
    4 3
    0 1
    1 3
    0 3
    Sample Output 2:
    false

    Sample Output 2 Explanation

    The graph is not connected, even though vertices 0,1 and 3 are connected
    to each other but there isn’t any path from vertices 0,1,3 to vertex 2.

     */

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int v = ss.nextInt();
        int e = ss.nextInt();
        //To save in Matrix
        int[][] adjMatrix = new int[v][v];
        for (int i=0;i<e;i++){
            int e1 = ss.nextInt();
            int e2 = ss.nextInt();
            adjMatrix[e1][e2] = 1;
            adjMatrix[e2][e1] = 1;

        }
        boolean[] visited = new boolean[adjMatrix.length];
        System.out.println(isConnected(adjMatrix,0,visited));
    }
    public static boolean isConnected(int[][] adjMatrix,int start,boolean[] visited){
        if (adjMatrix.length == 0){
            return true;
        }
        Queue<Integer> pendingVertices = new LinkedList<>();
        visited[start] = true;
        pendingVertices.add(start);
        while (!pendingVertices.isEmpty()){
            int cv = pendingVertices.poll();
            for (int i=0;i<adjMatrix.length;i++){
                if (adjMatrix[cv][i]==1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
        for (boolean i : visited){
            if (!i){
                return false;
            }
        }
        return true;
    }
}
