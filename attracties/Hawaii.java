package com.example.kermis.attracties;

import com.example.kermis.attracties.abstracteklassen.RisicoRijkeAttracties;
import com.example.kermis.exceptions.OnderhoudAttractieException;
import com.example.kermis.timeplay.TimeDelay;

import java.util.Random;

public class Hawaii extends RisicoRijkeAttracties {

    public Hawaii(String naam, int prijs, onderhoudVersie onderhoudVersie) {
        super(naam, prijs, onderhoudVersie);
    }

    @Override
    public void gaInAttractie() {
        try{
            opstellingsKeuring();
            koopKaart();
            draai();
        }catch(OnderhoudAttractieException oae){
            ondergaInspectie();
            koopKaart();
            draai();
        }
    }

    private void draai(){
        int randomGetal = new Random().nextInt(5)+1;
        int wachttijd = 5;
        if(randomGetal < 2) {
            System.out.println("Alle stoelen zijn bezet. Je moet wachten tot de volgende ronde\n" +
                    "Je moet " + wachttijd + " minuten wachten");
            for (int i = 1; i <= wachttijd; i++) {
                System.out.print(i + " ");
                TimeDelay.seconds(3);
            }
            System.out.println();
        }
        System.out.println("Je stapt in de " + this + " en het begint te bewegen\n");
        TimeDelay.seconds(3);
        System.out.println("De " + this + " gaat steeds harder en je begint de longen uit je lijf te schreeuwen! Leuk!");
        TimeDelay.seconds(5);
    }

    @Override
    public String toString() {
        return getNaam();
    }
}
