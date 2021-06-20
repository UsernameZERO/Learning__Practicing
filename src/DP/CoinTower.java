package DP;

public class CoinTower {
/*
 Whis and Beerus are playing a new game 
 today. They form a tower of N coins and 
 make a move in alternate turns. Beerus 
 plays first. In one step, the player can 
 remove either 1, X, or Y coins from the tower. 
 The person to make the last move wins the game. 
 Can you find out who wins the game?
 
 	Sample Input 1 :
	4 2 3
	Sample Output 1 :
	Whis
	Sample Input 2 :
	10 2 4
	Sample Output 2 :
	Beerus
 */
	
	// Recursion
	public static String findWinner(int n, int x, int y) {
		if(n==1|| x == n || y == n) return "Beerus";
		String looser = findWinner(n-1, x, y),temp ="";
		if(n>x) {
			temp = findWinner(n-x, x, y);
			if(looser.equals("Beerus")) looser = temp;
		}
		if(n>y) {
			temp = findWinner(n-y, x, y);
			if(looser.equals("Beerus")) looser = temp;
		}
		if(looser.equals("Whis")) return "Beerus";
		return "Whis";
	}
	
	public static String findWinnerMemo(int n, int x, int y, String[] arr){
		// here arr will store 1 or 2 only 1 means Beerus and 2 means Whis.
		if(arr[n] != null) return arr[n];
		if(n==1 || n==x || n==y) return "Beerus";
		String looser = findWinnerMemo(n-1,x,y, arr),temp="";
		if(n>x){
			temp = findWinnerMemo(n-x,x,y, arr);
			if(looser.equals("Beerus")) looser = temp;
		}
		if(n>y){
			temp = findWinnerMemo(n-y,x,y, arr);
			if(looser.equals("Beerus")) looser = temp;
		}
		if(looser.equals("Whis")){
			arr[n] = "Beerus";
			return "Beerus";
		} 
		arr[n] = "Whis";
		return "Whis";

	}
//  iterative dp
	public static String findWinnerIterDP(int n,int x, int y){
		if(n<1) return null;
		int i = 2;
		String[] storage = new String[n+1];
		storage[1] = "Beerus";
		if(x<=n) storage[x] = "Beerus"; 
		if(y<=n) storage[y] = "Beerus";
		String looser = "", temp = "";

		while(i<=n){
			
			if(storage[i]==null){
				looser = storage[i-1];
				if(i>x){

					temp = storage[i-x];
					if(looser.equals("Beerus")) looser = temp;
				}
				if(i>y){
					temp = storage[i-y];
					if(looser.equals("Beerus")) looser = temp;
				}
				if(looser.equals("Whis")) storage[i] = "Beerus";
				else storage[i] = "Whis"; 

			}
			 i++; 
		}return storage[n];
	}
	public static void main(String[] args) {
		
	
		int n = 4, x=2, y = 3;

	// recursive approach
		System.out.println(findWinner(n,x,y));

	}

}
