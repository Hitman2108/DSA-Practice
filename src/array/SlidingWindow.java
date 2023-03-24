package array;

import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindow {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int sum=0;
		int k=2;
		for(int i=0; i<k; i++) {
			sum+=arr[i];
		}
		int maxSum=sum;
		for(int i=k; i<n; i++) {
			sum+=arr[i]-arr[i-k];
			maxSum=Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);
	}

}
