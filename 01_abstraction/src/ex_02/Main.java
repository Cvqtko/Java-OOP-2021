package ex_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] rectanglePoints = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		Point a = new Point(rectanglePoints[0],rectanglePoints[1]);
		
		Point b = new Point(rectanglePoints[2],rectanglePoints[3]);
		
		Rectangle rect = new Rectangle(a, b);
		
		int count = Integer.parseInt(scanner.nextLine());
		
		while(count-->0) {
			int[] singlePoint = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			Point p = new Point(singlePoint[0],singlePoint[1]);
			
			boolean isWithin = rect.contains(p);
			System.out.println(isWithin);
		}
	}

}
