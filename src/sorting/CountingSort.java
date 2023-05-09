package sorting;

public class CountingSort {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,4,4,1,0,1};
		int n=arr.length;
		int k=5;
		int count[]=new int[k];
		for(int i: arr) count[i]++;
		for(int i=0; i<k; i++) {
			System.out.print(count[i]+" ");
		}
		System.out.println();
		for(int i=1; i<k; i++) {
			count[i]+=count[i-1];
		}
		
		for(int i=0; i<k; i++) {
			System.out.print(count[i]+" ");
		}
		System.out.println();
		
		int output[]=new int[n];
		
		for(int i=n-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
			output[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
		}
		System.out.println();
		for(int i=0; i<n; i++) {
			System.out.print(output[i]+" ");
		}
	}

}
