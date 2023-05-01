package dynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		int a[][]=new int[][] {{5,9,6},{11,5,2}};
		int n=a.length;
		int m=a[0].length;
		int dp[][]=new int[n][m];
		for(int b[]: dp) {
			Arrays.fill(b, -1);
		}
		System.out.println(getMinimumPathSum(a,n-1,m-1));
		System.out.println(getMinimumPathSum1(a,n-1,m-1,dp));
		System.out.println(getMinimumPathSum2(a,n-1,m-1));
		System.out.println(getMinimumPathSum3(a,n-1,m-1));
	}
	
	//Recursion
	public static int getMinimumPathSum(int arr[][], int x, int y) {
		if(x==0 && y==0) return arr[0][0];
		if(x<0 || y<0) return Integer.MAX_VALUE;
		int up=getMinimumPathSum(arr, x-1, y);
		int left=getMinimumPathSum(arr, x, y-1);
		
		return arr[x][y]+Math.min(up, left);
	}
	
	//Memoization
	public static int getMinimumPathSum1(int arr[][], int x, int y, int dp[][]) {
		if(x==0 && y==0) return dp[x][y]=arr[0][0];
		if(x<0 || y<0) return Integer.MAX_VALUE;
		if(dp[x][y]!=-1) return dp[x][y];
		int up=getMinimumPathSum1(arr, x-1, y,dp);
		int left=getMinimumPathSum1(arr, x, y-1,dp);
		
		return dp[x][y]=arr[x][y]+Math.min(up, left);
	}
	
	//Tabulation
	public static int getMinimumPathSum2(int arr[][], int x, int y) {
		int dp[][]=new int[x+1][y+1];
		for(int i=0; i<=x; i++) {
			for(int j=0; j<=y; j++) {
				if(i==0 && j==0) dp[i][j]=arr[0][0];
				else {
					int left=Integer.MAX_VALUE;
					int up=Integer.MAX_VALUE;
					if(i>0) up=dp[i-1][j];
					if(j>0) left=dp[i][j-1];
					
					dp[i][j]=arr[i][j]+Math.min(left, up);
				}
			}
		}
		return dp[x][y];
	}
	
	//Space Optimization
	public static int getMinimumPathSum3(int arr[][], int x, int y) {
		int prev[]=new int[y+1];
		for(int i=0; i<=x; i++) {
			int curr[]=new int[y+1];
			for(int j=0; j<=y; j++) {
				if(i==0 && j==0) curr[j]=arr[0][0];
				else {
					int left=Integer.MAX_VALUE;
					int up=Integer.MAX_VALUE;
					if(i>0) up=prev[j];
					if(j>0) left=curr[j-1];
					
					curr[j]=arr[i][j]+Math.min(left, up);
				}
			}
			prev=curr;
		}
		return prev[y];
	}

}
