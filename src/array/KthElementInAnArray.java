package array;

public class KthElementInAnArray {
	
	public static void main(String[] args) {
		int arr[]= {3,1,2,4,5,6};
		int n=arr.length;
		int k=3;
		int low=0,high=n-1;
		
		while(low<=high) {
			int p=partition(arr,low,high);
			if(p==k-1) {
				System.out.println(arr[p]);
				break;
			}
			if(p>k-1) high=p-1;
			else low=p+1;
		}
	}
	
	public static void swap(int arr[], int x, int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	
	public static int partition(int arr[], int low, int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low; j<high; j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}

}
