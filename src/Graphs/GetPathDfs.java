package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPathDfs {
/*
       Given an undirected graph G(V, E) and two vertices v1 and v2(as integers),
       find and print the path from v1 to v2 (if exists). Print nothing if there is
       no path between v1 and v2.

       Find the path using DFS and print the first path that you encountered

       Note:
            1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
            2. E is the number of edges present in graph G.
            3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
            4. Save the input graph in Adjacency Matrix.

           Sample Input 1 :
                            4 4                  0
                            0 1                 /  \        check path 1 -3
                            0 3                1    3
                            1 2                 \  /
                            2 3                  2
                            1 3
           Sample Output 1 :
                            3 0 1
           Sample Input 2 :
                            6 3
                            5 3
                            0 1
                            3 4
                            0 3
           Sample Output 2 :
 */

    public static void main(String[] args) {
    Scanner  sc = new Scanner(System.in);

    int v = sc.nextInt();
    int e  = sc.nextInt();

    int[][] adjMatrix = new int[v][v];
    for (int i=0;i<e;i++){
        int e1 = sc.nextInt();
        int e2 = sc.nextInt();
        adjMatrix[e1][e2] = 1;
        adjMatrix[e2][e1] = 1;
    }
    int p1 =sc.nextInt();
    int p2 = sc.nextInt();
    for (int i=0;i<adjMatrix.length;i++){
        for (int j=0;j<adjMatrix.length;j++){
            System.out.print(adjMatrix[i][j] +" ");
        }
        System.out.println();
    }

        boolean[] visited = new boolean[adjMatrix.length];
        ArrayList<Integer> res = getpathDfs(adjMatrix,p1,p2,visited);
        if (res != null) {
            for (int i : res) {
                System.out.print(i + " ");
            }
        }else {
            System.out.println();
        }

    }
    public static ArrayList<Integer> getpathDfs(int[][] adjMatrix,int start,int end,boolean[] visited){
        if (start == end){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(start);
            return a;
        }

        visited[start] = true;
        for (int i=0;i< adjMatrix.length;i++){
            if (adjMatrix[start][i] == 1 && !visited[i]){
                ArrayList<Integer> res = getpathDfs(adjMatrix,i,end,visited);
                if (res!=null){
                    res.add(start);
                    return res;
                }
            }
        }
        return null;
    }

}
