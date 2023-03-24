package array;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		int res=0, count=1;
		for(int i=1; i<n; i++) {
			if(arr[res]==arr[i]) count++;
			else count--;
			if(count==0) {
				res=i;
				count=1;
			}
		}
		
		count=0;
		for(int i=0; i<n; i++) {
			if(arr[res]==arr[i]) count++;
		}
		System.out.println(count>n/2?res:-1);
		sc.close();
	}

}
