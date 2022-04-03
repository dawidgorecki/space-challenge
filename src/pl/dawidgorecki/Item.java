package pl.dawidgorecki;

public class Item {
    private String name;
    private int weight; // item weight in kg

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
