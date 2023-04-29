package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
//		System.out.println(maxLoot(arr,0,n-2));
//		System.out.println(maxLoot(arr,1,n-1));
		System.out.println(Math.max(maxLoot(arr,0,n-2), maxLoot(arr,1,n-1)));
		sc.close();
	}
	
	public static int maxLoot(int arr[], int low, int high) {
		int prev=arr[low];
		int prev2=0;
		for(int i=low+1; i<=high; i++) {
			int take=arr[i];
			if(i>low+1) {
				take+=prev2;
			}
			int nonTake=prev;
			int curr=Math.max(take, nonTake);
			prev2=prev;
			prev=curr;
		}
		
		return prev;
	}

}
