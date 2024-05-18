package model;

import utils.Randomizer;

import java.nio.file.Path;
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
        this.satietyLevel = Randomizer.randomizer(60) + 20;
        this.healthLevel = Randomizer.randomizer(60) + 20;
        this.moodLevel = Randomizer.randomizer(60) + 20;
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

    public void setSatietyLevel(double satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public void setMoodLevel(double moodLevel) {
        this.moodLevel = moodLevel;
    }

    public void setHealthLevel(double healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void setAverageLevel(double averageLevel) {
        this.averageLevel = averageLevel;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public static void feedCat(Cat cat) {
        if ((cat.getSatietyLevel() + 7) < 100 && (cat.getMoodLevel() + 7) < 100) {
            if(cat.getAge() <= 5) {
                cat.setSatietyLevel(cat.getSatietyLevel() + 7);
                cat.setMoodLevel(cat.getMoodLevel() + 7);
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setSatietyLevel(cat.getSatietyLevel() + 5);
                cat.setMoodLevel(cat.getMoodLevel() + 5);
            } else {
                cat.setSatietyLevel(cat.getSatietyLevel() + 4);
                cat.setMoodLevel(cat.getMoodLevel() + 4);
            }
        } else {
            cat.setSatietyLevel(100);
            cat.setMoodLevel(100);
        }

    }
    public static void treatCat(Cat cat) {
        if ((cat.getHealthLevel() + 7) < 100 && (cat.getMoodLevel() - 6) > 0 && (cat.getSatietyLevel() - 6) > 0) {
            if (cat.getAge() <= 5) {
                cat.setHealthLevel(cat.getHealthLevel() + 7);
                cat.setMoodLevel(cat.getMoodLevel() - 3);
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setHealthLevel(cat.getHealthLevel() + 5);
                cat.setMoodLevel(cat.getMoodLevel() - 5);
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
            } else {
                cat.setHealthLevel(cat.getHealthLevel() + 4);
                cat.setMoodLevel(cat.getMoodLevel() - 6);
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
            }
        } else {
            cat.setHealthLevel(100);
            cat.setMoodLevel(0);
            cat.setSatietyLevel(0);
        }
    }
    public static void playCat(Cat cat) {
        if ((cat.getMoodLevel() + 7) < 100 && (cat.getHealthLevel() + 7) < 100 && (cat.getSatietyLevel() - 6) > 0) {
            if (cat.getAge() <= 5) {
                cat.setMoodLevel(cat.getMoodLevel() + 7);
                cat.setHealthLevel(cat.getHealthLevel() + 7);
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setMoodLevel(cat.getMoodLevel() + 5);
                cat.setHealthLevel(cat.getHealthLevel() + 5);
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
            } else {
                cat.setMoodLevel(cat.getMoodLevel() + 4);
                cat.setHealthLevel(cat.getHealthLevel() + 4);
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
            }
        } else {
            cat.setMoodLevel(100);
            cat.setHealthLevel(100);
            cat.setSatietyLevel(0);
        }

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
