package Graphs;

import java.util.*;

public class GetPathbfs {
    /*
    Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers),
    find and print the path from v1 to v2 (if exists). Print nothing if there
    is no path between v1 and v2.
      Find the path using BFS and print the shortest path available.
Note:
        1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
        2. E is the number of edges present in graph G.
        3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
        4. Save the input graph in Adjacency Matrix.

        Sample Input 1 :
        4 4
        0 1
        0 3
        1 2
        2 3
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
        int start = ss.nextInt();
        int end = ss.nextInt();

        //to print Matrix
//        for (int i=0;i<adjMatrix.length;i++){
//            for (int j=0;j< adjMatrix.length;j++){
//                System.out.print(  adjMatrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        boolean[] visited = new boolean[adjMatrix.length];
        ArrayList<Integer> res = getpathBfs(adjMatrix,start,end,visited);
        if (res==null) return;
        else {
            for (int i:res){
                System.out.print(i+" ");
            }
        }

    }
    public static ArrayList<Integer> getpathBfs(int[][] adjMatrix,int start,int end,boolean[] visited){

        Queue<Integer> pending = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        visited[start] = true;
        pending.add(start);
        while (!pending.isEmpty() && pending.peek()!=end){
            int currentVertex = pending.poll();
            for (int i =0;i<adjMatrix.length;i++){
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pending.add(i);
                    visited[i] = true;
                    map.put(i,currentVertex);
                }
            }
        }
        if (!map.containsKey(end)){
            return null;
        }
        else {
            a.add(end);
            int curr = map.get(end);
            while (curr!=start){
                a.add(curr);
                curr = map.get(curr);
            }
            a.add(start);
        }
        return a;
    }
}
