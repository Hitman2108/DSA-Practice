package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		str=str.replaceAll("\\s", "");
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int sumArray[]=new int[n];
		sumArray[0]=arr[0];
		int ith_sum=arr[0];
		int maxSum=arr[0];
		int start=0, end=0;
		for(int i=1; i<n; i++) {
//			ith_sum=sumArray[i-1]+arr[i];
			ith_sum+=arr[i];
			if(ith_sum>arr[i]) {
//				sumArray[i]=ith_sum;
				
//				maxSum=Math.max(maxSum, ith_sum);
				if(maxSum<ith_sum) {
					maxSum=ith_sum;
					end=i;
				}
			}
			else {
				ith_sum=arr[i];
//				maxSum=Math.max(maxSum, arr[i]);
				if(maxSum<ith_sum) {
					maxSum=ith_sum;
					start=i;
					end=i;
				}
			}
//			ith_sum=Math.max(ith_sum+arr[i], arr[i]);
//			maxSum=Math.max(maxSum, ith_sum);
		}
		System.out.println("maxSum "+maxSum+" start "+start+" end "+end);
		sc.close();
	}
}
