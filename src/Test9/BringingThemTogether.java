package Test9;

import java.util.Scanner;

public class BringingThemTogether {
    /*
    1. Rohit was organizing a party. He made his friends stand linearly in a queue
    and gave a cap with number printed on its top to each of its friend.
    2. He wanted to bring all the people whose cap number is less than or equal to
    'X' together. But he wanted to achieve it in minimum transitions of his friends.
    3. Given the initial position of friends with their cap numbers, can you tell us
    minimum number of transitions required to bring all the people whose cap number
    is less than or equal to 'X' together.

    Sample Input 1:
    7
    12 17 19 15 18 17 14
    15
    Sample Output 1:
    2

    Explanation:

    There are three elements which are less than or equal to 'X'.
    Following are those three elements: 12, 14, 15.
    The minimum number of transitions will be two. One of the many subarrays,
    where the minimum transitions will be two is first subarray of size 3, i.e.
    [12, 17, 19]. We can bring all elements together by swapping (17 & 15) and (19 & 14).


     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int[] capNo = new int[n];
        for (int i =0;i< capNo.length;i++){
            capNo[i] = s.nextInt();
        }
        int v = s.nextInt();
        int count =0,countIn=0,CountMax=0;
        for (int i=0;i<capNo.length;i++){
            if (capNo[i]<=v){
                count++;
            }
        }
        for (int i=0;i<count;i++){
            if (capNo[i]<=v){
                countIn++;
            }
        }
        CountMax = countIn;

        for (int i=count;i<n;i++){
            if (capNo[i]<=v){
                countIn++;
            }
            if (capNo[i-count]<=v){
                countIn--;
            }
            if (countIn>CountMax){
                CountMax = countIn;
            }
        }
        int swaps =  count - CountMax;
        System.out.println(swaps);
    }
}
