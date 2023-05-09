package array;

public class SubarraysWithKOddNumbers {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,1,1,1,5};
		int n=arr.length;
		int k=3;
		int count=0,temp=0;
		int odd=0,i=0,j=0;
		while(j<n) {
			if(arr[j]%2!=0) {
				odd++;
				temp=0;
			}
			while(odd==k) {
				temp++;
				if(arr[i]%2!=0) {
    				odd--;
    			}
    			i++;
			}
			count+=temp;
			j++;
		}
		
		System.out.println(count);
	}

}
