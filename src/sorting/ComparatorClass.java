package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ComparatorClass {
	
	public static void main(String[] args) {
		List<Point> list=new ArrayList<>();
		list.add(new Point(5,2));
		Point[] arr=new Point[] {new Point(5,2), new Point(7,4), new Point(6,3)};
		Arrays.sort(arr);
		Comparator<Point> cmp=new Comparator<>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Arrays.sort(arr, cmp);
		for(Point p: arr)
			System.out.println(p);
	}

}

class Point implements Comparable<Point>{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.x-o.x;
	}
	
}
