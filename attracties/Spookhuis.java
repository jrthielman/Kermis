package com.example.kermis.attracties;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.timeplay.TimeDelay;

import java.util.Random;
import java.util.Scanner;

public class Spookhuis extends Attractie {

    public Spookhuis(String naam, int prijs) {
        super(naam, prijs);
    }

    @Override
    public void gaInAttractie() {
        koopKaart();
        draai();
    }

    private void draai(){
        int randomGetal = new Random().nextInt(5) + 1;
        int wachtTijd = 5;
        if (randomGetal < 2) {
            System.out.println("Er staat een hele lange rij\n" +
                    "Je moet " + wachtTijd + " minuten wachten");
            for (int i = 1; i <= wachtTijd; i++) {
                System.out.print(i + " ");
                TimeDelay.seconds(3);
            }
            System.out.println();
        }
        System.out.println("Je gaat naar binnen bij het " + this + "\n");
        TimeDelay.seconds(3);
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
                    ontsnapt = true;
                } else {
                    System.out.println("De zombie heeft je gedood. Je maakt natuurlijk geen kans tegen een zombie!");
                    System.exit(0);
                }
            } else {
                System.out.println("Je ziet licht in de verte. Het is de uitgang. Je hebt het overleefd!\n");
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
