package ex_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double length = Double.parseDouble(reader.readLine());
		double width = Double.parseDouble(reader.readLine());
		double height = Double.parseDouble(reader.readLine());
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