package striversBlind75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		int n=arr.length;
		System.out.println(Arrays.toString(getProductApproach1(arr, n)));
		System.out.println(Arrays.toString(getProductApproach2(arr, n)));
		System.out.println(Arrays.toString(getProductApproach3(arr, n)));
	}
	
	public static int [] getProductApproach1(int []arr, int n) {
		int temp []=new int[n];
		for(int i=0; i<n; i++) {
			int product=1;
			for(int j=0; j<n; j++) {
				if(i!=j) {
					product*=arr[j];
				}
			}
			temp[i]=product;
		}
		
		return temp;
	}
	
	public static int [] getProductApproach2(int []arr, int n) {
		int temp []=new int[n];
		int left []=new int [n];
		int right []=new int [n];
		left[0]=arr[0];
		right[n-1]=arr[n-1];
		for(int i=1; i<n; i++) {
			left[i]=arr[i]*left[i-1];
		}
		for(int i=n-2; i>=0; i--) {
			right[i]=arr[i]*right[i+1];
		}
		for(int i=0; i<n; i++) {
			if(i==0) {
				temp[i]=right[i+1];
				continue;
			}
			if(i==n-1) {
				temp[i]=left[i-1];
				continue;
			}
			temp[i]=left[i-1]*right[i+1];
		}
		
		return temp;
	}
	
	public static int [] getProductApproach3(int []arr, int n) {
		int temp []=new int[n];
		temp[0]=arr[0];
		for(int i=1; i<n; i++) {
			temp[i]=arr[i]*temp[i-1];
		}
		int product=1;
		for(int i=n-1; i>=0; i--) {
			if(i==0) {
				temp[i]=product;
				continue;
			}
			if(i==n-1) {
				temp[i]=temp[i-1];
				product*=arr[i];
				continue;
			}
			temp[i]=temp[i-1]*product;
			product*=arr[i];
		}
		
		return temp;
	}

}
