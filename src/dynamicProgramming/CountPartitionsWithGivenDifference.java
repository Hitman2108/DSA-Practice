package dynamicProgramming;
//s1-s2=d
public class CountPartitionsWithGivenDifference {
	
	public static void main(String[] args) {
		int arr[]=new int[] {5,2,6,4};
//		int n=arr.length;
		int d=3;
		int total=0;
		for(int i: arr) total+=i;
		if(total-d<0 || (total-d)%2!=0) {
			System.out.println("Not Possible");
			return;
		}
		int target=(total-d)/2;
		System.out.println(getPartitionCount(arr,target));
	}
	
	public static int getPartitionCount(int arr[], int target) {
		int n=arr.length;
		int dp[][]=new int[n][target+1];
		for(int i=0; i<n; i++) {
			dp[i][0]=1;
		}
		if(arr[0]<=target) dp[0][arr[0]]=1;
		if(arr[0]==0) dp[0][0]=2;
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<=target; j++) {
				int nonTake=dp[i-1][j];
				int take=0;
				if(arr[i]<=j) {
					take=dp[i-1][j-arr[i]];
				}
				dp[i][j]=nonTake+take;
			}
		}
		
		return dp[n-1][target];
	}

}
