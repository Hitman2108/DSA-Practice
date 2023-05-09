package dynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3};
		int target=7;
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(getMinCoins(arr, n-1, target));
		System.out.println(getMinCoins(arr, n-1, target, dp));
		System.out.println(getMinCoins(arr, target));
	}
	
	//Recursion
	public static int getMinCoins(int arr[], int ind, int target) {
		if(ind==0) {
			if(target%arr[0]==0) return target/arr[0];
			return (int) Math.pow(10, 9);
		}
		
		int nontake=getMinCoins(arr, ind-1, target);
		int take=(int) Math.pow(10, 9);
		if(arr[ind]<=target) {
			take=1+getMinCoins(arr, ind, target-arr[ind]);
		}
		
		return Math.min(take, nontake);
	}
	
	//Memoization
	public static int getMinCoins(int arr[], int ind, int target, int dp[][]) {
		if(ind==0) {
			if(target%arr[0]==0) return target/arr[0];
			return (int) Math.pow(10, 9);
		}
		if(dp[ind][target]!=-1) return dp[ind][target];
		int nontake=getMinCoins(arr, ind-1, target, dp);
		int take=(int) Math.pow(10, 9);
		if(arr[ind]<=target) {
			take=1+getMinCoins(arr, ind, target-arr[ind], dp);
		}
		
		return dp[ind][target]=Math.min(take, nontake);
	}
	
	//Tabulation
	public static int getMinCoins(int arr[], int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i=0; i<=target; i++) {
			if(i%arr[0]==0) dp[0][i]=i/arr[0];
			else dp[0][i]=(int) Math.pow(10, 9);
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=target; j++) {
				int nontake=dp[i-1][j];
				int take=(int) Math.pow(10, 9);
				if(arr[i]<=j) {
					take=1+dp[i][j-arr[i]];
				}
				dp[i][j]=Math.min(take, nontake);
			}
		}
		
		return dp[n-1][target];
	}

}
