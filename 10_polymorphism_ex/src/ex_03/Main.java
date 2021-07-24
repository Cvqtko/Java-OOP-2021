package ex_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ex_03.animals.Animal;
import ex_03.animals.Cat;
import ex_03.animals.Mouse;
import ex_03.animals.Tiger;
import ex_03.animals.Zebra;
import ex_03.foods.Food;
import ex_03.foods.Meat;
import ex_03.foods.Vegetable;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Animal> animalList = new ArrayList<>();

		String evenLine;
		while (!"End".equalsIgnoreCase(evenLine = reader.readLine())) {
			Animal animal = createAnimal(evenLine.trim().split("\\s+"));

			String oddLine = reader.readLine();

			Food food = createFood(oddLine.trim().split("\\s+"));

			animal.makeSound();

			try {
				animal.eat(food);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			animalList.add(animal);
		}
		animalList.forEach(animal -> System.out.println(animal.toString()));
	}

	private static Food createFood(String[] tokens) {
		int quantity = Integer.parseInt(tokens[1]);
		return tokens[0].equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
	}

	private static Animal createAnimal(String[] tokens) {
		switch (tokens[0]) {
		case "Cat":
			return new Cat(tokens[1], "Cat", Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
		case "Tiger":
			return new Tiger(tokens[1], "Tiger", Double.parseDouble(tokens[2]), tokens[3]);
		case "Zebra":
			return new Zebra(tokens[1], "Zebra", Double.parseDouble(tokens[2]), tokens[3]);
		case "Mouse":
			return new Mouse(tokens[1], "Mouse", Double.parseDouble(tokens[2]), tokens[3]);
		default:
			throw new IllegalStateException("Unknown animal type " + tokens[0]);
		}
	}
}