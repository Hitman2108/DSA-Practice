package array;

import java.util.Arrays;
import java.util.Scanner;

public class TrappingRainWaterUsingTwoPointer {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int arr[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
//		Integer a[]=Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		int low=0, high=arr.length-1;
		int l_max=arr[low], r_max=arr[high];
		int water=0;
		while(low<=high) {
			if(l_max<r_max) {
				water+=Math.max(0, l_max-arr[low]);
				l_max=Math.max(l_max, arr[low]);
				low++;
			}
			else {
				water+=Math.max(0, r_max-arr[high]);
				r_max=Math.max(r_max, arr[high]);
				high--;
			}
		}
		System.out.println(water);
		sc.close();
	}

}
