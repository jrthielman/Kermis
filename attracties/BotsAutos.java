package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;

public class BotsAutos extends Attractie {

    public BotsAutos() {
        super("botsauto's",2500);
    }

    @Override
    public void gaInAttractie() {
       int randomGetal = new Random().nextInt(5)+1;
       if(randomGetal < 2) {
           System.out.println("Alle auto's zijn bezet. Je moet wachten tot de volgende ronde\n" +
                   "Wachttijd in minuten:");
           for (int i = 0; i < 5; i++) {
               System.out.println(i);
               TimeDelay.seconds(3);
           }
       }
        System.out.println("Je stapt in de botsauto en doet het muntje erin\n");
        TimeDelay.seconds(2);
        System.out.println("Je zit in de " + this + " en je hebt de tijd van je leven!");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
