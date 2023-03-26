package array;

import java.util.Arrays;
import java.util.Scanner;

public class PrefixSum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int prefixSumArr[]=new int[n];
		prefixSumArr[0]=arr[0];
		for(int i=1; i<n; i++) {
			prefixSumArr[i]=prefixSumArr[i-1]+arr[i];
		}
		int i=2;
		int j=5;
		System.out.println(getSum(i,j,prefixSumArr));
		sc.close();
	}
	
	public static int getSum(int i, int j, int prefixSumArr[]) {
		if(i==0) return prefixSumArr[j];
		return prefixSumArr[j]-prefixSumArr[i-1];
	}

}
