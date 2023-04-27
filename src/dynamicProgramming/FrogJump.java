package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJump {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		//Integer arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int dp[]=new int[arr.length+1];
		System.out.println(getMinEnergyLoss(arr,arr.length-1,0,0));
		System.out.println(getMinEnergyLoss1(arr,arr.length-1));
		System.out.println(getMinEnergyLoss2(arr,arr.length-1,dp));
		System.out.println(getMinEnergyLoss3(arr,arr.length));
		System.out.println(getMinEnergyLoss4(arr,arr.length));
		sc.close();
	}
	
	//recursion
	public static int getMinEnergyLoss(int arr[], int n, int ind, int sum) {
		if(ind>=n) {
			return sum;
		}
		int left=getMinEnergyLoss(arr,n,ind+1,sum+Math.abs(arr[ind]-arr[ind+1]));
		int right=Integer.MAX_VALUE;
		if(ind<n-1) {
			right=getMinEnergyLoss(arr,n,ind+2,sum+Math.abs(arr[ind]-arr[ind+2]));
		}
		
		return Math.min(left, right);
	}
	
	//recursion
	public static int getMinEnergyLoss1(int arr[], int n) {
		if(n==0) return 0;
		int left=getMinEnergyLoss1(arr,n-1)+Math.abs(arr[n]-arr[n-1]);
		int right=Integer.MAX_VALUE;
		if(n>1) {
			right=getMinEnergyLoss1(arr,n-2)+Math.abs(arr[n]-arr[n-2]);
		}
		
		return Math.min(left, right);
	}
	
	//Recursion with memoization
	public static int getMinEnergyLoss2(int arr[], int n, int dp[]) {
		if(n==0) return 0;
		if(dp[n]!=0) return dp[n];
		int left=getMinEnergyLoss2(arr,n-1,dp)+Math.abs(arr[n]-arr[n-1]);
		int right=Integer.MAX_VALUE;
		if(n>1) {
			right=getMinEnergyLoss2(arr,n-2,dp)+Math.abs(arr[n]-arr[n-2]);
		}
		
		return dp[n]=Math.min(left, right);
	}
	
	//Tabulation
	public static int getMinEnergyLoss3(int arr[], int n) {
		int dp[]=new int[n];
		dp[0]=0;
		for(int i=1; i<n; i++) {
			int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
			int right=Integer.MAX_VALUE;
			if(i>1) {
				right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
			}
			dp[i]=Math.min(left, right);
		}
		
		return dp[n-1];
	}

	//Space Optimization
	public static int getMinEnergyLoss4(int arr[], int n) {
		int prev=0;
		int prev2=0;
		for(int i=1; i<n; i++) {
			int left=prev+Math.abs(arr[i]-arr[i-1]);
			int right=Integer.MAX_VALUE;
			if(i>1) {
				right=prev2+Math.abs(arr[i]-arr[i-2]);
			}
			int curr=Math.min(left, right);
			prev2=prev;
			prev=curr;
		}
		
		return prev;
	}

}
