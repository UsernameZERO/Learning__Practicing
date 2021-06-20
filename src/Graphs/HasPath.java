package Graphs;

import javax.swing.text.View;
import java.util.Scanner;

public class HasPath {
    /*
    Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers),
    check if there exists any path between them or not. Print true if the path
    exists and false otherwise.

    Note:
   1. V is the number of vertices present in graph G and vertices
      are numbered from 0 to V-1.
   2. E is the number of edges present in graph G.

   Sample Input 1 :
    4 4
    0 1
    0 3
    1 2
    2 3
    1 3
    Sample Output 1 :
    true
    Sample Input 2 :
    6 3
    5 3
    0 1
    3 4
    0 3
    Sample Output 2 :
    false
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
        int h1 = s.nextInt();
        int h2 = s.nextInt();
        System.out.println(hasPath(adjMatrix,h1,h2));
    }
    public static boolean hasPath(int[][] adjMatrix,int h1,int h2){
        if (h1>= adjMatrix.length || h2 >= adjMatrix.length){
            return false;
        }
        boolean[] visited = new boolean[adjMatrix.length];
       return hasPath(adjMatrix,h1,h2,visited);
    }
    public static boolean hasPath(int[][] adjMatrix,int h1,int h2,boolean visited[]){
        if (adjMatrix[h1][h2]==1){
            return true;
        }
      visited[h1] = true;
      for (int i=0;i<adjMatrix.length;i++)
          if (adjMatrix[h1][i]==1 && !visited[i]) if (hasPath(adjMatrix,i,h2,visited)) return true;
      return false;
    }
}
