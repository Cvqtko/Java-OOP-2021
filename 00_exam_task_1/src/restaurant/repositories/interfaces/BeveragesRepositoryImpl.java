package restaurant.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import restaurant.entities.drinks.interfaces.Beverages;

public class BeveragesRepositoryImpl implements BeverageRepository<Beverages> {

	private ArrayList<Beverages> bevarages;

	public BeveragesRepositoryImpl() {
		this.bevarages = new ArrayList<Beverages>();
	}

	@Override
	public Collection<Beverages> getAllEntities() {
		// TODO Auto-generated method stub
		return this.bevarages;
	}

	@Override
	public void add(Beverages entity) {
		bevarages.add(entity);

	}

	@Override
	public Beverages beverageByName(String drinkName, String drinkBrand) {
		Beverages baverageFound = null;

		for (Beverages baverage : bevarages) {
			if (baverage.getName() == drinkName && baverage.getBrand() == drinkBrand) {
				baverageFound = baverage;
				break;
			}

		}

		return baverageFound;
	}

}
