package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.common.enums.BeveragesType;
import restaurant.common.enums.HealthyFoodType;
import restaurant.common.enums.TableType;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.BaseBeverage;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.BeveragesRepositoryImpl;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.HealthFoodRepositoryImpl;
import restaurant.repositories.interfaces.TableRepository;
import restaurant.repositories.interfaces.TableRepositoryImpl;

public class ControllerImpl implements Controller {

	private HealthFoodRepository<HealthyFood> healthFoodRepository;
	private BeverageRepository<Beverages> beverageRepository;
	private TableRepository<Table> tableRepository;
	private double totalMoney;

	public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
			BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

		this.healthFoodRepository = new HealthFoodRepositoryImpl();
		this.beverageRepository = new BeveragesRepositoryImpl();
		this.tableRepository = new TableRepositoryImpl();
		totalMoney = 0;
	}

	@Override
	public String addHealthyFood(String type, double price, String name) {
		Food food = null;
		if (type.equals(HealthyFoodType.Salad.toString())) {
			food = new Salad(name, price);
		} else if (type.equals(HealthyFoodType.VeganBiscuits.toString())) {
			food = new VeganBiscuits(name, price);
		}
		HealthyFood isFoodInMenu = healthFoodRepository.foodByName(name);
		if (food != null) {
			if (isFoodInMenu != null) {
				throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
			}
		}
		healthFoodRepository.add(food);
		return String.format(OutputMessages.FOOD_ADDED, name);
	}

	@Override
	public String addBeverage(String type, int counter, String brand, String name) {
		BaseBeverage baverage = null;
		if (type.equals(BeveragesType.Fresh.toString())) {
			baverage = new Fresh(name, counter, brand);
		} else if (type.equals(BeveragesType.Smoothie.toString())) {
			baverage = new Smoothie(name, counter, brand);
		}
		Beverages isBaverageInMenu = beverageRepository.beverageByName(name, brand);
		if (baverage != null && isBaverageInMenu != null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
		}

		beverageRepository.add(baverage);
		return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);

	}

	@Override
	public String addTable(String type, int tableNumber, int capacity) {
		Table table = null;
		if (type.equals(TableType.Indoors.toString())) {
			table = new Indoors(tableNumber, capacity);
		} else if (type.equals(TableType.InGarden.toString())) {
			table = new InGarden(tableNumber, capacity);
		}
		Table doesTableExist = tableRepository.byNumber(tableNumber);
		if (table != null && doesTableExist != null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
		}
		tableRepository.add(table);
		return String.format(OutputMessages.TABLE_ADDED, tableNumber);
	}

	@Override
	public String reserve(int numberOfPeople) {
		Table table = null;
		for (Table availableTable : tableRepository.getAllEntities()) {
			if (availableTable.isReservedTable()) {
				continue;
			}
			if (availableTable.getSize() < numberOfPeople) {
				continue;
			}
			table = availableTable;
			break;
		}
		if (table == null) {
			return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
		} else {
			table.reserve(numberOfPeople);
			return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
		}
	}

	@Override
	public String orderHealthyFood(int tableNumber, String healthyFoodName) {
		Table table = null;
		for (Table availableTable : tableRepository.getAllEntities()) {
			if (availableTable.getTableNumber() == tableNumber) {
				table = availableTable;
				break;
			}
		}
		if (table == null) {
			return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
		}

		HealthyFood food = null;

		for (HealthyFood availableFood : healthFoodRepository.getAllEntities()) {
			if (availableFood.getName().equals(healthyFoodName)) {
				food = availableFood;
				break;
			}
		}
		if (food == null) {
			return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
		}

		return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);

	}

	@Override
	public String orderBeverage(int tableNumber, String name, String brand) {

		Table table = null;
		for (Table availableTable : tableRepository.getAllEntities()) {
			if (availableTable.getTableNumber() == tableNumber) {
				table = availableTable;
				break;
			}
		}
		if (table == null) {
			return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
		}

		Beverages baverage = null;
		for (Beverages availableBaverage : beverageRepository.getAllEntities()) {
			if (availableBaverage.getName().equals(name) && availableBaverage.getBrand().equals(brand)) {
				baverage = availableBaverage;
				break;
			}
		}

		if (baverage == null) {
			return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
		}

		return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
	}

	@Override
	public String closedBill(int tableNumber) {
		Table table = null;
		for (Table availableTable : tableRepository.getAllEntities()) {
			if (availableTable.getTableNumber() == tableNumber) {
				table = availableTable;
				break;
			}
		}
		double tableBill = table.bill();
		totalMoney += tableBill;
		table.clear();

		return String.format(OutputMessages.BILL, tableNumber, tableBill);
	}

	@Override
	public String totalMoney() {
	
		return String.format(OutputMessages.TOTAL_MONEY, totalMoney);
	}
}
