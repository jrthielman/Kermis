package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;
import java.util.Scanner;

public class Spookhuis extends Attractie {

    public Spookhuis() {
        super("spookhuis", 4500);
    }

    @Override
    public void gaInAttractie() {
        int randomGetal = new Random().nextInt(5) + 1;
        if (randomGetal < 2) {
            System.out.println("Er staat een hele lange rij\n" +
                    "Wachttijd in minuten:");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                TimeDelay.seconds(3);
            }
        }
        System.out.println("Je gaat naar binnen bij de " + this + "\n");
        TimeDelay.seconds(2);
        System.out.println("Je bent binnen en het ziet er heel eng uit!\n" +
                "Er springt opeens een zombie uit de kast. Wil je deze slaan of vluchten?");
        boolean ontsnapt = false;
        while (!ontsnapt) {
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("slaan")) {
                int luckyNumber = new Random().nextInt(5) + 1;
                if (luckyNumber < 2) {
                    System.out.println("Je slaat de zombie en komt erachter dat het maar een pop is!\n" +
                            "Je schaamt enorm en loopt verslagen naar de uitgang...");
                } else {
                    System.out.println("De zombie heeft je gedood. Je bent dood!");
                    System.exit(0);
                }
            } else {
                System.out.println("Je ziet een licht in de verte. Het is de uitgang. Je hebt het overleefd!\n");
                ontsnapt = true;
            }
        }
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
