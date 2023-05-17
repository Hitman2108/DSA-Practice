package sorting;

import java.util.Arrays;

public class MergeWIthoutExtraSpace {
	
	public static void swap(int arr1[], int arr2[], int n, int m) {
		if(arr1[n]>arr2[m]) {
			int temp=arr1[n];
			arr1[n]=arr2[m];
			arr2[m]=temp;
		}
	}
	
	public static void main(String[] args) {
		int arr1[]= {1,3,5,7};
		int arr2[]= {0,2,6,8,9};
		
		int n=arr1.length;
		int m=arr2.length;
		
		int length=n+m;
		int gap=length/2+length%2;
		
		while(gap>0) {
			int left=0;
			int right=gap;
			while(right<length) {
				if(left<n && right>=n) {
					swap(arr1,arr2,left,right-n);
				}
				else if(left>=n) {
					swap(arr2,arr2,left-n,right-n);
				}
				else {
					swap(arr1,arr1,left,right);
				}
				left++;
				right++;
			}
			if(gap==1) break;
			gap=gap/2+gap%2;
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}

}
