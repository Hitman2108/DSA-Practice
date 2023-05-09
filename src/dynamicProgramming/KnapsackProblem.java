package dynamicProgramming;

import java.util.Arrays;

//0-1 knapsack
public class KnapsackProblem {
	
	public static void main(String[] args) {
		int wt[]=new int[] {4,5,1};
		int val[]=new int[] {1,2,3};
		int n=wt.length;
		int w=4;
		int dp[][]=new int[n][w+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(getMaxProfit(n-1,w,wt,val));
		System.out.println(getMaxProfit(n-1,w,wt,val,dp));
		System.out.println(getMaxProfit(w,wt,val));
		System.out.println(getMaxProfit1(w,wt,val));
		System.out.println(getMaxProfit2(w,wt,val));
	}
	
	//Recursion
	public static int getMaxProfit(int ind, int w, int wt[], int val[]) {
		if(ind==0) {
			if(wt[ind]<=w) return val[0];
			return 0;
		}
		
		int nonpick=getMaxProfit(ind-1, w, wt, val);
		int pick=(int)Math.pow(-10, 9);
		if(wt[ind]<=w) {
			pick=val[ind]+getMaxProfit(ind-1, w-wt[ind], wt, val);
		}
		
		return Math.max(nonpick, pick);
	}
	
	//Memoization
	public static int getMaxProfit(int ind, int w, int wt[], int val[], int dp[][]) {
		if(ind==0) {
			if(wt[ind]<=w) return val[0];
			return 0;
		}
		if(dp[ind][w]!=-1) return dp[ind][w];
		int nonpick=getMaxProfit(ind-1, w, wt, val, dp);
		int pick=(int)Math.pow(-10, 9);
		if(wt[ind]<=w) {
			pick=val[ind]+getMaxProfit(ind-1, w-wt[ind], wt, val, dp);
		}
		
		return dp[ind][w]=Math.max(nonpick, pick);
	}
	
	//Tabulation
	public static int getMaxProfit(int w, int wt[], int val[]) {
		int n=wt.length;
		int dp[][]=new int[n][w+1];
		for(int i=wt[0]; i<=w; i++) {
			dp[0][i]=val[0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=w; j++) {
				int nonpick=dp[i-1][j];
				int pick=(int)Math.pow(-10, 9);
				if(wt[i]<=j) {
					pick=val[i]+dp[i-1][j-wt[i]];
				}
				dp[i][j]=Math.max(nonpick, pick);
			}
		}
		
		return dp[n-1][w];
	}
	
	//Space Optimization 2d array
	public static int getMaxProfit1(int w, int wt[], int val[]) {
		int n=wt.length;
		int prev[]=new int[w+1];
		for(int i=wt[0]; i<=w; i++) {
			prev[i]=val[0];
		}
		
		for(int i=1; i<n; i++) {
			int curr[]=new int[w+1];
			for(int j=0; j<=w; j++) {
				int nonpick=prev[j];
				int pick=(int)Math.pow(-10, 9);
				if(wt[i]<=j) {
					pick=val[i]+prev[j-wt[i]];
				}
				curr[j]=Math.max(nonpick, pick);
			}
			prev=curr;
		}
		
		return prev[w];
	}
	
	//Space Optimization 1d array
	public static int getMaxProfit2(int w, int wt[], int val[]) {
		int n=wt.length;
		int curr[]=new int[w+1];
		for(int i=wt[0]; i<=w; i++) {
			curr[i]=val[0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=w; j>=0; j--) {
				int nonpick=curr[j];
				int pick=(int)Math.pow(-10, 9);
				if(wt[i]<=j) {
					pick=val[i]+curr[j-wt[i]];
				}
				curr[j]=Math.max(nonpick, pick);
			}
		}
		
		return curr[w];
	}
	
}
