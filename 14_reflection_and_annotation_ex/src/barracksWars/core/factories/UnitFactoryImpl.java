package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.Archer;
import barracksWars.models.units.Gunner;
import barracksWars.models.units.Horseman;
import barracksWars.models.units.Pikeman;
import barracksWars.models.units.Swordsman;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		switch (unitType) {
		case "Archer":
			return new Archer();
		case "Pikeman":
			return new Pikeman();
		case "Swordsman":
			return new Swordsman();
		case "Horseman":
			return new Horseman();
		case "Gunner":
			return new Gunner();
		}
		return null;
	}
}
