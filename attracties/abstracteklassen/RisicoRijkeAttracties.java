package com.example.kermis.attracties.abstracteklassen;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.exceptions.OnderhoudAttractieException;
import com.example.kermis.onderhoud.Inspecteur;
import com.example.kermis.timeplay.TimeDelay;

public abstract class RisicoRijkeAttracties extends Attractie {

    private final int DRAAI_LIMIET_V1 = 5;
    private final int DRAAI_LIMIET_V2 = 10;

    private int aantalKerenGedraaid;
    private onderhoudVersie versie;

    protected enum onderhoudVersie{
        V1,V2
    }

    public RisicoRijkeAttracties(String naam, int prijs, onderhoudVersie versie) {
        super(naam, prijs);
        this.versie = versie;
    }

    protected void opstellingsKeuring() throws OnderhoudAttractieException{
        switch(this.versie){
            case V1:
                if(aantalKerenGedraaid < DRAAI_LIMIET_V1){
                    aantalKerenGedraaid++;
                }else{
                     throw new OnderhoudAttractieException();
                }
            default:
                if(aantalKerenGedraaid < DRAAI_LIMIET_V2){
                    aantalKerenGedraaid++;
                }else{
                    throw new OnderhoudAttractieException();
                }
        }
    }

    protected void ondergaInspectie(){
        System.out.println(this + " moet worden geinspecteerd");
        for(int i = 0; i <= 5; i++){
            System.out.print(" . " );
            TimeDelay.seconds(1);
        }
        aantalKerenGedraaid = 0;
        System.out.println("\nDe inspectie is klaar. U mag naar binnen!\n");
        TimeDelay.seconds(2);
    }

    public int getAantalKerenGedraaid() {
        return aantalKerenGedraaid;
    }

    public onderhoudVersie getVersie() {
        return versie;
    }
}
