package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class PeakElement {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		System.out.println(getPeakElement(arr,n));
		sc.close();
	}
	
	public static int getPeakElement(int arr[], int n) {
		int low=0, high=n-1;
		while(low<high) {
			int mid=(low+high)/2;
			if(arr[mid]<arr[mid+1]) {
				low=mid+1;
			}
			else {
				high=mid;
			}
		}
		
		return low;
	}

}
