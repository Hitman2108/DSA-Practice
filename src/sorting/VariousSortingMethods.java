package sorting;

import java.util.Arrays;

public class VariousSortingMethods {
	
	public static void main(String[] args) {
		int arr[]=new int[] {7,4,3,9,1};
		int n=arr.length;
//		int b[]=arr.clone();
//		System.out.println(Arrays.toString(b));
//		
//		int c[]=new int[arr.length];
//		System.arraycopy(arr, 0, c, 1, 3);
//		System.out.println(Arrays.toString(c));
//		
//		int d[]=Arrays.copyOf(arr, 6);
//		System.out.println(Arrays.toString(d));
//		
//		int e[]=Arrays.copyOfRange(arr, 1, 6);
//		System.out.println(Arrays.toString(e));
		
		System.out.println(bubbleSort(arr,n));
		System.out.println(selectionSort(arr,n));
		System.out.println(insertionSort(arr,n));
		int temp[]=arr.clone();
		mergeSort(temp,0,n-1);
		System.out.println(Arrays.toString(temp));
	}
	
	public static void swap(int arr[], int x, int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	
	public static String bubbleSort(int arr[], int n) {
		int temp[]=arr.clone();
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(temp[i]>temp[j]) {
					swap(temp,i,j);
				}
			}
		}
		return Arrays.toString(temp);
	}
	
	public static String selectionSort(int arr[], int n) {
		int temp[]=arr.clone();
		for(int i=0; i<n-1; i++) {
			int min_ind=i;
			for(int j=i+1; j<n; j++) {
				if(temp[j]<temp[min_ind]) {
					min_ind=j;
				}
			}
			swap(temp,min_ind,i);
		}
		
		return Arrays.toString(temp);
	}
	
	public static String insertionSort(int arr[], int n) {
		int temp[]=arr.clone();
		for(int i=1; i<n; i++) {
			int key=temp[i];
			int j=i-1;
			while(j>=0 && temp[j]>key) {
				temp[j+1]=temp[j];
				j--;
			}
			temp[j+1]=key;
		}
		
		return Arrays.toString(temp);
	}
	
	public static void mergeSort(int arr[], int l, int h) {
		if(l<h) {
			int mid=(l+h)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, h);
			merge(arr,l,mid,h);
		}
	}
	
	public static void merge(int arr[], int l, int mid, int h) {
		int i=l, j=mid+1, k=0;
		int temp[]=new int[h-l+1];
		while(i<=mid && j<=h) {
			if(arr[i]<=arr[j]) {
				temp[k++]=arr[i++];
			}
			else {
				temp[k++]=arr[j++];
			}
		}
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		
		while(j<=h) {
			temp[k++]=arr[j++];
		}
		
		for(int x=0; x<temp.length; x++) {
			arr[l+x]=temp[x];
		}
		
	}

}
