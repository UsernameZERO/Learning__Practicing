package Test8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NearestRepetetion {
    /*
    Given an integer array, find and return the minimum distance between indexes of an element and its repetition.
    Input Format :

    Line 1 : Integer N, Size of array
    Line 2 : Elements of the array (separated by space)

    Output Format :

    Print the minimum distance

    Contraints :
    1<= N <=10^6

    Sample Input 1:
        6
        1 3 1 5 4 3
    Sample Output 1:
        2
    Sample Input 2:
        7
        5 47 82 4 4 6 2
    Sample Output 2:
        1

     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int []arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]= s.nextInt();
        }
        System.out.println(minDistance(arr));
    }
    public static int minDistance(int[] arr){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        6
//        1 3 1 5 4 3
        for (int i=0;i<arr.length;i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        int distance = arr.length;
        for (int k:map.keySet()){
            ArrayList<Integer> l = map.get(k);
            if (l.size()>1){
                for (int i=0;i< l.size();i++){
                    for (int j=i+1;j<l.size();j++){
                        if(j-i<distance)
                            distance = j-i;
                    }
                }
            }
        }
        return distance;

        // Doing Normally
//        int distance = arr.length;
//        for(int i=0;i<arr.length;i++){
//            for(int j =i+1;j<arr.length;j++){
//                // repetition of number && index elemnt distant
//                if(arr[i]==arr[j] && (j-i)<distance){
//                    distance = j-i;
//                }
//            }
//        }
//        return distance;

    }
}
