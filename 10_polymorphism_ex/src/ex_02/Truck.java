package ex_02;

public class Truck extends Vehicle {

    private static final double AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 1.6;
    private static final double REDUCE_REFUEL = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONING_ADDITIONAL_SUMMER_FUEL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refueling(double fuel) {
        super.refueling(fuel * REDUCE_REFUEL);
    }
}