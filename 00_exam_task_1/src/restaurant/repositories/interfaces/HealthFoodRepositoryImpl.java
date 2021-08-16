package restaurant.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

	private ArrayList<HealthyFood> healthyFood;

	public HealthFoodRepositoryImpl() {
		healthyFood = new ArrayList<HealthyFood>();
	}

	@Override
	public Collection<HealthyFood> getAllEntities() {
		// TODO Auto-generated method stub
		return healthyFood;
	}

	@Override
	public HealthyFood foodByName(String name) {
		HealthyFood food = null;
		for (HealthyFood foodFound : healthyFood) {
			if (foodFound.getName().equals(name)) {
				food = foodFound;
				break;
			}
		}
		return food;
	}

	@Override
	public void add(HealthyFood entity) {
		// TODO Auto-generated method stub

	}

}
