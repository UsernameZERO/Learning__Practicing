package Test9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeTeams {
    /*
    1. There are N players, linearly standing. Each player has a chest number. The number
    also denotes the strength of that player. So, greater the number, stronger the player.
    2. You have to form 3 teams from these N players. Each team has to be of k size.
    3. There are two restrictions in selections of players. First, a particular player can
    only be selected for one team. So, two teams cannot have the same player. Second, you
    can only select consecutively standing players for a particular team
    4. Can you tell us the maximum possible cumulative sum of selected players chest number,
    if the selection is done according to the above mentioned conditions.

    Sample Input 1:
    8
    1 2 1 2 6 7 5 1
    2
    Sample Output 1:
    23

    Explanation:

    For selections, following 3 teams will have maximum sum: [1,2], [2, 6], [7, 5]

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        br.close();
        Three(arr, n, k);
    }

    public static void Three(String[] arr, int n, int k){
        // creating left arr sum
        // here we assumed 3*k<=n always
        int sum = 0;
        int[] lsumArr = new int[n];
        for (int i = 0; i < k; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        lsumArr[k-1] = sum;
        for (int i = k; i < lsumArr.length; i++) {
            sum += Integer.parseInt(arr[i])- Integer.parseInt(arr[i-k]);
            lsumArr[i] = Math.max(sum,lsumArr[i-1]);
        }
        // creating right sum arr
        sum = 0;
        int[] rsumArr = new int[n];
        for (int i = n-1; i >n-1-k; i--){
            sum += Integer.parseInt(arr[i]);
        }
        rsumArr[n-k] = sum;
        for (int i = n-k-1; i>=0; i--) {
            sum += Integer.parseInt(arr[i])- Integer.parseInt(arr[i+k]);
            rsumArr[i] = Math.max(sum,rsumArr[i+1]);
        }
        // finding the max sum by traversing the middle arr

        int max = 0;
        sum = 0;
        for (int i = k-1; i < 2*k-1; i++){
            sum += Integer.parseInt(arr[i]);
        }
        for (int j = 2*k-1; j < n-k; j++) {
            sum += Integer.parseInt(arr[j])- Integer.parseInt(arr[j-k]);
            if(max< lsumArr[j-k]+rsumArr[j+1]+sum){
                max = lsumArr[j-k]+rsumArr[j+1]+sum;
            }

        }
        System.out.println(max);


    }

}
