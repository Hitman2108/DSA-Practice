package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumofNonAdjacentElements {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int dp[]=new int[n];
		System.out.println(maxSum(arr,n-1));
		System.out.println(maxSum2(arr,n-1,dp));
		System.out.println(maxSum3(arr));
		System.out.println(maxSum4(arr));
		sc.close();
	}

	//Recursion
	public static int maxSum(int arr[], int n) {
		if(n==0) return arr[0];
		if(n<0) return 0;
		int take=arr[n]+maxSum(arr,n-2);
		int nonTake=maxSum(arr,n-1);
		return Math.max(take, nonTake);
	}
	
	//Memoization
	public static int maxSum2(int arr[], int n, int dp[]) {
		if(n==0) return arr[0];
		if(n<0) return 0;
		if(dp[n]!=0) return dp[n];
		int take=arr[n]+maxSum(arr,n-2);
		int nonTake=maxSum(arr,n-1);
		return dp[n]=Math.max(take, nonTake);
	}

	//Tabulation
	public static int maxSum3(int arr[]) {
		int n=arr.length;
		int dp[]=new int[n];
		dp[0]=arr[0];
		for(int i=1; i<n; i++) {
			int take=i>1?arr[i]+dp[i-2]:arr[i];
			int nonTake=dp[i-1];
			dp[i]=Math.max(take, nonTake);
		}
		return dp[n-1];
	}
	
	//Space Optimization
	public static int maxSum4(int arr[]) {
		int prev=arr[0];
		int prev2=0;
		for(int i=1; i<arr.length; i++) {
			int take=i>1?arr[i]+prev2:arr[i];
			int nonTake=prev;
			int curr=Math.max(take, nonTake);
			prev2=prev;
			prev=curr;
		}
		return prev;
	}
	
}
