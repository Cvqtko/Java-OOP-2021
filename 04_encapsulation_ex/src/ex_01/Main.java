package ex_01;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		double length = Double.parseDouble(scanner.nextLine());
		double width = Double.parseDouble(scanner.nextLine());
		double height = Double.parseDouble(scanner.nextLine());
		StringBuilder sb = new StringBuilder();
		try {
			Box box = new Box(length, width, height);
			sb.append(String.format("Surface Area - %.2f%n", box.calculateSurfaceArea()));
			sb.append(String.format("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea()));
			sb.append(String.format("Volume – %.2f%n", box.calculateVolume()));
			System.out.println(sb.toString());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}

	}
}