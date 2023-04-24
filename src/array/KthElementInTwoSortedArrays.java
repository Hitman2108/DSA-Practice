package array;

import java.util.Arrays;
import java.util.Scanner;

public class KthElementInTwoSortedArrays {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int arr1[]=Arrays.stream(str1.split(",")).mapToInt(Integer::parseInt).toArray();
		int arr2[]=Arrays.stream(str2.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr1.length;
		int m=arr2.length;
		int k=sc.nextInt();
		System.out.println(getKthElement(arr1,arr2,n,m,k));
		sc.close();
	}
	
	public static int getKthElement(int arr1[], int arr2[], int n, int m, int k) {
		if(m>n) {
			return getKthElement(arr2,arr1,m,n,k);
		}
		int low=Math.max(0, k-m);
		int high=Math.min(k, n);
		
		while(low<=high) {
			int cut1=(low+high)/2;
			int cut2=k-cut1;
			int l1=cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
			int l2=cut2==0?Integer.MIN_VALUE:arr2[cut2-1];
			int r1=cut1==n?Integer.MAX_VALUE:arr1[cut1];
			int r2=cut2==m?Integer.MAX_VALUE:arr2[cut2];
			
			if(l1<=r2 && l2<=r1) {
				return Math.max(l1, l2);
			}
			else if(l1>r2) {
				high=cut1-1;
			}
			else {
				low=cut1+1;
			}
		}
		return -1;
	}

}
