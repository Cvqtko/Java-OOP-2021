package entities.decorations;

public abstract class BaseDecoration implements Decoration{
	private int comfort;
	private double price;
	
	protected BaseDecoration(int comfort, double price) {
		this.comfort=comfort;
		this.price = price;
	}

	public int getComfort() {
		return comfort;
	}

	public double getPrice() {
		return price;
	}

	
	
}
