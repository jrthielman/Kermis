package com.example.kermis.kassa;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.attracties.interfaces.GokAttractie;
import com.example.kermis.inspecteur.BelastingInspecteur;

public class HoofdKassa {

    private static HoofdKassa instance;

    private int totaalVerkochteTickets;
    private int totaleOmzet;

    private double gereserveerdeBelasting;

    private HoofdKassa(){}

    public static synchronized HoofdKassa getInstance() {
        if(instance == null) {
            instance = new HoofdKassa();
            return instance;
        }
        return instance;
    }

    public void koopKaart(int prijsAttractie, Attractie attractie){
        if(attractie instanceof GokAttractie){
            gereserveerdeBelasting += ((GokAttractie) attractie)
                    .kansSpelBelastingBetalen();
            totaleOmzet +=prijsAttractie;
            totaalVerkochteTickets++;
        }else{
            totaleOmzet +=prijsAttractie;
            totaalVerkochteTickets++;
        }
    }

    public void betaalBelasting(int bedrag){
        totaleOmzet -= bedrag;
    }

    public void resetWaardes(){
        this.totaalVerkochteTickets = this.totaleOmzet = 0;
    }

    public void resetBelastingWaarde(){
        this.gereserveerdeBelasting = 0;
    }

    public String getGereserveerdeBelasting() {
        return String.format("%.2f",gereserveerdeBelasting);
    }

    public String getTotaleOmzet() {
        return new StringBuilder("" + this.totaleOmzet).
                insert(GeldWeergave.geefJuisteWaarde(this.totaleOmzet)[0], ".")
                .substring(0,GeldWeergave.geefJuisteWaarde(this.totaleOmzet)[1]);
    }

    public int getTotaalVerkochteTickets() {
        return totaalVerkochteTickets;
    }
}
