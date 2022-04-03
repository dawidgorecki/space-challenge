package pl.dawidgorecki;

import java.util.Random;

public class U1 extends Rocket {
    public U1() {
        super(100, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLaunchExplosion) {
            return true;
        }

        System.out.println("[!] U1 exploded on launch!");
        return false;
    }

    @Override
    public boolean land() {
        double chanceOfLandingCrash = 0.01 * (getCargoCarried() / (double) getCargoLimit());
        double randomNumber = new Random().nextDouble();

        if (randomNumber > chanceOfLandingCrash) {
            return true;
        }

        System.out.println("[!] U1 crashed on land!");
        return false;
    }
}
