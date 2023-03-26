package array;

import java.util.Arrays;
import java.util.Scanner;

public class KSubArraysWithEqualSum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int arr_sum=0;
		int k=3;
		int subArrayCount=0;
		for(int i=0; i<n; i++) {
			arr_sum+=arr[i];
		}
		if(arr_sum%k==0) {
			int neededSum=arr_sum/k;
			int sum=0;
			for(int i=0; i<n; i++) {
				sum+=arr[i];
				if(sum==neededSum) {
					subArrayCount++;
					sum=0;
				}
			}
		}
		if(subArrayCount==k) {
			System.out.println("Possible");
		}
		else {
			System.out.println("Not Possible");
		}
		sc.close();
	}

}
