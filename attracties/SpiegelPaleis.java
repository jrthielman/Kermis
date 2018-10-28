package com.example.kermis.attracties;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.timeplay.TimeDelay;

import java.util.Random;
import java.util.Scanner;

public class SpiegelPaleis extends Attractie {

    public SpiegelPaleis(String naam, int prijs) {
        super(naam, prijs);
    }

    @Override
    public void gaInAttractie() {
        koopKaart();
        draai();
    }

    private void draai(){
        int randomGetal = new Random().nextInt(5)+1;
        int wachtTijd = 5;
        if(randomGetal < 2) {
            System.out.println("Er staat een hele lange rij\n" +
                    "Je moet " + wachtTijd + " minuten wachten");
            for (int i = 1; i <= wachtTijd; i++) {
                System.out.print(i + " ");
                TimeDelay.seconds(3);
            }
            System.out.println();
        }
        System.out.println("Je gaat naar binnen bij het " + this + "\n");
        TimeDelay.seconds(5);
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
