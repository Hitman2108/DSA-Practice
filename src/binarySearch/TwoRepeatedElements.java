package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class TwoRepeatedElements {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		//Integer[] arr=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		int[] arr=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int a[]=new int [2];
		int j=0;
		for(int i=0; i<arr.length && j<2; i++) {
			int index=Math.abs(arr[i]);
			if(arr[index-1]>0) arr[index-1]*=-1;
			else a[j++]=index;
		}
		
		for(int i: a) {
			System.out.print(i+" ");
		}
		
		sc.close();
	}

}
