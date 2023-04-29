package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountInversionInAnArray {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println(getInvCount(arr,0,arr.length-1));
		sc.close();
	}
	
	public static int getInvCount(int arr[], int l, int h) {
		int res=0;
		if(l<h) {
			int m=(l+h)/2;
			res=getInvCount(arr,l,m);
			res+=getInvCount(arr,m+1,h);
			res+=merge(arr,l,m+1,h);
		}
		
		return res;
	}
	
	public static int merge(int arr[], int l, int m, int h) {
		int i=l;
		int j=m;
		int k=l;
		int temp[]=new int[arr.length];
		int res=0;
		while(i<=m-1 && j<=h) {
			if(arr[i]>arr[j]) {
				temp[k++]=arr[j++];
				res+=(m-i);
			}
			else {
				temp[k++]=arr[i++];
			}
		}
		while(i<=m-1) {
			temp[k++]=arr[i++];
		}
		while(j<=h) {
			temp[k++]=arr[j++];
		}
		for(int x=l; x<=h; x++) {
			arr[x]=temp[x];
		}
		
		return res;
	}

}
