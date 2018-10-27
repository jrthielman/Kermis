package com.example.kermis;

import com.example.kermis.attracties.abstracteklassen.Attractie;
import com.example.kermis.attracties.abstracteklassen.RisicoRijkeAttracties;
import com.example.kermis.exceptions.AttractieLijstIsGevuldException;
import com.example.kermis.kassa.HoofdKassa;
import com.example.kermis.onderhoud.Inspecteur;
import com.example.kermis.timeplay.TimeDelay;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { new Main().start(); }

    private void start(){
        if(!play()){
            printMessage("Tot ziens!");
        }
    }

    private boolean play(){

        try{
            Attractie.vulAttractieLijst();
        }catch(AttractieLijstIsGevuldException alige){
            System.out.println(alige);
        }
        Attractie attractie;

        int intInput;
        String stringInput;
        printMessage("Welkom bij de kermis!");
        while(true){
            try{
                printKeuzeMenu(1);
                intInput = scanner.nextInt();
                scanner.nextLine();
                if(intInput == 7){
                    return false;
                }
            }catch(InputMismatchException ime){
                scanner = new Scanner(System.in);
                printGeefEenGetal();
                continue;
            }
            if(intInput > 0 && intInput < 7){
                attractie = kiesAtractie(intInput);
                attractie.gaInAttractie();
                printMessage("\nJe gaat weer op zoek naar een andere attractie\n");
                TimeDelay.seconds(1);
                printKeuzeMenu(2);
                stringInput = scanner.nextLine();
                if(printOverzicht(stringInput)){
                    TimeDelay.seconds(5);
                }

            }else{
                printMessageVerkeerdeInput(intInput);
                printKeuzeMenu(1);
            }

        }
    }

    private Attractie kiesAtractie(int input){
        return Attractie.getAttractieLijst().get(input-1);
    }

    private boolean printOverzicht(String keuze){
        switch (keuze){
            case "p":
                System.out.println();
                for(Attractie attractie : Attractie.getAttractieLijst()){
                    System.out.println(attractie + " totaal: $" + attractie.getTotaalBedrag());
                }
                System.out.println("Totaal opgehaald: $" + HoofdKassa.getInstance().getTotaalGeldOpgehaald());
                return true;
            case "t":
                System.out.println();
                for(Attractie attractie : Attractie.getAttractieLijst()){
                    System.out.println(attractie + " tickets: " + attractie.getAantalTicketsVerkocht());
                }
                System.out.println("Totaal tickets verkocht: " + HoofdKassa.getInstance().getTotaalVerkochteTickets());
                return true;
                default:
                    return false;
        }
    }

    private void printKeuzeMenu(int keuze){
        switch (keuze){
            case 1:
                printMessage("\n1 voor botsauto's\n" +
                        "2 voor spinner\n3 voor spiegel paleis\n" +
                        "4 voor spookhuis\n5 voor hawaii\n" +
                        "6 voor ladder klimmen\n" +
                        "7 om naar huis te gaan");
                break;
            case 2:
                printMessage("Wil je een totaal overzicht?\nt voor het totaal verkochte kaarten\n" +
                        "p voor totaal opgehaalde bedragen\n\ndruk enter om opnieuw een attractie te kiezen");
        }
    }

    private void printMessage(String message){
        System.out.println(message);
    }

    private void printMessageVerkeerdeInput(int input){
        System.out.println(input + " is geen geldige input.\n" +
                "Probeer het nogmaals\n");
        TimeDelay.seconds(1);
    }

    private void printGeefEenGetal(){
        System.out.println("Geef 1 van de onderstaande getallen door\n");
        TimeDelay.seconds(1);
    }
}
