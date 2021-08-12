package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Bag;

public class BaseAstronaut {
	private String name;
	private double oxygen;
	private Bag bag;

	public BaseAstronaut(String name, double oxygen) {
		this.setName(name);
		this.setOxygen(oxygen);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name==null||name.trim().equals("")) {
			throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}

	public double getOxygen() {
		return oxygen;
	}

	public void setOxygen(double oxygen) {
		if(oxygen<0) {
			throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
		}
		this.oxygen = oxygen;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}

}
