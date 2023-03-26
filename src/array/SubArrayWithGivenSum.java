package array;

import java.util.Arrays;
import java.util.Scanner;

public class SubArrayWithGivenSum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int sum=45;
		int curr_sum=0;
		int j=0;
		String isSumPresent="NO";
		for(int i=0; i<n; i++) {
			curr_sum+=arr[i];
			while(curr_sum>sum) {
				curr_sum-=arr[j];
				j++;
			}
			if(curr_sum==sum) {
				isSumPresent="YES";
				break;
			}
		}
		
		System.out.println(isSumPresent);
		
		sc.close();
	}

}