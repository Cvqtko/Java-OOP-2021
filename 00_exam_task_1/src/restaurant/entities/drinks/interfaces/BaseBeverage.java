package restaurant.entities.drinks.interfaces;

import restaurant.common.ExceptionMessages;

public abstract class BaseBeverage implements Beverages{

	private String name;
	private int counter;
	private double price;
	private String brand;
	
	
	public BaseBeverage(String name, int counter, double price, String brand) {
		setName(name);
		setCounter(counter);
		setPrice(price);
		setBrand(brand);
	}

	public void setName(String name) {
		if(name==null||name.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
		}
		this.name = name;
	}

	
	public void setCounter(int counter) {
		if(counter<=0) {
			throw new IllegalArgumentException (ExceptionMessages.INVALID_COUNTER);
		}
		this.counter=counter;
	}

	public void setPrice(double price) {
		if(price<=0) {
			throw new IllegalArgumentException (ExceptionMessages.INVALID_PRICE);
		}
		this.price=price;
	}

	public void setBrand(String brand) {
		if(brand==null||brand.trim().isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_BRAND);
		}
		this.brand = brand;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return this.counter;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return this.brand;
	}

}