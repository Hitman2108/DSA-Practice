package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionofTwoSortedArray {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int a[]=Arrays.stream(str1.split(",")).mapToInt(Integer::parseInt).toArray();
		int b[]=Arrays.stream(str2.split(",")).mapToInt(Integer::parseInt).toArray();
		getIntersectionofArrays(a,b);
		sc.close();
	}
	
	public static void getIntersectionofArrays(int a[], int b[]) {
		int i=0, j=0;
		while(i<a.length && j<b.length) {
			if(i>0 && a[i]==a[i-1]) {
				i++;
				continue;
			}
			if(a[i]==b[j]) {
				System.out.print(a[i]+" ");
				i++;
				j++;
			}
			else if(a[i]>b[j]) j++;
			else i++;
		}
	}

}
