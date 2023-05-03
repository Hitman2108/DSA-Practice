package dynamicProgramming;

import java.util.Arrays;

public class TriangleMaxPathSum {
	
	public static void main(String[] args) {
		int a[][]=new int[][] {{1},{2,3},{3,8,7},{8,9,6,10}};
		int n=a.length;
		int m=a[0].length;
		int dp[][]=new int[n][m];
		for(int b[]: dp) {
			Arrays.fill(b, -1);
		}
		System.out.println(getMinPathSum(a,0,0));
		System.out.println(getMinPathSum1(a,0,0,dp));
		System.out.println(getMinPathSum2(a));
//		System.out.println(getMinPathSum3(a));
	}
	
	//Recursion
	public static int getMinPathSum(int arr[][], int n, int m) {
		if(n==arr.length-1) return arr[n][m];
		int diagonal=arr[n][m]+getMinPathSum(arr, n+1, m+1);
		int down=arr[n][m]+getMinPathSum(arr, n+1, m);
		
		return Math.min(diagonal, down);
	}
	
	//Memoization
	public static int getMinPathSum1(int arr[][], int n, int m, int dp[][]) {
		if(n==arr.length-1) return arr[n][m];
		if(dp[n][m]!=-1) return dp[n][m];
		int diagonal=arr[n][m]+getMinPathSum(arr, n+1, m+1);
		int down=arr[n][m]+getMinPathSum(arr, n+1, m);
		
		return dp[n][m]=Math.min(diagonal, down);
	}
	
	//Memoization
	public static int getMinPathSum2(int arr[][]) {
		int n=arr.length;
		int dp[][]=new int[n][n];
		for(int i=0; i<n; i++) {
			dp[n-1][i]=arr[n-1][i];
		}
		for(int i=n-2; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				int diagonal=arr[i][j]+dp[i+1][j+1];
				int down=arr[i][j]+dp[i+1][j];
				dp[i][j]=Math.min(diagonal, down);
			}
		}
		
		return dp[0][0];
	}
	
	//Memoization
	public static int getMinPathSum3(int arr[][]) {
		int n=arr.length;
		int front[]=new int[n];
		for(int i=0; i<n; i++) {
			front[i]=arr[n-1][i];
		}
		for(int i=n-2; i>=0; i--) {
			int curr[]=new int[n];
			for(int j=i; j>=0; j--) {
				int diagonal=arr[i][j]+front[j+1];
				int down=arr[i][j]+front[j];
				curr[j]=Math.min(diagonal, down);
			}
			front=curr;
		}
		
		return front[0];
	}

}
