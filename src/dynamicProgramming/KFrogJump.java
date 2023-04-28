package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class KFrogJump {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int k=sc.nextInt();
		//Integer arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int dp[]=new int[arr.length+1];
		System.out.println(getMinEnergyLoss1(arr,arr.length-1,k));
		System.out.println(getMinEnergyLoss2(arr,arr.length-1,k,dp));
		System.out.println(getMinEnergyLoss3(arr,arr.length,k));
		sc.close();
	}
	
	//recursion
	public static int getMinEnergyLoss1(int arr[], int n, int k) {
		if(n==0) return 0;
		int minJumps=Integer.MAX_VALUE;
		for(int i=1; i<=k; i++)
		{
			if(n>=i)
			{
				int jumps=getMinEnergyLoss1(arr,n-i, k)+Math.abs(arr[n]-arr[n-i]);
				minJumps=Math.min(minJumps, jumps);
			}
		}
		
		return minJumps;
	}
	
	//Recursion with memoization
	public static int getMinEnergyLoss2(int arr[], int n, int k, int dp[]) {
		if(n==0) return 0;
		if(dp[n]!=0) return dp[n];
		int minJumps=Integer.MAX_VALUE;
		for(int i=1; i<=k; i++)
		{
			if(n>=i)
			{
				int jumps=getMinEnergyLoss1(arr,n-i, k)+Math.abs(arr[n]-arr[n-i]);
				minJumps=Math.min(minJumps, jumps);
			}
		}
		
		return dp[n]=minJumps;
	}
	
	//Tabulation
	public static int getMinEnergyLoss3(int arr[], int n, int k) {
		int dp[]=new int[n];
		dp[0]=0;
		
		for(int i=1; i<n; i++) {
			int minJumps=Integer.MAX_VALUE;
			for(int j=1; j<=k; j++)
			{
				if(i>=j)
				{
					int jumps=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
					minJumps=Math.min(minJumps, jumps);
				}
			}
			dp[i]=minJumps;
		}
		
		return dp[n-1];
	}

}
