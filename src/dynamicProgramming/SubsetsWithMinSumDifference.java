package dynamicProgramming;

public class SubsetsWithMinSumDifference {
	
	public static int minDiff=Integer.MAX_VALUE;
	public static void main(String[] args) {
		int arr[]=new int[] {20,19,18,20,16};
		int n=arr.length;
		int totalSum=0;
		for(int i: arr) totalSum+=i;
		getMinDifference(arr,n-1,0,totalSum);
		System.out.println(minDiff);
		System.out.println(getMinDifference(arr,totalSum));
	}
	
	public static void getMinDifference(int arr[], int ind, int currSum, int total) {
		if(ind==0) {
			currSum+=arr[0];
			minDiff=Math.min(minDiff, Math.abs(total-2*currSum));
			return;
		}
		getMinDifference(arr, ind-1, currSum, total);
		getMinDifference(arr, ind-1, currSum+arr[ind], total);
	}
	
	public static int getMinDifference(int arr[], int target) {
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
		
		int minVal=Integer.MAX_VALUE;
		for(int i=0; i<=target/2; i++) {
			if(dp[n-1][i]==true) {
				minVal=Math.min(minVal, target-2*i);
			}
		}
		
		return minVal;
	}

}
