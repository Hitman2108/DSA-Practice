package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumConsecutive1s {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int maxCount=0, count=0;
		for(int i=0; i<n; i++) {
			if(arr[i]==1) {
				count++;
			}
			else {
				maxCount=Math.max(maxCount, count);
				count=0;
			}
		}
		maxCount=Math.max(maxCount, count);
		System.out.println(maxCount);
		sc.close();
	}

}
