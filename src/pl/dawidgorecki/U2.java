package pl.dawidgorecki;

import java.util.Random;

public class U2 extends Rocket {
    public U2() {
        super(120, 18000, 29000);
        System.out.println("U2 rocket created");
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.04 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLaunchExplosion) {
            System.out.println("U2 launched successfully");
            return true;
        }

        System.out.println("U2 exploded on launch");
        return false;
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = 0.08 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLandingCrash) {
            System.out.println("U2 landed successfully");
            return true;
        }

        System.out.println("U2 crashed on land");
        return false;
    }
}
