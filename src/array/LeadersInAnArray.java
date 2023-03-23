package array;

public class LeadersInAnArray {
	
	public static void main(String[] args) {
		int arr[]=new int[] {7,10,4,3,6,5,2};
		int n=7;
		int max=Integer.MIN_VALUE;
//		for(int i=n-1; i>=0; i--) {
//			if(arr[i]>max) {
//				System.out.print(arr[i]+" ");
//				max=arr[i];
//			}
//		}
		printLeaders(arr,n-1,max);
	}
	
	public static void printLeaders(int arr[], int i, int max) {
		if(i<0) return;
		if(arr[i]>max) {
			max=arr[i];
			printLeaders(arr, i-1, max);
			System.out.print(max+" ");
		}
		else {
			printLeaders(arr, i-1, max);
		}
	}

}
