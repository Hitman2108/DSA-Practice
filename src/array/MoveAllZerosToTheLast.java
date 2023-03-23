package array;

public class MoveAllZerosToTheLast {
	
	public static void main(String[] args) {
		int arr[]=new int[] {0,0,0,0,10,0};
		int i=0,j=0;
		
		while(i<6 && j<6) {
			if(arr[i]!=0) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
			i++;
		}
		
		for(int z:arr) {
			System.out.print(z+" ");
		}
	}

}
