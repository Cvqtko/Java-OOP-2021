package ex_03.animals;

import java.text.DecimalFormat;

import ex_03.foods.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.animalType,
                this.animalName,
                decimalFormat.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}