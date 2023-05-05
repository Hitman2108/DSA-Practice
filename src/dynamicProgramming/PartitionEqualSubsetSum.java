package dynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int arr[]=new int[] {2,3,3,3,4,5};
		int n=arr.length;
		int sum=0;
		for(int i: arr) sum+=i;
		getTotalSetWithEqualSum(arr,n-1,sum);
	}
	
	public static void getTotalSetWithEqualSum(int arr[], int ind, int sum) {
		if(sum%2!=0) {
			System.out.println("Sets with equal sum not possible");
			return;
		}
		int target=sum/2;
		int dp[][]=new int[arr.length][target+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(getSetCount(arr,ind,target));
		System.out.println(getSetCount(arr,ind,target,dp));
		System.out.println(getSetCount(arr,target));
	}
	
	//Recursion
	public static int getSetCount(int arr[], int ind, int target) {
		if(target==0) return 1;
		if(ind==0) {
			if(target==arr[0]) return 1;
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
		if(target==0) return 1;
		if(ind==0) {
			if(target==arr[0]) return 1;
			return 0;
		}
		if(dp[ind][target]!=-1) return dp[ind][target];
		int nonTake=getSetCount(arr, ind-1, target);
		int take=0;
		if(arr[ind]<=target) {
			take=getSetCount(arr, ind-1, target-arr[ind]);
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
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<=target; j++) {
				int nonTake=dp[i-1][j];
				int take=0;
				if(arr[i]<=j) {
					take=dp[i-1][j-arr[i]];
				}
				dp[i][j]=nonTake+take;
			}
		}
		for(int x[]: dp) {
			System.out.println(Arrays.toString(x));
		}
		return dp[n-1][target];
	}

}
