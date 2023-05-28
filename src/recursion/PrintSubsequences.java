package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintSubsequences {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int n=str.length();
		ArrayList<String> list=new ArrayList<>();
		subsequences(str,"",n,list);
		System.out.println(list);
		System.out.println(list.size());
		countSubsequences(str,n);
		sc.close();
	}
	
	public static void subsequences(String ip, String op, int ind, ArrayList<String> list) {
		if(ip.length()==0) {
			if(!list.contains(op)) list.add(op);
			return;
		}
		subsequences(ip.substring(0,ind-1), op, ind-1, list);
		subsequences(ip.substring(0,ind-1), ip.charAt(ind-1)+op, ind-1, list);
	}
	
	public static void countSubsequences(String str, int ind) {
		int dp[]=new int[ind+1];
		dp[0]=1;
		Map<Character, Integer> map=new HashMap<>();
		for(int i=1; i<=ind; i++) {
			dp[i]=2*dp[i-1];
			char ch=str.charAt(i-1);
			if(map.containsKey(ch)) {
				int j=map.get(ch);
				dp[i]=dp[i]-dp[j-1];
			}
			map.put(ch, i);
		}
		
		System.out.println(dp[ind]);
	}

}
