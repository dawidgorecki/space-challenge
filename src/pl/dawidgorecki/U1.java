package pl.dawidgorecki;

import java.util.Random;

public class U1 extends Rocket {
    public U1() {
        super(100, 10000, 18000);
        System.out.println("U1 rocket created");
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLaunchExplosion) {
            System.out.println("U1 launched successfully");
            return true;
        }

        System.out.println("U1 exploded on launch");
        return false;
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = 0.01 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLandingCrash) {
            System.out.println("U1 landed successfully");
            return true;
        }

        System.out.println("U1 crashed on land");
        return false;
    }
}
