package com.example.kermis.kassa;

public class HoofdKassa {

    private static HoofdKassa instance;

    private int totaalVerkochteTickets;
    private int totaalGeldOpgehaald;

    private HoofdKassa(){}

    public static synchronized HoofdKassa getInstance() {
        if(instance == null) {
            instance = new HoofdKassa();
            return instance;
        }
        return instance;
    }

    public void koopKaart(int prijsAttractie){
        totaalGeldOpgehaald+=prijsAttractie;
        totaalVerkochteTickets++;
    }

    public void resetWaardes(){
        this.totaalVerkochteTickets = this.totaalGeldOpgehaald = 0;
    }

    public String getTotaalGeldOpgehaald() {
        return new StringBuilder("" + this.totaalGeldOpgehaald).
                insert(GeldWeergave.geefJuisteWaarde(this.totaalGeldOpgehaald)[0], ".")
                .substring(0,GeldWeergave.geefJuisteWaarde(this.totaalGeldOpgehaald)[1]);
    }

    public int getTotaalVerkochteTickets() {
        return totaalVerkochteTickets;
    }
}
