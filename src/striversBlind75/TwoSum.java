package striversBlind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int arr[]= {3,2,4};
		int n=arr.length;
		int target=6;
		doesTwoSumExist(arr,n,target);
		doesTwoSumExistUsingHashMap(arr,n,target);
		doesTwoSumExist(arr,target);
	}
	
	public static void doesTwoSumExist(int arr[], int n, int target) {
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]+arr[j]==target) {
					System.out.println("Yes {"+i+","+j+"}");
					return;
				}
			}
		}
		System.out.println("No {-1,-1}");
	}
	
	public static void doesTwoSumExist(int arr[], int target) {
		int n=arr.length;
		int start=0, end=n-1;
		Arrays.sort(arr);
		while(start<end) {
			int sum=arr[start]+arr[end];
			if(sum==target) {
				System.out.println("Yes");
				return;
			}
			else if(sum>target) {
				end--;
			}
			else {
				start++;
			}
		}
		System.out.println("No");
	}
	
	public static void doesTwoSumExistUsingHashMap(int arr[], int n, int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0; i<n; i++) {
			int t=Math.abs(target-arr[i]);
			if(map.containsKey(t)) {
				System.out.println("Yes {"+map.get(t)+","+i+"}");
				return;
			}
			else {
				map.put(arr[i],i);
			}
		}
		System.out.println("No {-1,-1}");
	}

}
