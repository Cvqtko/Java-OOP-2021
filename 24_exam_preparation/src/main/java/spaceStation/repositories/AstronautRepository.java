package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import spaceStation.models.astronauts.Astronaut;

public class AstronautRepository implements Repository<Astronaut> {
	private List<Astronaut> astronauts;

	public AstronautRepository() {

		this.astronauts = new ArrayList<>();
	}

	@Override
	public Collection<Astronaut> getModels() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(astronauts);
	}

	@Override
	public void add(Astronaut model) {
		if (this.astronauts.stream().noneMatch(a -> a.getName().equals(model.getName()))) {
			this.astronauts.add(model);
		}

	}

	@Override
	public boolean remove(Astronaut model) {

		return this.astronauts.remove(model);
	}

	@Override
	public Astronaut findByName(String name) {

		return this.astronauts.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
	}

}
