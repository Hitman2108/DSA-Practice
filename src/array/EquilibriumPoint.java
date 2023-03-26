package array;

import java.util.Arrays;
import java.util.Scanner;

public class EquilibriumPoint {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int equilibriumPoint=-1;
		int l_sum=0, r_sum=0;
		for(int i=1; i<n; i++) {
			r_sum+=arr[i];
		}
		
		for(int i=1; i<n; i++) {
			if(l_sum==r_sum) {
				equilibriumPoint=i-1;
				break;
			}
			l_sum+=arr[i-1];
			r_sum-=arr[i];
		}
		
		System.out.println(equilibriumPoint);
		sc.close();
	}

}
