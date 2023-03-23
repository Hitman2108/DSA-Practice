package array;

import java.util.Arrays;
import java.util.Scanner;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int l_max[]=new int[n];
		int r_max[]=new int[n];
		l_max[0]=arr[0];
		r_max[n-1]=arr[n-1];;
		for(int i=1; i<n; i++) {
			l_max[i]=Math.max(l_max[i-1], arr[i]);
			r_max[n-i-1]=Math.max(r_max[n-i], arr[n-i-1]);
		}
		int water=0;
		for(int i=1; i<n-1; i++) {
			water=water+(Math.min(l_max[i], r_max[i])-arr[i]);
		}
		System.out.println(water);
		sc.close();
	}

}
