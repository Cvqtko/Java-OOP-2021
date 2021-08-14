package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		return Collections.unmodifiableList(this.planets);
	}

	@Override
	public void add(Planet model) {

		this.planets.add(model);

	}

	@Override
	public boolean remove(Planet model) {
		return this.planets.remove(model);
	}

	@Override
	public Planet findByName(String name) {
		// TODO Auto-generated method stub
		return this.planets.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
		
	}

}
