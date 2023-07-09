package striversBlind75;

public class MaximumSubarrayProduct {
	
	public static void main(String[] args) {
		int arr[]= {1,2,-3,0,-4,-5};
		int n=arr.length;
		System.out.println(getSubarraySum(arr,n));
		System.out.println(getSubarraySumUsingKadane(arr,n));
	}
	
	public static int getSubarraySumUsingKadane(int[] arr, int n) {
		int prefixProduct=1;
		int suffixProduct=1;
		for(int i=0; i<n; i++) {
			prefixProduct*=arr[i];
			suffixProduct*=arr[n-i-1];
			if(prefixProduct==0) prefixProduct=1;
			if(suffixProduct==0) suffixProduct=1;
		}
		return Math.max(prefixProduct, suffixProduct);
	}

	public static int getSubarraySum(int arr[], int n) {
		int maxProduct=Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int product=1;
			for(int j=i; j<n; j++) {
				product*=arr[j];
				maxProduct=Math.max(maxProduct, product);
			}
		}
		return maxProduct;
	}

}
