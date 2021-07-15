package ex_03;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setCost(double cost) {
        Validator.validateMoney(cost);
        this.cost = cost;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

	@Override
	public String toString() {
		return this.name;
	}
    
}