package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {
	private List<String> items;

	public Backpack() {
		this.items = new ArrayList<String>();
	}

	@Override
	public Collection<String> getItems() {
		// TODO Auto-generated method stub
		return this.items;
	}
}
