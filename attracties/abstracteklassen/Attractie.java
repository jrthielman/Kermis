package com.example.kermis.attracties.abstracteklassen;

import com.example.kermis.attracties.*;
import com.example.kermis.attracties.interfaces.GokAttractie;
import com.example.kermis.exceptions.AttractieBestaatAllException;
import com.example.kermis.exceptions.AttractieLijstIsGevuldException;
import com.example.kermis.inspecteur.BelastingInspecteur;
import com.example.kermis.kassa.GeldWeergave;
import com.example.kermis.kassa.HoofdKassa;
import com.example.kermis.timeplay.TimeDelay;

import java.util.ArrayList;
import java.util.List;

public abstract class Attractie {

    private String naam;
    private int aantalTicketsVerkocht, prijs, totaalBedrag;
    private double gereserveerdeBelasting;

    private static List<Attractie> attractieLijst = new ArrayList<>();

    public Attractie(String naam, int prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public static void vulAttractieLijst() throws AttractieLijstIsGevuldException {
        if(attractieLijst.isEmpty()){
            attractieLijst.add(new BotsAutos("botsauto's",2500));
            attractieLijst.add(new Spinner("Spinner", 6000,RisicoRijkeAttracties.onderhoudVersie.V1));
            attractieLijst.add(new SpiegelPaleis("spiegel paleis", 5400));
            attractieLijst.add(new Spookhuis("spookhuis", 4500));
            attractieLijst.add(new Hawaii("Hawaii", 5000, RisicoRijkeAttracties.onderhoudVersie.V2));
            attractieLijst.add(new LadderKlimmen("ladder klimmen", 2500));
        }else{
            throw new AttractieLijstIsGevuldException();
        }
    }

    public static List<Attractie> getAttractieLijst() {
        return attractieLijst;
    }

    public abstract void gaInAttractie();

    public void koopKaart(){
        printPrijs();
        HoofdKassa.getInstance().koopKaart(this.prijs, this);
        aantalTicketsVerkocht++;
        this.totaalBedrag += this.prijs;
    }

    public void inspectie(){
        if(this instanceof GokAttractie){
            GokAttractie tempAttractie = ((GokAttractie)this);
            this.gereserveerdeBelasting += tempAttractie.kansSpelBelastingBetalen();
            if(BelastingInspecteur.belastingTijd()){
                System.out.println("\nDe belasting inspecteur komt langs");
                TimeDelay.seconds(2);
                int belastingBedrag;
                for(Attractie at : attractieLijst){
                    if(at instanceof GokAttractie){
                        if(at.getIntTotaalBedrag() > 0){
                            double controleGetal = BelastingInspecteur.haalBelastingOp(this)*1000;
                            if(controleGetal < 1000) {
                                belastingBedrag = Integer.parseInt(("" +
                                        (BelastingInspecteur.haalBelastingOp(this) * 1000))
                                        .substring(0, 3));
                            }else if(controleGetal >= 1000 && controleGetal < 10_000) {
                                belastingBedrag = Integer.parseInt(("" +
                                        (BelastingInspecteur.haalBelastingOp(this) * 1000))
                                        .substring(0, 4));
                            }else{
                                belastingBedrag = Integer.parseInt(("" +
                                        (BelastingInspecteur.haalBelastingOp(this) * 1000))
                                        .substring(0, 5));
                            }
                            at.betaalBelasting(belastingBedrag);
                            HoofdKassa.getInstance().betaalBelasting(belastingBedrag);
                            System.out.println("Totaal bedrag = " + at.getTotaalBedrag() + " belasting = " + belastingBedrag);
                        }
                    }
                }
                System.out.println("\nDe inspecteur heeft $" + HoofdKassa.getInstance().getGereserveerdeBelasting() + " opgehaald\n");
                HoofdKassa.getInstance().resetBelastingWaarde();
                TimeDelay.seconds(2);
            }
        }
    }

    public void betaalBelasting(int bedrag){
        this.totaalBedrag -= bedrag;
        this.gereserveerdeBelasting = 0;
    }

    private void printPrijs(){
        System.out.println(this.getNaam().equals("spiegel paleis") | this.getNaam().equals("spookhuis")
                | this.getNaam().equals("ladder klimmen") ? "het " + this + " kost $" +
                this.getPrijs() + "\n" + "Je hebt een kaart gekocht\n" :
                "de " + this + " kost $" + this.getPrijs() + "\n" +
                        "Je hebt een kaart gekocht\n");
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

    public String getGereserveerdeBelasting() {
        if(this instanceof GokAttractie){
            return String.format("%.2f",gereserveerdeBelasting);
        }
        System.out.println(this + " reserveert geen belasting");
        return null;
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

    public int getIntTotaalBedrag() {
        return this.totaalBedrag;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalTicketsVerkocht() {
        return aantalTicketsVerkocht;
    }

}
