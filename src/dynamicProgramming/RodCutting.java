package dynamicProgramming;

import java.util.Arrays;

public class RodCutting {
	
	public static void main(String[] args) {
		int len=5;
		int price[]= {3,10,7,8,10};
		int dp[][]=new int[len][len+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(maxProfit(len-1, len, price));
		System.out.println(maxProfit(len-1, len, price, dp));
		System.out.println(maxProfit(len, price));
		System.out.println(maxProfitWithSpaceOptimization(len, price));
		System.out.println(getMaxProfitWithSingleArraySpaceOptimization(len, price));
	}
	
	//Recursion
	public static int maxProfit(int ind, int N, int price[]) {
		if(ind==0) {
			return N*price[0];
		}
		
		int nonTake=maxProfit(ind-1, N, price);
		int take=(int)Math.pow(-10, 9);
		int m=ind+1;
		if(m<=N) {
			take=price[ind]+maxProfit(ind, N-m, price);
		}
		
		return Math.max(take, nonTake);
	}
	
	//Memoization
	public static int maxProfit(int ind, int N, int price[], int dp[][]) {
		if(ind==0) {
			return N*price[0];
		}
		if(dp[ind][N]!=-1) return dp[ind][N];
		int nonTake=maxProfit(ind-1, N, price);
		int take=(int)Math.pow(-10, 9);
		int m=ind+1;
		if(m<=N) {
			take=price[ind]+maxProfit(ind, N-m, price);
		}
		
		return dp[ind][N]=Math.max(take, nonTake);
	}
	
	//Tabulation
	public static int maxProfit(int N, int price[]) {
		int dp[][]=new int[N][N+1];
		for(int i=0; i<=N; i++) {
			dp[0][i]=i*price[0];
		}
		
		for(int ind=1; ind<N; ind++) {
			for(int j=0; j<=N; j++) {
				int nonTake=dp[ind-1][j];
				int take=(int)Math.pow(-10, 9);
				int m=ind+1;
				if(m<=j) {
					take=price[ind]+dp[ind][j-m];
				}
				dp[ind][j]=Math.max(take, nonTake);
			}
		}
		
		return dp[N-1][N];
	}
	
	//Space Optimization 2 Arrays
	public static int maxProfitWithSpaceOptimization(int N, int price[]) {
		int prev[]=new int[N+1];
		int curr[]=new int[N+1];
		for(int i=0; i<=N; i++) {
			prev[i]=i*price[0];
		}
		
		for(int ind=1; ind<N; ind++) {
			for(int j=0; j<=N; j++) {
				int nonTake=prev[j];
				int take=(int)Math.pow(-10, 9);
				int m=ind+1;
				if(m<=j) {
					take=price[ind]+curr[j-m];
				}
				curr[j]=Math.max(take, nonTake);
			}
			prev=curr;
		}
		
		return prev[N];
	}
	
	//Space Optimization 1 Array
	public static int getMaxProfitWithSingleArraySpaceOptimization(int N, int price[]) {
		int prev[]=new int[N+1];
		for(int i=0; i<=N; i++) {
			prev[i]=i*price[0];
		}
		
		for(int ind=1; ind<N; ind++) {
			for(int j=0; j<=N; j++) {
				int nonTake=prev[j];
				int take=(int)Math.pow(-10, 9);
				int m=ind+1;
				if(m<=j) {
					take=price[ind]+prev[j-m];
				}
				prev[j]=Math.max(take, nonTake);
			}
		}
		
		return prev[N];
	}

}
