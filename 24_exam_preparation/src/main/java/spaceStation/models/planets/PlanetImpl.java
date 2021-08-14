package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import spaceStation.common.ExceptionMessages;

public class PlanetImpl implements Planet {

	private String name;
	private List<String> items;

	public PlanetImpl(String name) {
		this.setName(name);
		this.items = new ArrayList<String>();
	}

	@Override
	public List<String> getItems() {
		// TODO Auto-generated method stub
		return this.items;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}
}
