package utils;

import java.util.Random;

public class Randomizer {
    public static int randomizer(int random) {
        Random rnd = new Random();
        return rnd.nextInt(random);
    }

}


