package DP;

import java.util.Scanner;

public class MinimumNumberOfSquares {
	
	/*
	 Given an integer N, find and return the 
	 count of minimum numbers required to 
	 represent N as a sum of squares.
	 That is, if N is 4, then we can 
	 represent it as : {1^2 + 1^2 + 1^2 + 1^2} 
	 and {2^2}. The output will be 1, 
	 as 1 is the minimum count of numbers 
	 required to represent N as sum of squares.
	 
	 Sample Input 1 :
	12
	Sample Output 1 :
	3
	Explanation of Sample Output 1 :
	12 can be represented as : 
	
	A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)
	
	B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)
	
	C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)
	
	D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)
	
	As we can see, the output should be 3.
	 
	 */
// Recursion
	public static int minCount(int n) {
		if(n==0 || n == 1) return n;
		int i=1,temp=0,stepmin = Integer.MAX_VALUE;
		while(i*i<=n) {
			temp = minCount(n-i*i);
			if(temp<stepmin) stepmin = temp;
			i++;
		}
		return stepmin+1;
	}
	
	//Memoization
	public static int mincount(int n,int[] arr) {
		if(n==0) return 0;
		if(arr[n]!=0) return arr[n];
		int i=1,temp=0,stepsmin = Integer.MAX_VALUE;
		while(i*i<=n) {
			temp = mincount(n-i*i,arr);
			if(temp<stepsmin) stepsmin = temp;
			i++;
		}
		arr[n] = stepsmin+1;
		return arr[n];
	}

	//Iteration
	public static int Mincount(int n) {
		if(n == 1) return 1;
		int []arr = new int[n+1];
		arr[1] = 1;
		int i=2,temp=0,step=0,tempstep = 0;
		while(i<=n) {
			temp = 1;
			tempstep = arr[i-1];
			step = tempstep;
			while(temp*temp<=i) {
				tempstep = arr[i-temp*temp];
				if(tempstep<step) step = tempstep;
				temp++;
			}
			arr[i] = step+1;
			i++;
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		System.out.println(minCount(n));
		//Iterative
		System.err.println(Mincount(n));
		//Memoization
		int[] arr = new int[n+1];
		System.err.println(mincount(n, arr));

	}

}
