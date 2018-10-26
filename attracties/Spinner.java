package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;

public class Spinner extends Attractie {

    public Spinner() {
        super("Spinner", 6000);
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
        System.out.println("Je stapt in de " + this + "\n");
        TimeDelay.seconds(2);
        System.out.println("Je hebt het naar je zin en het is al snel afgelopen. 'Wat een duur grapje' denk je. ");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
