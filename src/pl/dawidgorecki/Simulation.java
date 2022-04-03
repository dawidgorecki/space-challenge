package pl.dawidgorecki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String pathname) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File dataFile = new File(pathname);
        Scanner sc = new Scanner(dataFile);

        while (sc.hasNextLine()) {
            String row = sc.nextLine();
            String[] parts = row.split("=");

            Item item = new Item(parts[0], Integer.parseInt(parts[1]));
            items.add(item);
        }

        Collections.sort(items);
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsToLoad) {
        ArrayList<Rocket> fleetU1 = new ArrayList<>();
        int loadedItems = 0;
        int rocketsCount = 0;

        while (loadedItems < itemsToLoad.size()) {
            Rocket rocket = new U1();
            rocketsCount++;

            System.out.println("Loading U1." + rocketsCount + "...");

            for (Item item : itemsToLoad) {
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    loadedItems++;
                }
            }

            System.out.println("Loaded! Total weight: " + rocket.currentWeight);
            fleetU1.add(rocket);
        }

        System.out.println("Fleet U1: " + rocketsCount + " rockets");
        return fleetU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsToLoad) {
        ArrayList<Rocket> fleetU2 = new ArrayList<>();
        int loadedItems = 0;
        int rocketsCount = 0;

        while (loadedItems < itemsToLoad.size()) {
            // Create rocket
            Rocket rocket = new U2();
            rocketsCount++;

            System.out.println("Loading U2." + rocketsCount + "...");

            // Load items
            for (Item item : itemsToLoad) {
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    loadedItems++;
                }
            }

            System.out.println("Loaded! Total weight: " + rocket.currentWeight);
            fleetU2.add(rocket);
        }

        System.out.println("Fleet U2: " + rocketsCount + " rockets");
        return fleetU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (Rocket rocket : rockets) {
            totalCost += rocket.getCost();

            while (!(rocket.launch() && rocket.land())) {
                totalCost += rocket.getCost();
            }
        }

        return totalCost;
    }

    public void unloadItems(ArrayList<Item> items) {
        for (Item item : items) {
            item.unload();
        }
    }
}
