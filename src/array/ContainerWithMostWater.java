package array;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int arr[] = {3,1,2,4,5};
		int n=arr.length;
		int low=0, high=n-1;
		int maxWater=0;
		while(low<high) {
			int water=0;
			if(arr[low]<arr[high]) {
				water=(high-low)*arr[low];
				maxWater=Math.max(maxWater, water);
				low++;
			}
			else {
				water=(high-low)*arr[high];
				maxWater=Math.max(maxWater, water);
				high--;
			}
		}
		System.out.println(maxWater);
	}

}
