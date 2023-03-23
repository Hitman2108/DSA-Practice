package array;

import java.util.Arrays;
import java.util.Scanner;

public class StockBuyAndSell {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int profit=0;
		for(int i=1; i<n; i++) {
			if(arr[i]>arr[i-1]) {
				profit+=arr[i]-arr[i-1];
			}
		}
		System.out.println(profit);
		sc.close();
	}

}
