package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class LastIndexOfOccurence {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int x=sc.nextInt();
		int [] arr=Arrays.stream(str.split(",")).mapToInt(Integer:: parseInt).toArray();
		int n=arr.length;
		System.out.println(getLastIndex(arr,n,x));
		sc.close();
	}
	
	public static int getLastIndex(int arr[], int n, int x) {
		int low=0;
		int high=n-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==x && (mid==n-1 || arr[mid+1]!=arr[mid])) return mid;
			else if(arr[mid]>x) high=mid-1;
			else low=mid+1;
		}
		
		return -1;
	}

}