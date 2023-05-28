package dynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubstring {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		System.out.println(getLengthOfLongestCommonSubsequence(str1,str2));
//		System.out.println(getLengthOfLongestCommonSubsequenceSpaceOptimization(str1,str2));
		sc.close();
	}
	
	public static int getLengthOfLongestCommonSubsequence(String str1, String str2) {
		int n=str1.length();
		int m=str2.length();
		int dp[][]=new int[n+1][m+1];
		int ans=0;
		int row=0;
		int col=0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
					if(dp[i][j]>ans) {
						ans=dp[i][j];
						row=i;
						col=j;
					}
				}
			}
		}
		
		while(dp[row][col]!=0) {
			System.out.print(str1.charAt(row-1));
			row--;
			col--;
		}
		System.out.println();
		return ans;
	}

}
