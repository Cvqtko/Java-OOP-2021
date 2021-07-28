package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		Scanner scanner = new Scanner(System.in);
		Class clazz = BlackBoxInt.class;
		// Class clazz = Class.forName("BlackBoxInt");

		Constructor constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
		Field innerValue = clazz.getDeclaredField("innerValue");
		innerValue.setAccessible(true);
		List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());

		String input = scanner.nextLine();

		while (!input.equals("END")) {
			String command = input.split("_")[0];
			int value = Integer.parseInt(input.split("_")[1]);

			Method currentMethod = methods.stream().filter(method -> method.getName().equals(command)).findFirst()
					.orElse(null);

			currentMethod.setAccessible(true);
			currentMethod.invoke(blackBoxInt, value);

			System.out.println(innerValue.get(blackBoxInt));
			input = scanner.nextLine();
		}
	}
}
