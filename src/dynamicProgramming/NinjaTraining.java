package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NinjaTraining {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String a[]=str.split("#");
		int days=a.length;
		int arr[][]=new int[days][3];
		for(int i=0; i<days; i++) {
			int[] b=Arrays.stream(a[i].split(",")).mapToInt(Integer::parseInt).toArray();
			for(int j=0; j<3; j++) {
				arr[i][j]=b[j];
			}
		}
		int dp[][]=new int[days][4];
		System.out.println(getMaxPoints(arr,days-1,3));
		System.out.println(getMaxPoints1(arr,days-1,3,dp));
		System.out.println(getMaxPoints2(arr,days));
		System.out.println(getMaxPoints3(arr,days));
		sc.close();
	}
	
	//Recursion
	public static int getMaxPoints(int arr[][], int day, int prev) {
		int maxi=0;
		if(day==0) {
			for(int i=0; i<3; i++) {
				if(i!=prev) {
					maxi=Math.max(maxi, arr[day][i]);
				}
			}
			return maxi;
		}
		for(int i=0; i<3; i++) {
			if(i!=prev) {
				int curr=arr[day][i]+getMaxPoints(arr,day-1,i);
				maxi=Math.max(maxi, curr);
			}
		}
		
		return maxi;
	}
	
	//Memoization
	public static int getMaxPoints1(int arr[][], int day, int prev, int dp[][]) {
		if(dp[day][prev]!=0) return dp[day][prev];
		int maxi=0;
		if(day==0) {
			for(int i=0; i<3; i++) {
				if(i!=prev) {
					maxi=Math.max(maxi, arr[day][i]);
				}
			}
			return maxi;
		}
		
		for(int i=0; i<3; i++) {
			if(i!=prev) {
				int curr=arr[day][i]+getMaxPoints1(arr,day-1,i,dp);
				maxi=Math.max(maxi, curr);
			}
		}
		
		return dp[day][prev]=maxi;
	}
	
	//Tabulation
	public static int getMaxPoints2(int arr[][], int days) {
		int dp[][]=new int[days][4];
		dp[0][0]=Math.max(arr[0][1], arr[0][2]);
		dp[0][1]=Math.max(arr[0][0], arr[0][2]);
		dp[0][2]=Math.max(arr[0][0], arr[0][1]);
		dp[0][3]=Math.max(arr[0][0], dp[0][0]);
		
		for(int i=1; i<days; i++) {
			for(int j=0; j<4; j++) {
				dp[i][j]=0;
				for(int k=0; k<3; k++) {
					if(k!=j) {
						dp[i][j]=Math.max(dp[i][j], arr[i][k]+dp[i-1][k]);
					}
				}
			}
		}
		
		return dp[days-1][3];
	}
	
	//Space Optimization
	public static int getMaxPoints3(int arr[][], int days) {
		int prev[]=new int[4];
		prev[0]=Math.max(arr[0][1], arr[0][2]);
		prev[1]=Math.max(arr[0][0], arr[0][2]);
		prev[2]=Math.max(arr[0][0], arr[0][1]);
		prev[3]=Math.max(arr[0][0], prev[0]);
		
		for(int i=1; i<days; i++) {
			int temp[]=new int[4];
			for(int j=0; j<4; j++) {
				temp[j]=0;
				for(int k=0; k<3; k++) {
					if(k!=j) {
						temp[j]=Math.max(temp[j], arr[i][k]+prev[k]);
					}
				}
			}
			prev=temp;
		}
		
		return prev[3];
	}

}
