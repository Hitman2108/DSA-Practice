package dynamicProgramming;

import java.util.Arrays;

public class CherryPickup {
	
	public static void main(String[] args) {
		int a[][]=new int[][] {{2,3,1,2},{3,4,8,2},{5,6,12,5}};
		int n=a.length;
		int m=a[0].length;
		int dp[][][]=new int[n][m][m];
		for(int x[][]: dp) {
			for(int y[]:x) {
				Arrays.fill(y, -1);
			}
		}
		System.out.println(getMaxSum(a,0,0,m-1));
		System.out.println(getMaxSum(a,0,0,m-1,dp));
		System.out.println(getMaxSum(a,n,m));
	}
	
	//Recursion
	public static int getMaxSum(int arr[][], int i, int j1, int j2) {
		if(j1<0 || j1>=arr[0].length || j2<0 || j2>=arr[0].length) return Integer.MIN_VALUE;
		
		if(i==arr.length-1) {
			if(j1==j2) return arr[i][j1];
			return arr[i][j1]+arr[i][j2];
		}
		int maxi=0;
		for(int d1=-1; d1<=1; d1++) {
			for(int d2=-1; d2<=1; d2++) {
				int points=0;
				if(j1==j2) points=arr[i][j1]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				else points=arr[i][j1]+arr[i][j2]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				maxi=Math.max(maxi, points);
			}
		}
		
		return maxi;
	}
	
	//Memoization
	public static int getMaxSum(int arr[][], int i, int j1, int j2, int dp[][][]) {
		if(j1<0 || j1>=arr[0].length || j2<0 || j2>=arr[0].length) return Integer.MIN_VALUE;
		
		if(i==arr.length-1) {
			if(j1==j2) return arr[i][j1];
			return arr[i][j1]+arr[i][j2];
		}
		
		if(dp[i][j1][j1]!=-1) return dp[i][j1][j1];
		int maxi=0;
		for(int d1=-1; d1<=1; d1++) {
			for(int d2=-1; d2<=1; d2++) {
				int points=0;
				if(j1==j2) points=arr[i][j1]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				else points=arr[i][j1]+arr[i][j2]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				maxi=Math.max(maxi, points);
			}
		}
		
		return dp[i][j1][j1]=maxi;
	}
	
	//Tabulation
	public static int getMaxSum(int arr[][], int n, int m) {
		int dp[][][]=new int[n][m][m];
		
		for(int j1=0; j1<m; j1++) {
			for(int j2=m-1; j2>=0; j2--) {
				if(j1==j2) dp[n-1][j1][j2]=arr[n-1][j1];
				else dp[n-1][j1][j2]=arr[n-1][j1]+arr[n-1][j2];
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j1=0; j1<m; j1++) {
				for(int j2=m-1; j2>=0; j2--) {
					for(int d1=-1; d1<=1; d1++) {
						for(int d2=-1; d2<=1; d2++) {
							int points=0;
							if(j1==j2) points=arr[i][j1];
							else points=arr[i][j1]+arr[i][j2];
							if(j1+d1<m && j1+d1>=0 && j2+d2<m && j2+d2>=0) {
								points+=dp[i+1][j1+d1][j2+d2];
							}
							dp[i][j1][j2]=Math.max(dp[i][j1][j2], points);
						}
					}
				}
			}
		}
		
		return dp[0][0][m-1];
	}

}
