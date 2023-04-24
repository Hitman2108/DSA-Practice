package binarySearch;

public class AllocateMinimunPagesRecursiveSolution {
	
	public static void main(String[] args) {
		int arr[]=new int[] {10,20,30,40,50};
		int k=5;
		int n=arr.length;
		System.out.println(getMinPages(arr,n,k));
	}
	
	public static int getMinPages(int arr[], int n, int k) {
//		System.out.println(n+" "+k);
		if(k==1) return getSum(arr,0,n-1);
		if(n==1) return arr[0];
		int res=Integer.MAX_VALUE;
		for(int i=k-1; i<n; i++) {
			res=Integer.min(res, Math.max(getMinPages(arr, i, k-1),getSum(arr, i, n-1)));
		}
		return res;
	}
	
	public static int getSum(int arr[], int start, int end) {
		int sum=0;
		for(int i=start; i<=end; i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
