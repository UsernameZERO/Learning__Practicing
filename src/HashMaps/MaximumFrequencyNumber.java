package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumFrequencyNumber {
    /*
    You are given an array of integers that contain numbers in random order.
    Write a program to find and return the number which occurs the maximum
    times in the given input.
    If two or more elements contend for the maximum frequency, return the
    element which occurs in the array first.

    13
    2 12 2 11 12 2 1 2 2 11 12 2 6
    Sample Output 1 :
    2
    Sample Input 2 :
    3
    1 4 5
    Sample Output 2 :
    1
     */

    // if there are equal number count then we can't expect the
    // first number which is repeated .
    // Eg :-> 1 2 2 1  we get the ans as 2 Where as answer is actually 1.
    // this works for last repetative highest number
    public static int maxFrequencyNumber(int[] arr){
    int cnt =1,temp=0,key=0;
    HashMap<Integer,Integer> map = new HashMap<>();

    for (int i=0;i<arr.length;i++){
        if (map.get(arr[i]) == null){
            map.put(arr[i],cnt);
        }else {
            map.put(arr[i],map.get(arr[i])+cnt);
        }
        if (map.get(arr[i])>temp){
            temp = map.get(arr[i]);
            key = arr[i];
        }
    }
    return key;
    }

    public static int maxFrequencyNumber1(int[] arr){
        int cnt=1,key=0,temp=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> a= new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (map.get(arr[i])==null){
                map.put(arr[i],cnt);
                a.add(arr[i]);
            }else {
                map.put(arr[i],map.get(arr[i])+cnt);
            }
        }
        for (int i=0;i<a.size();i++){
            if (map.get(a.get(i))>temp){
                temp = map.get(a.get(i));
                key = a.get(i);
            }
        }
        return key;
    }
    public static void main(String[] args) {

        //int[] arr = { 12,12,2,11,12,2,1,2,2,11,2,2,6};
        int []arr ={1,2,2,1};
        System.out.println(maxFrequencyNumber1(arr));
    }
}
