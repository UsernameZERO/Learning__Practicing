package DP;
import java.util.*;
public class StairCase {
	/*
	  A child runs up a staircase with 'n' steps 
	  and can hop either 1 step, 2 steps or 3 steps 
	  at a time. Implement a method to count and return
	  all possible ways in which the child can run-up
	  to the stairs.
	  
	  	Sample Input 1:
						4
		Sample Output 1:
							7
		Sample Input 2:
						10
		Sample Output 2:
							274
	 */
	
	// recursion
	public static long staircase(int n) {
		if(n==1 || n == 2) return n;
		if(n==3) return 4;
		long a1,a2,a3;
		a1 = staircase(n-1);
		a2 = staircase(n-2);
		a3 = staircase(n-3);
		return a1+a2+a3;
		
	}
	// Memoization
	public static long stairCase(int n,long[] arr) {
		if(arr[n-1]!=0) return arr[n-1];
		if(n<4) {
		if(n==1||n==2) arr[n-1]=n;
		if(n==3) arr[n-1]=4;
		return arr[n-1];
		}
		long a1,a2,a3;
		a1 = stairCase(n-1,arr);
		a2 = stairCase(n-2,arr);
		a3 = stairCase(n-3,arr);
		arr[n-1] = a1+a2+a3;
		return arr[n-1];
	}
	
	//Iterative
	public static long StairCase1(int n) {
	if(n<1) return 0;
	long[] arr = {1,2,4};
	if(n<4) {
		return arr[n-1];
	}else {
		long i=3,temp;
		while(i<n) {
			temp = arr[0];
			arr[0] = arr[1];
			arr[1] = arr[2];
			arr[2] = temp+arr[0]+arr[1];
			i++;
		}
		return arr[2];
	}
	
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		System.out.println(staircase(n));
//		long dp[] = new long[n];
//		//Memoization
//		System.out.println(stairCase(n,dp));
		//iterative
		System.out.println(StairCase1(n));
	}


}
