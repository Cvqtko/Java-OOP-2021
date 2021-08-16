package restaurant.entities.tables.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public abstract class BaseTable implements Table {

	private Collection<HealthyFood> healthyFood;
	private Collection<Beverages> beverages;
	private int number;
	private int size;
	private int numberOfPeople;
	private double pricePerPerson;
	private boolean isReservedTable;
	private double allPeople;

	public BaseTable(int number, int size, double pricePerPerson) {
		this.number = number;
		setSize(size);
		this.pricePerPerson = pricePerPerson;
		this.healthyFood = new ArrayList<>();
		this.beverages = new ArrayList<>();
	}

	public void setSize(int size) {
		if (size < 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
		}
		this.size = size;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		if (numberOfPeople <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
		}
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public int getTableNumber() {
		// TODO Auto-generated method stub
		return this.number;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int numberOfPeople() {
		// TODO Auto-generated method stub
		return this.numberOfPeople;
	}

	@Override
	public double pricePerPerson() {
		// TODO Auto-generated method stub
		return this.pricePerPerson;
	}

	@Override
	public boolean isReservedTable() {
		// TODO Auto-generated method stub
		return this.isReservedTable;
	}

	@Override
	public double allPeople() {
		// TODO Auto-generated method stub
		return this.numberOfPeople * pricePerPerson;
	}

	@Override
	public void reserve(int numberOfPeople) {
		this.isReservedTable = true;
		this.setNumberOfPeople(numberOfPeople);

	}

	@Override
	public void orderHealthy(HealthyFood food) {
		this.healthyFood.add(food);

	}

	@Override
	public void orderBeverages(Beverages beverages) {
		this.beverages.add(beverages);

	}

	@Override
	public double bill() {
		this.allPeople = 0;
		for (HealthyFood f : healthyFood) {
			allPeople += f.getPrice();
		}
		for (Beverages b : beverages) {
			allPeople += b.getPrice();
		}
		return allPeople;
	}

	@Override
	public void clear() {
		this.healthyFood.clear();
		this.beverages.clear();
		this.isReservedTable = false;
		this.numberOfPeople = 0;
		this.allPeople = 0;

	}

	@Override
	public String tableInformation() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Table - %d", this.number)).append(System.lineSeparator());
		sb.append(String.format("Size - %d", this.size)).append(System.lineSeparator());
		sb.append("Type - " + this.getClass().getSimpleName()).append(System.lineSeparator());
		sb.append(String.format("All price - %f", this.pricePerPerson)).append(System.lineSeparator());
		return sb.toString();
	}

}
