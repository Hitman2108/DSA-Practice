package array;

public class LeftRotateArrayByDPlaces {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3,4,5};
		int n=5;
		int d=2;
//		int temp[]=new int[d];
//		for(int i=0; i<d; i++) {
//			temp[i]=arr[i];
//		}
//		for(int i=d; i<n; i++) {
//			arr[i-d]=arr[i];
//		}
//		for(int i=d; i>0; i--) {
//			arr[n-i]=temp[d-i];
//		}
		
		for(int i=0; i<n; i++) {
			int curr=arr[i];
			int curr_pos=i;
			while(curr>0) {
				int new_pos=(curr_pos-d+n)%n;
				int new_val=arr[new_pos];
				arr[new_pos]=-curr;
				curr=new_val;
				curr_pos=new_pos;
			}
		}
		
		for(int z:arr) {
			System.out.print(-z+" ");
		}
	}

}
