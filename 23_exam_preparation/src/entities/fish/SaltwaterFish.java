package entities.fish;

public class SaltwaterFish extends BaseFish {
	private static final int INITIAL_SIZE = 5;
	public SaltwaterFish(String name, String species, double price) {
		super(name, species, price);
		setSize(INITIAL_SIZE);

	}

	@Override
	public void eat() {
		int newSize = getSize()+2;
		setSize(newSize);
	}
}
