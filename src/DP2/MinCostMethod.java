package DP2;

import javax.swing.event.MouseInputAdapter;

public class MinCostMethod {
/*
An integer matrix of size (M x N) has been given.
Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:

1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"

Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

The second line onwards, the next 'M' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format :
Print the minimum cost to reach the destination.

Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76


 */

    // Recursion
    public static int mincost(int[][] arr,int m,int n){
    if (m == arr.length-1 && n == arr[0].length-1) return arr[m][n];
    int min = Integer.MAX_VALUE,temp =0;
    if (m<arr.length-1) min = mincost(arr,m+1,n);
    if (n<arr[0].length-1) {
        temp = mincost(arr, m, n + 1);
        min = min<temp ? min:temp;
    }
    if (m<arr.length-1 && n<arr.length-1){
        temp = mincost(arr,m+1,n+1);
        min = min<temp ? min:temp;
    }
    return min + arr[m][n];
    }

    // Memoization
    public static int Mincost(int[][] arr,int[][] dp,int m,int n){
        int i = arr.length,j=arr[0].length;
        if (dp[m][n] != Integer.MAX_VALUE) return dp[m][n];
    if (m == i-1 && n == j-1) return arr[m][n];
    int min = Integer.MAX_VALUE,temp=0;
    if (m<i-1) min = Mincost(arr,dp,m+1,n);
    if (n<j-1) {
        temp = Mincost(arr,dp,m,n+1);
        min = min<temp ? min:temp;
    }
    if (m<i-1 && n<j-1){
        temp = Mincost(arr,dp,m+1,n+1);
        min = min<temp ? min:temp;
    }
    dp[m][n] = min + arr[m][n];
    return min + arr[m][n];
    }

    public static void main(String[] args) {
    int [][]arr ={{9, 6, 0, 12, 90, 1},
            {2, 7, 8, 5, 78, 6},
            {1, 6, 0, 5, 10, -4},
            {9, 6, 2, -10, 7, 4},
            {10, -2, 0, 5, 5, 7}};
    // recursion
        System.out.println(mincost(arr, 0, 0));
        // Memoization
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = 0; i<arr.length;i++){
            // System.out.println("in");
            for(int j = 0; j<arr[0].length;j++) dp[i][j]=Integer.MAX_VALUE;
        }
        System.out.println(Mincost(arr,dp,0,0));
    }
}
