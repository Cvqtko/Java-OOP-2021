package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
//	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//		String command;
//		while (!"harvest".equalsIgnoreCase(command = reader.readLine())) {
//			String modifier = command;
//
//			Arrays.stream(RichSoilLand.class.getDeclaredFields())
//					.filter(field -> Modifier.toString(field.getModifiers()).equals(modifier) || modifier.equals("all"))
//					.forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()),
//							f.getType().getSimpleName(), f.getName()));
//		}
//	}
//}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

		Map<Commands, List<Field>> fieldsMap = new LinkedHashMap<Commands, List<Field>>();

		fieldsMap.put(Commands.PUBLIC, new ArrayList<Field>());
		fieldsMap.put(Commands.PRIVATE, new ArrayList<Field>());
		fieldsMap.put(Commands.PROTECTED, new ArrayList<Field>());
		fieldsMap.put(Commands.ALL, fields);

		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());
			switch (modifier) {
			case "public":
				fieldsMap.get(Commands.PUBLIC).add(field);
				break;
			case "private":
				fieldsMap.get(Commands.PRIVATE).add(field);
				break;
			case "protected":
				fieldsMap.get(Commands.PROTECTED).add(field);
				break;
			}
		}

		while (!input.equals("HARVEST")) {

			switch (input) {
			case "public":
				fieldsMap.get(Commands.PUBLIC).forEach(field -> printField(field));
				break;
			case "private":
				fieldsMap.get(Commands.PRIVATE).forEach(field -> printField(field));
				break;

			case "protected":
				fieldsMap.get(Commands.PROTECTED).forEach(field -> printField(field));

				break;
			case "all":
				fieldsMap.get(Commands.ALL).forEach(field -> printField(field));
				break;
			}

			input = scanner.nextLine();
		}
	}

	private static void printField(Field field) {
		System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " "
				+ field.getName());
	}
}
