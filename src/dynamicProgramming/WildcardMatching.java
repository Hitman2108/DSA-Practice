package dynamicProgramming;

import java.util.Scanner;

public class WildcardMatching {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String pattern=sc.nextLine();
		String text=sc.nextLine();
		int n=pattern.length();
		int m=text.length();
		boolean dp[][]=new boolean[n+1][m+1];
		
		System.out.println(areStringMatching(pattern, text, n, m));
		System.out.println(areStringMatching(pattern, text, n, m, dp));
		System.out.println(areStringMatching(pattern, text));
//		System.out.println(getMinOperations(str1, str2));
//		System.out.println(getMinOperationsWithSpaceOptimization(str1, str2));
		sc.close();
	}
	
	public static boolean areStringMatching(String pattern, String text, int i, int j) {
		if(i==0 && j==0) return true;
		if(i==0 && j>0) return false;
		if(i>0 && j==0) {
			for(int k=0; k<i; i++) {
				if(pattern.charAt(k)!='*') return false;
			}
			return true;
		}
		
		if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?') {
			return areStringMatching(pattern, text, i-1, j-1);
		}
		if(pattern.charAt(i-1)=='*') {
			return areStringMatching(pattern, text, i-1, j) || areStringMatching(pattern, text, i, j-1);
		}
		
		return false;
	}
	
	
	public static boolean areStringMatching(String pattern, String text, int i, int j, boolean dp[][]) {
		if(i==0 && j==0) return true;
		if(i==0 && j>0) return false;
		if(i>0 && j==0) {
			for(int k=0; k<i; i++) {
				if(pattern.charAt(k)!='*') return false;
			}
			return true;
		}
		
		if(dp[i][j]!=false) return dp[i][j];
		
		if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?') {
			return dp[i][j]=areStringMatching(pattern, text, i-1, j-1, dp);
		}
		if(pattern.charAt(i-1)=='*') {
			return dp[i][j]=areStringMatching(pattern, text, i-1, j, dp) || areStringMatching(pattern, text, i, j-1, dp);
		}
		
		return dp[i][j]=false;
	}
	
	public static boolean areStringMatching(String pattern, String text) {
		int n=pattern.length();
		int m=text.length();
		boolean dp[][]=new boolean[n+1][m+1];
		dp[0][0]=true;
		for(int j=1; j<=m; j++) dp[0][j]=false;
		for(int i=1; i<=n; i++){
			boolean flag=true;
			for(int k=0; k<i; i++) {
				if(pattern.charAt(k)!='*') {
					flag=false;
					break;
				}
			}
			dp[i][0]=flag;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?') {
					dp[i][j]=dp[i-1][j-1];
				}
				if(pattern.charAt(i-1)=='*') {
					dp[i][j]=dp[i-1][j] || dp[i][j-1];
				}
				else dp[i][j]=false;
			}
		}
		
		return dp[n][m];
	
	}

}
