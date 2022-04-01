package pl.dawidgorecki;

public class Rocket implements SpaceShip {
    private int cost;
    private int weight;
    private int maxWeight;
    private int currentWeight;
    private double chanceOfLaunchExplosion;
    private double chanceOfLandingCrash;

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.currentWeight = weight;
        this.maxWeight = maxWeight;
        this.chanceOfLaunchExplosion = 0.0;
        this.chanceOfLandingCrash = 0.0;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public double getChanceOfLaunchExplosion() {
        return chanceOfLaunchExplosion;
    }

    public double getChanceOfLandingCrash() {
        return chanceOfLandingCrash;
    }

    public int getCargoCarried() {
        return currentWeight - weight;
    }

    public int getCargoLimit() {
        return maxWeight - weight;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        int totalWeight = currentWeight + item.getWeight();
        return totalWeight <= maxWeight;
    }

    public void carry(Item item) {
        currentWeight += item.getWeight();
        System.out.println("Item loaded: " + item.getName() + " (weight: " + item.getWeight() + 
                ", total weight: " + currentWeight + ")");
    }
}
