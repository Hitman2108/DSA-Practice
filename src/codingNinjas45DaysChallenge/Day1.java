package codingNinjas45DaysChallenge;

import java.time.LocalDate;
import java.util.Scanner;

public class Day1 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0) {
			int year=sc.nextInt();
			int month=sc.nextInt();
			int day=sc.nextInt();
			System.out.println(dayOfTheWeek(year,month,day));
		}
		sc.close();
	}
	
	public static String dayOfTheWeek(int y, int m, int d) {
		LocalDate date=LocalDate.of(y, m, d);
		String day=date.getDayOfWeek().toString();
		return day.substring(0,1)+day.substring(1,day.length()).toLowerCase();
	}

}
