package dynamicProgramming;

import java.util.Arrays;

public class MazeObstacles {
	
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
		int a[][]=new int[][] {{0,0,0}, {0,0,0}, {0,0,0}};
		int n=a.length;
		int m=a[0].length;
		int dp[][]=new int[n][m];
		for(int b[]: dp) {
			Arrays.fill(b, -1);
		}
		System.out.println(totalPaths(a,n-1,m-1));
		System.out.println(totalPaths1(a,n-1,m-1,dp));
		System.out.println(totalPaths2(a,n-1,m-1));
		System.out.println(totalPaths3(a,n-1,m-1));
	}

	//Recursion
	public static int totalPaths(int a[][], int i, int j) {
		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;
		if(a[i][j]==-1) return 0;
		int left=totalPaths(a,i,j-1);
		int up=totalPaths(a,i-1,j);
		return left+up;
	}
	
	//Memoization
	public static int totalPaths1(int a[][], int i, int j, int dp[][]) {
		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;
		if(a[i][j]==-1) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int left=totalPaths(a,i,j-1);
		int up=totalPaths(a,i-1,j);
		return dp[i][j]=left+up;
	}
	
	//Tabulation
	public static int totalPaths2(int a[][], int n, int m) {
		int dp[][]=new int[n+1][m+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(a[i][j]==-1) dp[i][j]=0;
				else if(i==0 && j==0) dp[i][j]=1;
				else {
					int left=0;
					int up=0;
					if(j>0) left=dp[i][j-1];
					if(i>0) up=dp[i-1][j];
					dp[i][j]=left+up;
				}
			}
		}
		
		return dp[n][m];
	}
	
	//Space Optimization
	public static int totalPaths3(int a[][], int n, int m) {
		int prev[]=new int[n+1];
		for(int i=0; i<=n; i++) {
			int curr[]=new int[n+1];
			for(int j=0; j<=m; j++) {
				if(a[i][j]==-1) curr[j]=0;
				else if(i==0 && j==0) curr[j]=1;
				else {
					int left=0;
					int up=0;
					if(j>0) left=curr[j-1];
					if(i>0) up=prev[j];
					curr[j]=left+up;
				}
			}
			prev=curr;
		}
		
		return prev[n];
	}

}
