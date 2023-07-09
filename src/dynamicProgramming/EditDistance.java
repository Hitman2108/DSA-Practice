package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {
	
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
		System.out.println(getMinOperations(str1, str2, n, m));
		System.out.println(getMinOperations(str1, str2, n, m, dp));
		System.out.println(getMinOperations(str1, str2));
		System.out.println(getMinOperationsWithSpaceOptimization(str1, str2));
		sc.close();
	}
	
	//Recursion
	public static int getMinOperations(String str1, String str2, int i, int j) {
		if(i==0) return j;
		if(j==0) return i;
		
		if(str1.charAt(i-1)==str2.charAt(j-1)) return getMinOperations(str1, str2, i-1, j-1);
		
		int insert=1+getMinOperations(str1, str2, i, j-1);
		int replace=1+getMinOperations(str1, str2, i-1, j-1);
		int delete=1+getMinOperations(str1, str2, i-1, j);
		
		return Math.min(insert, Math.min(replace, delete));
	}
	
	//Memoization
	public static int getMinOperations(String str1, String str2, int i, int j, int dp[][]) {
		if(i==0) return j;
		if(j==0) return i;
		if(dp[i][j]!=-1) return dp[i][j];
		if(str1.charAt(i-1)==str2.charAt(j-1)) return getMinOperations(str1, str2, i-1, j-1, dp);
		
		int insert=1+getMinOperations(str1, str2, i, j-1, dp);
		int replace=1+getMinOperations(str1, str2, i-1, j-1, dp);
		int delete=1+getMinOperations(str1, str2, i-1, j, dp);
		
		return dp[i][j]=Math.min(insert, Math.min(replace, delete));
	}
	
	//Tabulation
	public static int getMinOperations(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=0; i<=m; i++) dp[0][i]=i;
		for(int i=0; i<=n; i++) dp[i][0]=i;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) 
					dp[i][j]=dp[i-1][j-1];
				else {
					int insert=1+dp[i][j-1];
					int replace=1+dp[i-1][j-1];
					int delete=1+dp[i-1][j];
					dp[i][j]=Math.min(insert, Math.min(replace, delete));
				}
			}
		}
		
		return dp[n][m];
	}
	
	//Space Optimization
	public static int getMinOperationsWithSpaceOptimization(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int prev[]=new int[m+1];
		for(int i=0; i<=m; i++) prev[i]=i;
		
		for(int i=1; i<=n; i++) {
			int curr[]=new int[m+1];
			curr[0]=i;
			for(int j=1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) 
					curr[j]=prev[j-1];
				else {
					curr[j]=1+Math.min(prev[j], Math.min(curr[j-1], prev[j-1]));
				}
			}
			prev=curr;
		}
		
		return prev[m];
	}

}
