package pl.dawidgorecki;

public class Item implements Comparable<Item> {
    private String name;
    private int weight; // item weight in kg
    private boolean isLoaded;

    @Override
    public int compareTo(Item o) {
        return Integer.compare(o.getWeight(), this.getWeight());
    }

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.isLoaded = false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void markAsLoaded() {
        isLoaded = true;
    }

    public void unload() {
        isLoaded = false;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
