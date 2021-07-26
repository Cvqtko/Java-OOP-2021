package ex_01;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Scanner scanner = new Scanner(System.in);
		int appenderCount = Integer.parseInt(scanner.nextLine());
		Appender[] appenders = new Appender[appenderCount];

		for (int i = 0; i < appenderCount; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");

			Layout layout = getLayout(tokens[1]);
			System.out.println();
		}

	}

	private static Layout getLayout(String layoutName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class clazz = Class.forName("ex_01.layouts." + layoutName);
		return (Layout)clazz.getConstructor().newInstance();
	}

}
