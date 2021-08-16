package restaurant.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;

import restaurant.entities.tables.interfaces.Table;

public class TableRepositoryImpl implements TableRepository<Table> {

	private ArrayList<Table> tables;

	public TableRepositoryImpl() {
		this.tables = new ArrayList<Table>();
	}

	@Override
	public Collection<Table> getAllEntities() {
		// TODO Auto-generated method stub
		return tables;
	}

	@Override
	public void add(Table entity) {
		tables.add(entity);

	}

	@Override
	public Table byNumber(int number) {
		Table table = null;
		for (Table availableTables : tables) {
			if (availableTables.getTableNumber() == number) {
				table = availableTables;
				break;
			}
		}
		return table;
	}

}
