package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
	
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
		System.out.println(getLengthOfLongestCommonSubsequence(n,m,str1,str2));
		System.out.println(getLengthOfLongestCommonSubsequence(n,m,str1,str2,dp));
		System.out.println(getLengthOfLongestCommonSubsequence(str1,str2));
		System.out.println(getLengthOfLongestCommonSubsequenceSpaceOptimization(str1,str2));
		sc.close();
	}

	//Recursion
	public static int getLengthOfLongestCommonSubsequence(int ind1, int ind2, String str1, String str2) {
		if(ind1==0 || ind2==0) return 0;
		if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) {
			return 1+getLengthOfLongestCommonSubsequence(ind1-1, ind2-1, str1, str2);
		}
		else {
			int move1=getLengthOfLongestCommonSubsequence(ind1-1, ind2, str1, str2);
			int move2=getLengthOfLongestCommonSubsequence(ind1, ind2-1, str1, str2);
			return Math.max(move1, move2);
		}
	}
	
	//Memoization
	public static int getLengthOfLongestCommonSubsequence(int ind1, int ind2, String str1, String str2, int dp[][]) {
		if(ind1==0 || ind2==0) return 0;
		if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
		if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) {
			return dp[ind1][ind2]=1+getLengthOfLongestCommonSubsequence(ind1-1, ind2-1, str1, str2, dp);
		}
		else {
			int move1=getLengthOfLongestCommonSubsequence(ind1-1, ind2, str1, str2, dp);
			int move2=getLengthOfLongestCommonSubsequence(ind1, ind2-1, str1, str2, dp);
			return dp[ind1][ind2]=Math.max(move1, move2);
		}
	}
	
	//Tabulation
	public static int getLengthOfLongestCommonSubsequence(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		
		for(int ind1=1; ind1<=n; ind1++) {
			for(int ind2=1; ind2<=m; ind2++) {
				if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) {
					dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
				}
				else {
					int move1=dp[ind1-1][ind2];
					int move2=dp[ind1][ind2-1];
					dp[ind1][ind2]=Math.max(move1, move2);
				}
			}
		}
		
		return dp[n][m];
	}
	
	//Space Optimization
	public static int getLengthOfLongestCommonSubsequenceSpaceOptimization(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int prev[]=new int[m+1];
		String str="";
		for(int ind1=1; ind1<=n; ind1++) {
			int curr[]=new int[m+1];
			for(int ind2=1; ind2<=m; ind2++) {
				if(str1.charAt(ind1-1)==str2.charAt(ind2-1)) {
					str+=str1.charAt(ind1-1);
					curr[ind2]=1+prev[ind2-1];
				}
				else {
					int move1=prev[ind2];
					int move2=curr[ind2-1];
					curr[ind2]=Math.max(move1, move2);
				}
			}
			prev=curr;
		}
		
		System.out.println(str);
		
		return prev[m];
	}

}
