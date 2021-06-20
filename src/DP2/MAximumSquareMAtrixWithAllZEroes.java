package DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAximumSquareMAtrixWithAllZEroes {

    public static int findMaxSquareWithAllZerosItterDP(int[][] input){
        int count1 =0, count2 =0, count3 =0, count4 =0,max =0,tempMax =0;
        if(input.length==0 ){
            return 0;
        }else {
            int[][] storage = new int[input.length + 1][input[0].length + 1];

            for (int i = input.length - 1; i >= 0; i--) {
                for (int j = input[0].length - 1; j >= 0; j--) {
                    if (input[i][j] == 1) tempMax = 0;
                    else {
                        count1 = storage[i + 1][j];
                        count2 = storage[i][j + 1];
                        count3 = storage[i + 1][j + 1];
                        count4 = Math.min(count1, Math.min(count2, count3));
                        tempMax = count4 + 1;
                    }
                    if (tempMax > max) max = tempMax;
                    storage[i][j] = tempMax;
                }
            }

            return max;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] takeInput() throws IOException {

        String[] nm;
        nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int arr[][]=new int[n][m];

        if (n == 0) {
            return arr;
        }


        String[] strNums;
        for (int i = 0; i < n; ++i) {
            strNums = br.readLine().split("\\s");
            for (int j = 0; j < m; ++j){
                arr[i][j] = Integer.parseInt(strNums[j]);
            }

        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[][] arr = takeInput();
        int[][] input  = {{1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int value = 1000;
        // System.out.println(countWaysToMakeChange(denominations,value,0));

        System.out.println(findMaxSquareWithAllZerosItterDP(arr));

    }
}
