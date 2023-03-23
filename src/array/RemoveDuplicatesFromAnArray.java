package array;

public class RemoveDuplicatesFromAnArray {
	
	public static void main(String[] args) {
		int arr[]=new int[] {10,10,10,20,20,30,30,30};
		int i=0, j=1;
		int res=1;
		while(i<8 && j<8) {
			if(arr[i]!=arr[j]) {
				arr[++i]=arr[j++];
				res++;
			}
			else {
				j++;
			}
		}
		
		for(int z: arr) {
			System.out.print(z+" ");
		}
		System.out.println(res);
	}

}
