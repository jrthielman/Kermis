package com.example.kermis.exceptions;

public class AttractieLijstIsGevuldException extends Exception {

    public AttractieLijstIsGevuldException() {
        super("De attractie lijst mag maar 1 keer worden gevuld");
    }
}
