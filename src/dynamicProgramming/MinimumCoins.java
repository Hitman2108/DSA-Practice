package dynamicProgramming;

public class MinimumCoins {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3};
		int target=7;
		System.out.println(getMinCoins(arr, arr.length-1, target));
	}
	
	public static int getMinCoins(int arr[], int n, int target) {
		
		if(n==0) {
			if(target%arr[0]==0) return target/arr[0];
			return (int) Math.pow(10, 9);
		}
		
		int nontake=getMinCoins(arr, n-1, target);
		int take=(int) Math.pow(10, 9);
		if(arr[n]<=target) {
			take=1+getMinCoins(arr, n, target-arr[n]);
		}
		
		return Math.min(take, nontake);
		
	}

}
