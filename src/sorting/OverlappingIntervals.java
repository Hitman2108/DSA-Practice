package sorting;

import java.util.Scanner;

public class OverlappingIntervals {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		Pair arr[]=new Pair[t];
		int i=0;
		while(i<t) {
			arr[i]=new Pair(sc.nextInt(),sc.nextInt());
			i++;
		}
		int res=0;
		for(int j=1; j<t; j++) {
			if(arr[res].end>=arr[j].start) {
				arr[res].start=Math.min(arr[j].start, arr[res].start);
				arr[res].end=Math.max(arr[j].end, arr[res].end);
			}
			else {
				res++;
				arr[res]=arr[j];
			}
		}
		
		for(int j=0; j<=res; j++) {
			System.out.println(arr[j].start+" "+arr[j].end);
		}
		sc.close();
	}
}

class Pair implements Comparable<Pair>{
	int start;
	int end;
	public Pair(int start, int end) {
		this.start=start;
		this.end=end;
	}
	public int compareTo(Pair o) {
		return this.start-o.start;
	}
}
