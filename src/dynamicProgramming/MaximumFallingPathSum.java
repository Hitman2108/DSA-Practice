package dynamicProgramming;

public class MaximumFallingPathSum {
	
	public static void main(String[] args) {
		int a[][]=new int[][] {{1,2,10,4},{100,3,2,1},{1,2,20,2},{1,2,2,1}};
//		int n=a.length;
		int m=a[0].length;
		int maxi=Integer.MIN_VALUE;
		for(int i=0; i<m; i++) {
			maxi=Math.max(maxi, getMaxSum(a,0,i));
		}
		System.out.println(maxi);
	}
	
	public static int getMaxSum(int a[][], int x, int y) {
		if(y>=a[0].length || y<0) return Integer.MIN_VALUE;
		if(x==a.length-1) return a[x][y];
		int ld=getMaxSum(a, x+1, y-1);
		int rd=getMaxSum(a, x+1, y+1);
		int d=getMaxSum(a, x+1, y);
		return a[x][y]+Math.max(ld, Math.max(d, rd));
	}
	
}
