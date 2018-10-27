package com.example.kermis.attracties;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.timeplay.TimeDelay;

import java.util.Random;

public class BotsAutos extends Attractie {

    public BotsAutos() {
        super("botsauto's",2500);
    }

    @Override
    public void gaInAttractie() {
       int randomGetal = new Random().nextInt(5)+1;
       int wachtTijd = 5;
       if(randomGetal < 2) {
           System.out.println("Alle auto's zijn bezet. Je moet wachten tot de volgende ronde\n" +
                   "Je moet " + wachtTijd + " minuten wachten");
           for (int i = 1; i <= wachtTijd; i++) {
               System.out.print(i + " ");
               TimeDelay.seconds(3);
           }
           System.out.println();
       }
        System.out.println("Je stapt in de botsauto en wacht tot je kan rijden.\n");
        TimeDelay.seconds(3);
        System.out.println("Je zit in de " + this + " en je hebt de tijd van je leven!");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
