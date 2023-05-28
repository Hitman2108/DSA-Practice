package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i[]: dp) {
			Arrays.fill(i, -1);
		}
		System.out.println(getNumberOfDistinctSequences(str1, str2, n, m));
		System.out.println(getNumberOfDistinctSequences(str1, str2, n, m, dp));
		System.out.println(getNumberOfDistinctSequences(str1, str2));
		System.out.println(getNumberOfDistinctSequencesWithSpaceOptimization(str1, str2));
		sc.close();
	}
	
	//Recursion
	public static int getNumberOfDistinctSequences(String str1, String str2, int n, int m) {
		if(m==0) return 1;
		if(n==0) return 0;
		int match=0;
		if(str1.charAt(n-1)==str2.charAt(m-1)) {
			match=getNumberOfDistinctSequences(str1, str2, n-1, m-1);
		}
		int nonmatch=getNumberOfDistinctSequences(str1, str2, n-1, m);
		
		return match+nonmatch;
	}
	
	//Memoization
	public static int getNumberOfDistinctSequences(String str1, String str2, int n, int m, int dp[][]) {
		if(m==0) return 1;
		if(n==0) return 0;
		if(dp[n][m]!=-1) return dp[n][m];
		int match=0;
		if(str1.charAt(n-1)==str2.charAt(m-1)) {
			match=getNumberOfDistinctSequences(str1, str2, n-1, m-1, dp);
		}
		int nonmatch=getNumberOfDistinctSequences(str1, str2, n-1, m, dp);
		
		return dp[n][m]=match+nonmatch;
	}
	
	//Tabulation
	public static int getNumberOfDistinctSequences(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=0; i<=n; i++) dp[i][0]=1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				int match=0;
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					match=dp[i-1][j-1];
				}
				int nonmatch=dp[i-1][j];
				dp[i][j]=match+nonmatch;
			}
		}
		
		return dp[n][m];
	}
	
	//Space Optimization
	public static int getNumberOfDistinctSequencesWithSpaceOptimization(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[]=new int[m+1];
		dp[0]=1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[j]=dp[j]+dp[j-1];
				}
			}
		}
		
		return dp[m];
	}

}
