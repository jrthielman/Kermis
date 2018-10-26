package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;
import java.util.Scanner;

public class SpiegelPaleis extends Attractie {

    public SpiegelPaleis() {
        super("spiegel paleis", 5400);
    }

    @Override
    public void gaInAttractie() {
        int randomGetal = new Random().nextInt(5)+1;
        if(randomGetal < 2) {
            System.out.println("Er staat een hele lange rij\n" +
                    "Wachttijd in minuten:");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                TimeDelay.seconds(3);
            }
        }
        System.out.println("Je gaat naar binnen bij de " + this + "\n");
        TimeDelay.seconds(2);
        System.out.println("Je bent binnen en kan de uitgang niet meer vinden, oh jeeh!\n" +
                "Je komt bij een kruispunt, ga je naar links of rechts?");
        boolean verdwaald = true;
        while(verdwaald){
            String input = new Scanner(System.in).nextLine();
            if(input.equalsIgnoreCase("links")){
                System.out.println("Je hebt de uitgang gevonden. Hoera!");
                verdwaald = false;
            }else{
                System.out.println("Je ziet de uitgang nog steeds niet en komt weer bij een kruispunt aan\n" +
                        "Ga je hier naar links of rechts?");
            }
        }
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
