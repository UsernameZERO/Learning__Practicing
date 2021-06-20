package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class LootHouses {
	
	/*
	 A thief wants to loot houses. He 
	 knows the amount of money in each 
	 house. He cannot loot two consecutive 
	 houses. Find the maximum amount of 
	 money he can loot.
	 
	Sample Input 1 :
	6
	5 5 10 100 10 5
	Sample Output 1 :
	110
	Sample Input 2 :
	6
	10 2 30 20 3 50
	Sample Output 2 :
	90
	Explanation of Sample Output 2 :
	Looting first, third, and the last houses([10 + 30 + 50]) 
	will result in the maximum loot, and all the other 
	possible combinations would result in less than 90.
	 */
	
	public static int maxMoneyLooted(int[] houses) {
		int min =0,max=0;
		for(int i=0;i<houses.length;i=i+2) {
			min+=houses[i];
			max+=houses[i+1];
		}
		if(min<max) return max;
		return min;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(maxMoneyLooted(arr));
	}
	

	
}
