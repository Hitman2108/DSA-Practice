package striversBlind75;

import java.util.Arrays;

public class MinimumInSortedAndRotatedArray {
	
	public static void main(String[] args) {
		int arr[]= {4,5,6,7,0,1,2};
		int n=arr.length;
		int k=8;
		rotateArrayLeftByKPlaces(arr,k,n);
		System.out.println(Arrays.toString(arr));
		System.out.println(findMinimumInArray(arr,n));
	}
	
	public static void rotateArrayLeftByKPlaces(int arr[], int k, int n) {
		int t=k%n;
		rotateArray(arr,0,t);
		rotateArray(arr,t,n);
		rotateArray(arr,0,n);
	}
	
	public static void rotateArray(int arr[], int k, int n) {
		int low=k, high=n-1;
		while(low<high) {
			int temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
			low++;
			high--;
		}
	}
	
	public static int findMinimumInArray(int arr[], int n) {
		int low=0, high=n-1;
		int minVal=Integer.MAX_VALUE;
		while(low<=high) {
			if(arr[low]<=arr[high]) {
				minVal=Math.min(minVal, arr[low]);
				break;
			}
			int mid=(low+high)/2;
			if(arr[low]<=arr[mid]) {
				minVal=Math.min(minVal, arr[low]);
				low=mid+1;
			}
			else {
				minVal=Math.min(minVal, arr[mid]);
				high=mid-1;
			}
		}
		
		return minVal;
	}

}
