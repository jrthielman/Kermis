package com.example.kermis.kassa;

public class GeldWeergave {

    public static int[] geefJuisteWaarde(int totaalBedrag){
        if(totaalBedrag < 1000){
            return new int[]{0,0};
        }else if(totaalBedrag >= 1000 && totaalBedrag < 10_000){
            return new int[]{1,4};
        }else if(totaalBedrag >= 10_000 && totaalBedrag < 100_000){
            return new int[]{2,5};
        }else if(totaalBedrag >= 100_000 && totaalBedrag < 1_000_000){
            return new int[]{3,6};
        }else if(totaalBedrag >= 1_000_000 && totaalBedrag < 10_000_000){
            return new int[]{4,7};
        }else{
            return new int[]{5,8};
        }
    }
}
