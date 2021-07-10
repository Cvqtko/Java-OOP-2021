package ex_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		double length = Double.parseDouble(reader.readLine());
		double width = Double.parseDouble(reader.readLine());
		double height = Double.parseDouble(reader.readLine());

		try {
			Box box = new Box(length, width, height);
			System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
			System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
			System.out.printf("Volume – %.2f%n", box.calculateVolume());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}

	}
}