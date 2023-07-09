package striversBlind75;

public class ArrayContainsDuplicates {
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,1};
		System.out.println(containsDuplicate(arr));
	}
	
	public static boolean containsDuplicate(int[] arr) {
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]) return true;
            }
        }
        return false;
    }

}
