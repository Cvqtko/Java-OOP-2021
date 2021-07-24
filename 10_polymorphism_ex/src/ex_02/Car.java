package ex_02;

public class Car extends Vehicle {

    private static final double AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION, tankCapacity);
    }
}