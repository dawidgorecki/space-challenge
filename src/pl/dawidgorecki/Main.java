package pl.dawidgorecki;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Simulation simulation = new Simulation();

        try {
            ArrayList<Item> itemsForPhase1 = simulation.loadItems("phase-1.txt");
            ArrayList<Item> itemsForPhase2 = simulation.loadItems("phase-2.txt");

            System.out.println("[ U1 - Phase 1 ]");
            ArrayList<Rocket> rocketsU1ForPhase1 = simulation.loadU1(itemsForPhase1);
            int costU1P1 = simulation.runSimulation(rocketsU1ForPhase1);

            System.out.println("[ U1 - Phase 2 ]");
            ArrayList<Rocket> rocketsU1ForPhase2 = simulation.loadU1(itemsForPhase2);
            int costU1P2 = simulation.runSimulation(rocketsU1ForPhase2);

            simulation.unloadItems(itemsForPhase1);
            simulation.unloadItems(itemsForPhase2);

            System.out.println("[ U2 - Phase 1 ]");
            ArrayList<Rocket> rocketsU2ForPhase1 = simulation.loadU2(itemsForPhase1);
            int costU2P1 = simulation.runSimulation(rocketsU2ForPhase1);

            System.out.println("[ U2 - Phase 2 ]");
            ArrayList<Rocket> rocketsU2ForPhase2 = simulation.loadU2(itemsForPhase2);
            int costU2P2 = simulation.runSimulation(rocketsU2ForPhase2);

            System.out.println("\n--- Summary U1 ---");
            System.out.println("Phase 1: $" + costU1P1);
            System.out.println("Phase 2: $" + costU1P2);
            System.out.println("Total cost: $" + (costU1P1 + costU1P2));

            System.out.println("\n--- Summary U2 ---");
            System.out.println("Phase 1: $" + costU2P1);
            System.out.println("Phase 2: $" + costU2P2);
            System.out.println("Total cost: $" + (costU2P1 + costU2P2));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
