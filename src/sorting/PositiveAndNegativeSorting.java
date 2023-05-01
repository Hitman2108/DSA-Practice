package sorting;

import java.util.Arrays;

public class PositiveAndNegativeSorting {
	
	public static void main(String[] args) {
		int arr[]=new int[] {15,-3,-2,18,-7,8,-1,-80,7};
		int i=-1,j=arr.length;
		int pivot=arr[j-1];
		while(true) {
			do {i++;}while(arr[i]<pivot);
			do {j--;}while(arr[j]>=pivot);
			if(i>=j) break;
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}

}
