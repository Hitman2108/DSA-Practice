package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxDifferenceInAnArray {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int result=arr[1]-arr[0];
		int min=arr[0];
		for(int i=1; i<arr.length; i++) {
			result=Math.max(result, arr[i]-min);
			min=Math.min(min, arr[i]);
		}
		System.out.println(result);
		sc.close();
	}

}
