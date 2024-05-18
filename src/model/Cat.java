package model;

import utils.Randomizer;

public class Cat {
    private String name;
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
        this.action = true;
    }

    public Cat(String name) {
        this.name = name;
        this.age = Randomizer.randomizer(18) + 1;
        this.satietyLevel = Randomizer.randomizer(60) + 20;
        this.healthLevel = Randomizer.randomizer(60) + 20;
        this.moodLevel = Randomizer.randomizer(60) + 20;
        this.averageLevel = (satietyLevel + moodLevel + healthLevel) / 3;
        this.action = true;
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

    public void setAction(boolean action) {
        this.action = action;
    }

    public void setAverageLevel() {
        this.averageLevel = (satietyLevel + moodLevel + healthLevel) / 3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAction() {
        return action;
    }

    public static void feedCat(Cat cat) {
        if ((cat.getSatietyLevel() + 7) < 100 && (cat.getMoodLevel() + 7) < 100 && cat.isAction()) {
            if (cat.getAge() <= 5) {
                cat.setSatietyLevel(cat.getSatietyLevel() + 7);
                cat.setMoodLevel(cat.getMoodLevel() + 7);
                System.out.printf("\nВы накормили кота %s, настроение и сытость кота увеличены на 7.", cat.getName());
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setSatietyLevel(cat.getSatietyLevel() + 5);
                cat.setMoodLevel(cat.getMoodLevel() + 5);
                System.out.printf("\nВы накормили кота %s, настроение и сытость кота увеличены на 5.", cat.getName());
            } else {
                cat.setSatietyLevel(cat.getSatietyLevel() + 4);
                cat.setMoodLevel(cat.getMoodLevel() + 4);
                System.out.printf("\nВы накормили кота %s, настроение и сытость кота увеличены на 4.", cat.getName());
            }
            cat.setName("* " + cat.getName());
        } else if (!cat.isAction()) {
            System.out.println("С котом можно выполнять дейстивие только раз в день!");
        } else {
            cat.setSatietyLevel(100);
            cat.setMoodLevel(100);
            System.out.printf("\nУ кота %s значения не могут быть больше 100.", cat.getName());
        }
        cat.setAverageLevel();
        cat.setAction(false);

    }

    public static void treatCat(Cat cat) {
        if ((cat.getHealthLevel() + 7) < 100 && (cat.getMoodLevel() - 6) > 0 && (cat.getSatietyLevel() - 6) > 0 && cat.isAction()) {
            if (cat.getAge() <= 5) {
                cat.setHealthLevel(cat.getHealthLevel() + 7);
                cat.setMoodLevel(cat.getMoodLevel() - 3);
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
                System.out.printf("\nВы полечили кота %s, здоровье кота увеличено на 7, а настроение и сытость уменьшены на 3",
                        cat.getName());
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setHealthLevel(cat.getHealthLevel() + 5);
                cat.setMoodLevel(cat.getMoodLevel() - 5);
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
                System.out.printf("\nВы полечили кота %s, здоровье кота увеличено на 5, а настроение и сытость уменьшены на 5",
                        cat.getName());
            } else {
                cat.setHealthLevel(cat.getHealthLevel() + 4);
                cat.setMoodLevel(cat.getMoodLevel() - 6);
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
                System.out.printf("\nВы полечили кота %s, здоровье кота увеличено на 4, а настроение и сытость уменьшены на 6",
                        cat.getName());
            }
            cat.setName("* " + cat.getName());
        } else if (!cat.isAction()) {
            System.out.println("С котом можно выполнять дейстивие только раз в день!");
        } else {
            cat.setHealthLevel(100);
            cat.setMoodLevel(0);
            cat.setSatietyLevel(0);
            System.out.printf("\nУ кота %s значения не могут быть больше 100.", cat.getName());
        }
        cat.setAverageLevel();
        cat.setAction(false);
    }

    public static void playCat(Cat cat) {
        if ((cat.getMoodLevel() + 7) < 100 && (cat.getHealthLevel() + 7) < 100 && (cat.getSatietyLevel() - 6) > 0 && cat.isAction()) {
            if (cat.getAge() <= 5) {
                cat.setMoodLevel(cat.getMoodLevel() + 7);
                cat.setHealthLevel(cat.getHealthLevel() + 7);
                cat.setSatietyLevel(cat.getSatietyLevel() - 3);
                System.out.printf("\nВы поиграли с котом %s, настроение и здоровье кота увеличены на 7, а сытость уменьшена на 3.",
                        cat.getName());
            } else if (cat.getAge() >= 6 && cat.getAge() <= 10) {
                cat.setMoodLevel(cat.getMoodLevel() + 5);
                cat.setHealthLevel(cat.getHealthLevel() + 5);
                cat.setSatietyLevel(cat.getSatietyLevel() - 5);
                System.out.printf("\nВы поиграли с котом %s, настроение и здоровье кота увеличены на 5, а сытость уменьшена на 5.",
                        cat.getName());
            } else {
                cat.setMoodLevel(cat.getMoodLevel() + 4);
                cat.setHealthLevel(cat.getHealthLevel() + 4);
                cat.setSatietyLevel(cat.getSatietyLevel() - 6);
                System.out.printf("\nВы поиграли с котом %s, настроение и здоровье кота увеличены на 4, а сытость уменьшена на 6.",
                        cat.getName());
            }
            cat.setName("* " + cat.getName());
        } else if (!cat.isAction()) {
            System.out.println("С котом можно выполнять дейстивие только раз в день!");
        } else {
            cat.setMoodLevel(100);
            cat.setHealthLevel(100);
            cat.setSatietyLevel(0);
            System.out.printf("\nУ кота %s значения не могут быть больше 100.", cat.getName());
        }
        cat.setAverageLevel();
        cat.setAction(false);

    }

    public void nextDay(Cat cat) {
        int randomSatiety = Randomizer.randomizer(5) + 1;
        int randomMoodAndHEalth = Randomizer.randomizer(7) - 3;
        cat.setSatietyLevel(getSatietyLevel() + randomSatiety);
        if (cat.getSatietyLevel() + randomSatiety > 100) {
            cat.setSatietyLevel(100);
        }
        cat.setMoodLevel(getMoodLevel() + randomMoodAndHEalth);
        if (cat.getMoodLevel() + randomMoodAndHEalth > 100) {
            cat.setMoodLevel(100);
        }
        cat.setHealthLevel(getHealthLevel() + Randomizer.randomizer(7) - 3);
        if (cat.getHealthLevel() + randomMoodAndHEalth > 100) {
            cat.setHealthLevel(100);
        }
        setAverageLevel();
        cat.setName(cat.getName().replace("* ", ""));
        cat.setAction(true);
    }

    public void poisoning() {
        int poisoning = Randomizer.randomizer(15) + 5;
        int poisoningHealth = Randomizer.randomizer(20) + 5;
        System.err.printf("\nКот отравился, настроение уменьшено на %d и здоровье на %d\n",
                poisoning, poisoningHealth);
        setHealthLevel(getHealthLevel() - poisoningHealth);
        setMoodLevel(getMoodLevel() + poisoning);
    }

    public void injury() {
        int injury = Randomizer.randomizer(20) + 5;
        int injuryHealth = Randomizer.randomizer(25) + 5;
        System.err.printf("\nКот травмировался, настроение уменьшено на %d и здоровье на %d\n",
                injury, injuryHealth);
        setHealthLevel(getHealthLevel() - injuryHealth);
        setMoodLevel(getMoodLevel() + injury);
    }
}
