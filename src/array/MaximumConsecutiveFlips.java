package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumConsecutiveFlips {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int ones_count=0;
		int zeroes_count=0;
		for(int i=0; i<n; i++) {
			if(arr[i]==1) ones_count++;
			else zeroes_count++;
		}
		
		if(zeroes_count!=0 && ones_count!=0) {
			int groupToFlip=ones_count<zeroes_count?1:0;
			int startIndex=-1;
			for(int i=0; i<n; i++) {
				if(arr[i]==groupToFlip && startIndex==-1) {
					startIndex=i;
				}
				else if(arr[i]!=groupToFlip && startIndex!=-1){
					System.out.println("From "+startIndex+" to "+(i-1));
					startIndex=-1;
				}
			}
		}
		
		sc.close();
	}

}
