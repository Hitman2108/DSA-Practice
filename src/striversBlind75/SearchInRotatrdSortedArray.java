package striversBlind75;

public class SearchInRotatrdSortedArray {
	
	public static void main(String[] args) {
		int arr[]= {4,5,6,7,0,1,2};
		int n=arr.length;
		int target=6;
		System.out.println(findElementInArray(arr,n,target));
	}
	
	public static int findElementInArray(int arr[], int n, int target) {
		int low=0, high=n-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[low]<=arr[mid]) {
				if(arr[low]<=target && arr[mid]>=target) {
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			else {
				if(arr[high]>=target && arr[mid]<=target) {
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
		}
		return -1;
	}

}
