package com.example.kermis.inspecteur;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.attracties.interfaces.GokAttractie;
import com.example.kermis.kassa.HoofdKassa;

public class BelastingInspecteur {

    static private final int CONTROLE_TIJD = 10;
    static private int tijdVerlopen;

    static private double opgehaaldBelasting;

    static public double haalBelastingOp(Attractie attractie){
        tijdVerlopen = 0;
        double totaalBedrag = Double.parseDouble(attractie.getTotaalBedrag());
        opgehaaldBelasting += totaalBedrag * 0.3;
        return totaalBedrag * 0.3;
    }

    static public boolean belastingTijd(){
        if(tijdVerlopen == CONTROLE_TIJD-1){
            return true;
        }else{
            tijdVerlopen++;
            return false;
        }
    }

    static public String getOpgehaaldBelasting() {
        return String.format("%.2f", opgehaaldBelasting);
    }
}
