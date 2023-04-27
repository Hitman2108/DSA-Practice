package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int low=0, high=arr.length-1;
		int maxWater=0;
		while(low<high) {
			int minValue=Math.min(arr[low], arr[high]);
			maxWater=Math.max(maxWater, minValue*(high-low-1));
			if(arr[low]>arr[high]) high--;
			else low++;
		}
		System.out.println(maxWater);
		sc.close();
	}

}
