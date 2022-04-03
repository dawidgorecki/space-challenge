package pl.dawidgorecki;

public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int maxWeight; // max weight with cargo
    protected int currentWeight;

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;

        // without cargo current weight = rocket weight
        this.currentWeight = weight;
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
        if (item.isLoaded()) return false;

        int totalWeight = currentWeight + item.getWeight();
        return totalWeight <= maxWeight;
    }

    public void carry(Item item) {
        currentWeight += item.getWeight();
        item.markAsLoaded();

        System.out.println("+ " + item.getName() + " (weight: " + item.getWeight() +
                ", total weight: " + currentWeight + ")");
    }
}
