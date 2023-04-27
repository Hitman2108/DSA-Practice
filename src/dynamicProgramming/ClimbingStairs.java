package dynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		int dp[]=new int[n+1];
		System.out.println(getCount(n,count));
		System.out.println(getCount1(n,dp));
		System.out.println(getCount2(n,dp));
		System.out.println(getCount3(n));
		sc.close();
	}
	
	//Recursion
		public static int getCount(int n, int count) {
			if(n<=0) {
				if(n==0) {
					return 1;
				}
				return 0;
			}
			count=getCount(n-1,count);
			count+=getCount(n-2,count);
			
			return count;
		}
		
		//Recursion with memoization
		public static int getCount1(int n, int dp[]) {
			if(n==0) return 1;
			if(n<0) return 0;
			if(dp[n]!=0) return dp[n];
			return dp[n]=getCount1(n-1,dp)+getCount1(n-2,dp) ;
		}
		
		//Tabulation
		public static int getCount2(int n, int dp[]) {
			dp[0]=1;
			dp[1]=1;
			
			for(int i=2; i<=n; i++) {
				dp[i]=dp[i-1]+dp[i-2];
			}
			
			return dp[n];
		}
		
		//Tabulation with space optimization
		public static int getCount3(int n) {
			int prev=1;
			int prev2=1;
				
			for(int i=2; i<=n; i++) {
				int curr=prev+prev2;
				prev2=prev;
				prev=curr;
			}
				
			return prev;
		}

}
