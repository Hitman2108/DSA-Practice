package sorting;

import java.util.Arrays;

public class SegregatePositiveAndNegative {
	
	public static void main(String[] args) {
		int arr[]={2,-3,-8,9,6,4,10,-9,5};
		int n=arr.length;
		int i=-1;//last negative index
		for(int j=0; j<n; j++) {
			if(arr[j]<0) {
				i++;
				swap(arr,i,j);
				//to maintain order
				if(j-i>=2) {
					rearrangeArray(arr,i+1,j);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void swap(int arr[], int x, int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	
	public static void rearrangeArray(int arr[], int l, int h) {
		int x=arr[h];
		for(int i=h; i>l; i--) {
			arr[i]=arr[i-1];
		}
		arr[l]=x;
	}

}
