package striversBlind75;

public class MaximumSubarraySum {
	
	public static void main(String[] args) {
		int arr[]= {1,2,-3,0,-4,-5};
		int n=arr.length;
		System.out.println(getSubarraySum(arr,n));
		System.out.println(getSubarraySumUsingKadane(arr,n));
	}
	
	public static int getSubarraySumUsingKadane(int[] arr, int n) {
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		int start=0,end=0;
		int s=0;
		for(int i=0; i<n; i++) {
			sum=sum+arr[i];
//			maxSum=Math.max(maxSum, sum);
			if(maxSum<sum) {
				maxSum=sum;
				start=s;
				end=i;
			}
			if(sum<arr[i]) {
				sum=arr[i];
				s=i+1;
			}
		}
		System.out.println(start+" "+end);
		return maxSum;
	}

	public static int getSubarraySum(int arr[], int n) {
		int maxSum=Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int sum=0;
			for(int j=i; j<n; j++) {
				sum+=arr[j];
				maxSum=Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

}
