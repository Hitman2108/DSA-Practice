package array;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyInAnUnsortedArray {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
		int n=arr.length;
		for(int j=0; j<n; j++) {
			arr[j]--;
		}
		
//		int i=0;
//		while(i<arr.length) {
//			if(arr[i]<=0) {
//				i++;
//				continue;
//			}
//			int index=arr[i];
//			if(arr[index]<=0) {
//				arr[index]--;
//				arr[i]=0;
//				i++;
//			}
//			else {
//				arr[i]=arr[index];
//				arr[index]=-1;
//			}
//		}
		
		for(int i=0; i<n; i++) {
			arr[arr[i]%n]+=n;
		}
		
		for(int j=0; j<n; j++) {
			System.out.println((j+1)+" "+arr[j]/n);
		}
		sc.close();
	}

}
