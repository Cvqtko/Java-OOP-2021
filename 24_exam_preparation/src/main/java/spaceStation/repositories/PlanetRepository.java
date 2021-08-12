package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import spaceStation.models.planets.Planet;

public class PlanetRepository implements Repository<Planet> {
	private List<Planet> planets;

	public PlanetRepository() {

		this.planets = new ArrayList<>();
	}

	@Override
	public Collection<Planet> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Planet model) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Planet model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Planet findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
