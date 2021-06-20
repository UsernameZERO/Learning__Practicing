package DP;

import java.util.Scanner;

public class MinStepstoOne {
	
	/*
	 Given a positive integer 'n', find and return the
     minimum number of steps that 'n' has to take to get
	 reduced to 1. You can perform any one of the following
	  3 steps:

		1.) Subtract 1 from it. (n = n - ­1) ,
        2.) If its divisible by 2, divide 
            by 2.( if n % 2 == 0, then n = n / 2 ) ,
        3.) If its divisible by 3, divide by 3.
           (if n % 3 == 0, then n = n / 3 ).
           
        Sample Input 1 :
		4
		Sample Output 1 :
		2 
		Explanation of Sample Output 1 :
		For n = 4
		Step 1 :  n = 4 / 2  = 2
		Step 2 : n = 2 / 2  =  1 
	 */
	// recursion
	public static int countMinStepsToOne(int n) {
		if(n==1) return  0;
		int tempcnt = 0;
		int smallcnt = countMinStepsToOne(n-1);
		if(n%2 == 0) {
			tempcnt = countMinStepsToOne(n/2);
			smallcnt = tempcnt<smallcnt ? tempcnt:smallcnt;
		}
		if(n%3 == 0) {
			tempcnt = countMinStepsToOne(n/3);
			smallcnt = tempcnt<smallcnt? tempcnt:smallcnt;
		}
		return smallcnt +1;
	}
	// Memoization
	public static int countMin(int n,int[] arr) {

		if(n==1 || arr[n-1]!=0) {
			return arr[n-1];
		}
		int smallcnt,tempcnt=0;
		smallcnt = countMin(n-1, arr);
		if(n%2==0) {
			tempcnt = countMin(n/2,arr);
			smallcnt = tempcnt<smallcnt? tempcnt:smallcnt;
		}
		if(n%3 == 0) {
			tempcnt = countMin(n/3,arr);
			smallcnt = tempcnt<smallcnt? tempcnt:smallcnt;
		}
		arr[n-1] = smallcnt+1;
		return smallcnt+1;
	}
	
	//iteration
	public static int countMinStepsToOne1(int n) {
		if(n ==1) return 0;
		int arr[] = new int[n];
		int i=1,temp;
		while(i<n) {
			temp = arr[i-1];
			if((i+1)%2 == 0) temp = temp < arr[i/2] ? temp:arr[i/2];
			if((i+1)%3 == 0) temp = temp < arr[i/3] ? temp:arr[i/3];
			arr[i] = temp+1;
			i++;
		}
		return arr[n-1];
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countMinStepsToOne(n));
		int[] arr = new int[n];
		System.out.println(countMin(n, arr));
		System.out.println(countMinStepsToOne1(n));
	}

}
