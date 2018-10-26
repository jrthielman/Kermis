package com.example.kermis.attracties;

import com.example.kermis.exceptions.AttractieBestaatAllException;
import com.example.kermis.kassa.GeldWeergave;
import com.example.kermis.kassa.HoofdKassa;

import java.util.ArrayList;
import java.util.List;

public abstract class Attractie {

    private String naam;
    private int aantalTicketsVerkocht, prijs, totaalBedrag;

    public static List<Attractie> attractieLijst = new ArrayList<>();

    public Attractie(String naam, int prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public static void vulAttractieLijst(){
        attractieLijst.add(new BotsAutos());
        attractieLijst.add(new Spinner());
        attractieLijst.add(new SpiegelPaleis());
        attractieLijst.add(new Spookhuis());
        attractieLijst.add(new Hawaii());
        attractieLijst.add(new LadderKlimmen());
    }

    public abstract void gaInAttractie();

    public void koopKaart(){
        HoofdKassa.getInstance().koopKaart(this.prijs);
        aantalTicketsVerkocht++;
        this.totaalBedrag += this.prijs;
    }

    public void resetAlleWaardes(){
        this.prijs = this.aantalTicketsVerkocht = 0;
        HoofdKassa.getInstance().resetWaardes();
    }

    public void addAttracties(Attractie attractieNaam) throws AttractieBestaatAllException{
        if(attractieLijst.contains(attractieNaam)){
            throw new AttractieBestaatAllException();
        }else{
            attractieLijst.add(attractieNaam);
        }
    }

    public int aantalAttracties(){
        return attractieLijst.size();
    }

    public String getPrijs() {
        return new StringBuilder("" + this.prijs).
                insert(GeldWeergave.geefJuisteWaarde(this.prijs)[0], ".").substring(0,GeldWeergave.geefJuisteWaarde(this.prijs)[1]);
    }

    public String getTotaalBedrag() {
        return new StringBuilder("" + this.totaalBedrag).
                insert(GeldWeergave.geefJuisteWaarde(this.totaalBedrag)[0], ".")
                .substring(0,GeldWeergave.geefJuisteWaarde(this.totaalBedrag)[1]);
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalTicketsVerkocht() {
        return aantalTicketsVerkocht;
    }

}
