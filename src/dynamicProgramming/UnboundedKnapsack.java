package dynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
	
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
		System.out.println(getMaxProfitWithSpaceOptimization(w,wt,val));
		System.out.println(getMaxProfitWithSingleArraySpaceOptimization(w,wt,val));
	}

	//Recursion
	public static int getMaxProfit(int i, int w, int[] wt, int[] val) {
		if(i==0) {
			return (w/wt[0])*val[0];
		}
		int nonTake=getMaxProfit(i-1, w, wt, val);
		int take=0;
		if(wt[i]<=w) {
			take=val[i]+getMaxProfit(i, w-wt[i], wt, val);
		}
		
		return Math.max(nonTake, take);
	}
	
	//Memoization
	public static int getMaxProfit(int ind, int w, int wt[], int val[], int dp[][]) {
		if(ind==0) {
			return (w/wt[0])*val[0];
		}
		if(dp[ind][w]!=-1) return dp[ind][w];
		int nonpick=getMaxProfit(ind-1, w, wt, val, dp);
		int pick=(int)Math.pow(-10, 9);
		if(wt[ind]<=w) {
			pick=val[ind]+getMaxProfit(ind, w-wt[ind], wt, val, dp);
		}
		
		return dp[ind][w]=Math.max(nonpick, pick);
	}
	
	//Tabulation
	public static int getMaxProfit(int w, int wt[], int val[]) {
		int n=wt.length;
		int dp[][]=new int[n][w+1];
		for(int i=0; i<=w; i++) {
			dp[0][i]=(i/wt[0])*val[0];
		}
		for(int ind=1; ind<n; ind++) {
			for(int j=0; j<=w; j++) {
				int nonpick=dp[ind-1][j];
				int pick=0;
				if(wt[ind]<=j) {
					pick=val[ind]+dp[ind][j-wt[ind]];
				}
				dp[ind][j]=Math.max(nonpick, pick);
			}
		}
		
		return dp[n-1][w];
	}
	
	//Space Optimization 2 Arrays
	public static int getMaxProfitWithSpaceOptimization(int w, int wt[], int val[]) {
		int n=wt.length;
		int prev[]=new int[w+1];
		for(int i=0; i<=w; i++) {
			prev[i]=(i/wt[0])*val[0];
		}
		for(int ind=1; ind<n; ind++) {
			int curr[]=new int[w+1];
			for(int j=0; j<=w; j++) {
				int nonpick=prev[j];
				int pick=0;
				if(wt[ind]<=j) {
					pick=val[ind]+curr[j-wt[ind]];
				}
				curr[j]=Math.max(nonpick, pick);
			}
			prev=curr;
		}
		
		return prev[w];
	}

	//Space Optimization 1 Array
	public static int getMaxProfitWithSingleArraySpaceOptimization(int w, int wt[], int val[]) {
		int n=wt.length;
		int prev[]=new int[w+1];
		for(int i=0; i<=w; i++) {
			prev[i]=(i/wt[0])*val[0];
		}
		for(int ind=1; ind<n; ind++) {
			for(int j=0; j<=w; j++) {
				int nonpick=prev[j];
				int pick=0;
				if(wt[ind]<=j) {
					pick=val[ind]+prev[j-wt[ind]];
				}
				prev[j]=Math.max(nonpick, pick);
			}
		}
		
		return prev[w];
	}
}
