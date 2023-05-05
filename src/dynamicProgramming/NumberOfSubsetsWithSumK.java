package dynamicProgramming;

import java.util.Arrays;

public class NumberOfSubsetsWithSumK {
	
	public static void main(String[] args) {
		int arr[]=new int[] {0,1};
		int n=arr.length;
		int k=1;
		int dp[][]=new int[arr.length][k+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(getSetCount(arr,n-1,k));
		System.out.println(getSetCount(arr,n-1,k,dp));
		System.out.println(getSetCount(arr,k));
	}
	
	//Recursion
	public static int getSetCount(int arr[], int ind, int target) {
		if(ind==-1) {
			if(target==0) return 1;
			return 0;
		}
		
		int nonTake=getSetCount(arr, ind-1, target);
		int take=0;
		if(arr[ind]<=target) {
			take=getSetCount(arr, ind-1, target-arr[ind]);
		}
		
		return nonTake+take;
	}
	
	//Memoization
	public static int getSetCount(int arr[], int ind, int target, int dp[][]) {
		if(ind==-1) {
			if(target==0) return 1;
			return 0;
		}
		if(dp[ind][target]!=-1) return dp[ind][target];
		int nonTake=getSetCount(arr, ind-1, target, dp);
		int take=0;
		if(arr[ind]<=target) {
			take=getSetCount(arr, ind-1, target-arr[ind], dp);
		}
		
		return dp[ind][target]=nonTake+take;
	}
	
	//Tabulation
	public static int getSetCount(int arr[], int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i=0; i<n; i++) {
			dp[i][0]=1;
		}
		if(arr[0]<=target) dp[0][arr[0]]=1;
		if(arr[0]==0) dp[0][0]=2;
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=target; j++) {
				int nonTake=dp[i-1][j];
				int take=0;
				if(arr[i]<=j) {
					take=dp[i-1][j-arr[i]];
				}
				dp[i][j]=nonTake+take;
			}
		}
		
		return dp[n-1][target];
	}

}
