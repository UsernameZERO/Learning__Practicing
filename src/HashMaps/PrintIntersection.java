package HashMaps;

import java.util.Arrays;
import java.util.HashMap;

public class PrintIntersection {

    /*
    You have been given two integer arrays/list(ARR1 and ARR2) of size N and M,
    respectively. You need to print their intersection; An intersection for this
    problem can be defined when both the arrays/lists contain a particular value
    or to put it in other words, when there is a common value that exists in both
    the arrays/lists.
    Note :
    Input arrays/lists can contain duplicate elements.

    The intersection elements printed would be in the order they appear in the
    first sorted array/list(ARR1).

                    Sample Input 1 :
                    2
                    6
                    2 6 8 5 4 3
                    4
                    2 3 4 7
                    2
                    10 10
                    1
                    10
                    Sample Output 1 :
                    2 3 4
                    10
                    Sample Input 2 :
                    1
                    4
                    2 6 1 2
                    5
                    1 2 3 4 2
                    Sample Output 2 :
                    1 2 2

    Explanation for Sample Output 2 :

    Since, both input arrays have two '2's, the intersection of the arrays also
    have two '2's. The first '2' of first array matches with the first '2' of
    the second array. Similarly, the second '2' of the first array matches with
    the second '2' if the second array.


     */

    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr1.length;i++){
            if (map.get(arr1[i])==null){
                map.put(arr1[i],1);
            }else {
                map.put(arr1[i],map.get(arr1[i])+1);
            }
        }
        for (int i=0;i< arr2.length;i++){
            if (map.get(arr2[i]) != null){
                if (map.get(arr2[i]) == 1){
                    map.remove(arr2[i]);
                    System.out.print(arr2[i]+" ");
                }else {
                    map.put(arr2[i],map.get(arr2[i])-1 );
                    System.out.print(arr2[i]+" ");
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 ={2,6,1,2};
        int[] arr2 = {1,2,3,4,2};
        intersection(arr1,arr2);
    }
}
