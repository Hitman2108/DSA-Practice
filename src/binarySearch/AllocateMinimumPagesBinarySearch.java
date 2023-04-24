package binarySearch;

public class AllocateMinimumPagesBinarySearch {
	
	public static void main(String[] args) {
		int arr[]=new int[] {10,20,30,40,50};
		int k=2;
		int n=arr.length;
		int max=arr[0];
		int sum=arr[0];
		for(int i=1; i<n; i++) {
			sum+=arr[i];
			max=Math.max(max, arr[i]);
		}
		System.out.println(getMinPages(arr,k,max,sum));
	}
	
	public static int getMinPages(int arr[], int k, int l, int h) {
//		System.out.println(n+" "+k);
		int low=l;
		int high=h;
		int result=-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(isPossible(mid,k,arr)) {
				result=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		return result;
	}
	
	public static boolean isPossible(int mid, int k, int arr[]) {
		int c=1;
		int sum=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(sum+arr[i]>mid) {
				c++;
				sum=arr[i];
			}
			else {
				sum+=arr[i];
			}
		}
		return c<=k;
	}

}
