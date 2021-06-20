package HashMaps;

import java.security.cert.PolicyNode;
import java.util.HashMap;
import java.util.Set;

public class PairSumTo0 {
    /*
    Given a random integer array A of size N. Find and print the
    count of pair of elements in the array which sum up to 0.

    Note: Array A can contain duplicate elements as well.

                Constraints :
                         0 <= N <= 10^4
                        Time Limit: 1 sec
            Sample Input 1:
                            5
                            2 1 -2 2 3

            Sample Output 1:
                             2

     */

    public static int PairSum(int[] input, int size) {
        int Pcnt =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<size;i++){
            if (map.get(input[i])== null){
                map.put(input[i],1);
            }else {
                map.put(input[i],map.get(input[i])+1);
            }
        }
        Set<Integer> key = map.keySet();
        for (int keys :key){
            if (keys==0){
                if (map.get(0)>1){
                    Pcnt+=(map.get(0)*(map.get(0)-1))/2;
                }
            }if (keys>0){
                if (map.containsKey(-1*keys)){
                    Pcnt += map.get(keys)*map.get(-1*keys);
                }
            }
        }
        return Pcnt;
    }

    public static void main(String[] args) {
    int size = 5;
    int[] arr = {2,1,-2,2,3};
        System.out.println(PairSum(arr,size));
    }
}
