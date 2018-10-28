package com.example.kermis.attracties;

import com.example.kermis.attracties.abstracteklassen.RisicoRijkeAttracties;
import com.example.kermis.attracties.interfaces.GokAttractie;
import com.example.kermis.exceptions.OnderhoudAttractieException;
import com.example.kermis.timeplay.TimeDelay;

import java.util.Random;

public class Spinner extends RisicoRijkeAttracties implements GokAttractie {

    public Spinner(String naam, int prijs, onderhoudVersie onderhoudVersie) {
        super(naam, prijs, onderhoudVersie);
    }

    @Override
    public double kansSpelBelastingBetalen() {
        return Double.parseDouble(this.getPrijs()) * 0.3;
    }

    @Override
    public void gaInAttractie() {
        try{
            opstellingsKeuring();
            koopKaart();
            draai();
            inspectie();
        }catch(OnderhoudAttractieException oae){
            ondergaInspectie();
            koopKaart();
            draai();
            inspectie();
        }
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
        System.out.println("Je stapt in de " + this + "\n");
        TimeDelay.seconds(3);
        System.out.println("Je hebt het naar je zin maar het is al snel afgelopen. 'Wat een duur grapje' denk je. ");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
