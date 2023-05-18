package dynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int n=str1.length();
		int m=str2.length();
		System.out.println(getLengthOfLongestCommonSubsequence(n-1,m-1,str1,str2));
		sc.close();
	}

	public static int getLengthOfLongestCommonSubsequence(int ind1, int ind2, String str1, String str2) {
		if(ind1<0 || ind2<0) return 0;
		if(str1.charAt(ind1)==str2.charAt(ind2)) {
			return 1+getLengthOfLongestCommonSubsequence(ind1-1, ind2-1, str1, str2);
		}
		else {
			int move1=getLengthOfLongestCommonSubsequence(ind1-1, ind2, str1, str2);
			int move2=getLengthOfLongestCommonSubsequence(ind1, ind2-1, str1, str2);
			return Math.max(move1, move2);
		}
	}

}
