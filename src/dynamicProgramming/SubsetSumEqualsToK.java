package dynamicProgramming;

public class SubsetSumEqualsToK {
	
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,4,3};
		int k=7;
		System.out.println(isSumPresent(arr,k,arr.length-1));
		System.out.println(isSumPresent1(arr,k,0));
		System.out.println(isSumPresent(arr,k));
		System.out.println(isSumPresent1(arr,k));
	}
	
	//Recursion n-1==>0
	public static boolean isSumPresent(int arr[], int target, int ind) {
		if(target==0) return true;
		if(ind==0) {
			if(target==arr[0]) return true;
			else return false;
		}
		
		boolean nonTake=isSumPresent(arr,target,ind-1);
		boolean take=false;
		if(arr[ind]<=target) {
			take=isSumPresent(arr,target-arr[ind],ind-1);
		}
		
		return take||nonTake;
	}

	//Recursion 0==>n-1
	public static boolean isSumPresent1(int arr[], int target, int ind) {
		if(target==0) return true;
		if(ind==arr.length-1) {
			if(target==arr[arr.length-1]) return true;
			else return false;
		}
		
		boolean nonTake=isSumPresent1(arr,target,ind+1);
		boolean take=false;
		if(arr[ind]<=target) {
			take=isSumPresent1(arr,target-arr[ind],ind+1);
		}
		
		return take||nonTake;
	}
	
	//tabulation n-1==>0
	public static boolean isSumPresent(int arr[], int target) {
		int n=arr.length;
		boolean dp[][]=new boolean[n][target+1];
		for(int i=0; i<n; i++) {
			dp[i][0]=true;
		}
		if(arr[0]<=target) dp[0][arr[0]]=true;
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<=target; j++) {
				boolean nonTake=dp[i-1][j];
				boolean take=false;
				if(arr[i]<=j) {
					take=dp[i-1][j-arr[i]];
				}
				dp[i][j]=nonTake||take;
			}
		}
		
		return dp[n-1][target];
	}
	
	//tabulation 0==>n-1
	public static boolean isSumPresent1(int arr[], int target) {
		int n=arr.length;
		boolean dp[][]=new boolean[n][target+1];
		for(int i=0; i<n; i++) {
			dp[i][0]=true;
		}
		
		for(int i=n-2; i>=0; i--) {
			for(int j=1; j<=target; j++) {
				boolean nonTake=dp[i+1][j];
				boolean take=false;
				if(arr[i]<=j) {
					take=dp[i+1][j-arr[i]];
				}
				dp[i][j]=nonTake||take;
			}
		}
		
		return dp[0][target];
	}
}
