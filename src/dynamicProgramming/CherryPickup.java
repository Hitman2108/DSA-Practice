package dynamicProgramming;

public class CherryPickup {
	
	public static void main(String[] args) {
		int a[][]=new int[][] {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
		int m=a[0].length;
		int maxi=getMaxSum(a,0,0,m-1);
		System.out.println(maxi);
	}
	
	//Recursion
	public static int getMaxSum(int arr[][], int i, int j1, int j2) {
		if(j1<0 || j1>=arr[0].length || j2<0 || j2>=arr[0].length) return Integer.MIN_VALUE;
		
		if(i==arr.length-1) {
			if(j1==j2) return arr[i][j1];
			return arr[i][j1]+arr[i][j2];
		}
		int maxi=0;
		for(int d1=-1; d1<=1; d1++) {
			for(int d2=-1; d2<=1; d2++) {
				int points=0;
				if(j1==j2) points=arr[i][j1]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				else points=arr[i][j1]+arr[i][j2]+getMaxSum(arr, i+1, j1+d1, j2+d2);
				maxi=Math.max(maxi, points);
			}
		}
		
		return maxi;
	}

}
