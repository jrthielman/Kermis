package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;

public class Hawaii extends Attractie {

    public Hawaii() {
        super("Hawaii", 5000);
    }

    @Override
    public void gaInAttractie() {
        int randomGetal = new Random().nextInt(5)+1;
        if(randomGetal < 2) {
            System.out.println("Alle stoelen zijn bezet. Je moet wachten tot de volgende ronde\n" +
                    "Wachttijd in minuten:");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                TimeDelay.seconds(3);
            }
        }
        System.out.println("Je stapt in de " + this + "\n");
        TimeDelay.seconds(2);
        System.out.println("De " + this + " start te bewegen en je hebt de tijd van je leven!");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
