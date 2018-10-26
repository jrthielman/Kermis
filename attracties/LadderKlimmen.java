package com.example.kermis.attracties;

import com.example.kermis.timePlay.TimeDelay;

import java.util.Random;

public class LadderKlimmen extends Attractie {

    public LadderKlimmen() {
        super("ladder klimmen", 1500);
    }


    @Override
    public void gaInAttractie() {
        int randomGetal = new Random().nextInt(5)+1;
        if(randomGetal < 2) {
            System.out.println("Je moet wachten tot de volgende ronde\n" +
                    "Wachttijd in minuten:");
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                TimeDelay.seconds(3);
            }
        }
        System.out.println("Je staat in de rij bij het " + this + "\n");
        TimeDelay.seconds(2);
        System.out.println("Je bent aan de beurt en begint te klimmen. Wat een leuke attractie, al ben je er niet zo goed in!");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
