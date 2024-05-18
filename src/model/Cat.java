package model;

import utils.Randomizer;

import java.util.Random;

public class Cat {
    private final String name;
    private final int age;
    private double satietyLevel;
    private double moodLevel;
    private double healthLevel;
    private double averageLevel;
    private boolean action;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.satietyLevel = Randomizer.randomizer(60) + 20;
        this.healthLevel = Randomizer.randomizer(60) + 20;
        this.moodLevel = Randomizer.randomizer(60) + 20;
        this.averageLevel = (satietyLevel + moodLevel + healthLevel) / 3;
    }

    public Cat(String name) {
        this.name = name;
        this.age = Randomizer.randomizer(18) + 1;
        this.satietyLevel = Randomizer.randomizer(101);
        this.healthLevel = Randomizer.randomizer(101);
        this.moodLevel = Randomizer.randomizer(101);
        this.averageLevel = (satietyLevel + moodLevel + healthLevel) / 3;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSatietyLevel() {
        return satietyLevel;
    }

    public double getMoodLevel() {
        return moodLevel;
    }

    public double getHealthLevel() {
        return healthLevel;
    }

    public double getAverageLevel() {
        return averageLevel;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", satietyLevel=" + satietyLevel +
                ", moodLevel=" + moodLevel +
                ", healthLevel=" + healthLevel +
                ", averageLevel=" + averageLevel +
                '}';
    }
}
