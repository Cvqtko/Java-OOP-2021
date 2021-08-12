package spaceStation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import spaceStation.models.astronauts.Astronaut;

public class AstronautRepository implements Repository<Astronaut>{
	private List<Astronaut> astronauts;
	
	
	
	
	public AstronautRepository() {

		this.astronauts = new ArrayList<>();
	}

	@Override
	public Collection<Astronaut> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Astronaut model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(Astronaut model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Astronaut findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
