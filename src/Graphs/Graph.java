package Graphs;

import java.util.*;

public class Graph {

    public static void bftraversal(int adjMatrix[][],int cv ,boolean[] visited) {
        Queue<Integer> pendingVertices = new LinkedList<>();

            visited[cv] = true;
            pendingVertices.add(cv);
            while (!pendingVertices.isEmpty()) {
                int currentVertex = pendingVertices.poll();
                System.out.print(currentVertex + " ");
                for (int j = 0; j < adjMatrix.length; j++) {
                    if (adjMatrix[currentVertex][j] == 1 && !visited[j]) {
                        pendingVertices.add(j);
                        visited[j] = true;
                    }
                }
            }

    }

    public static void bftraversal(int[][] adjMatrix){

        boolean[] visited = new boolean[adjMatrix.length];

        for (int i=0;i<visited.length;i++){
            if (!visited[i]){
                bftraversal(adjMatrix,i,visited);
                System.out.println();
            }
        }

    }
    // we use dfs to konw the current vertex to down deep
    public static void dftraversal(int[][] adjMatrix,int currentVertex,boolean visited[]){
        visited[currentVertex] = true;
        System.out.print(currentVertex+" ");
        for (int i=0;i< adjMatrix.length;i++){
            if (adjMatrix[currentVertex][i]==1 && visited[i] == false) {
                dftraversal(adjMatrix,i,visited);
            }
        }
    }

    //Dfs
    public static void dftraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
      //  dftraversal(adjMatrix,0,visited);

       // for Disconected graph
        for(int i=0;i<adjMatrix.length;i++){
        if(!visited[i]){
        dftraversal(adjMatrix,i,visited);
        System.out.println();
        }

        }

    }


    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    // Here v is vertices and
        //  e is edges of a graph

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

//        for (int i=0;i<v;i++){
//            for (int j=0;j<v;j++){
//                System.out.print(adjMatrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
       //dftraversal(adjMatrix);
       bftraversal(adjMatrix);

    }
}
