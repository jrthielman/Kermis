package com.example.kermis.timeplay;

public class TimeDelay {

    public static void seconds(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(InterruptedException ie){
            System.out.println("Thread interrupted");
        }
    }

    public static void minutes(int minutes){
        try{
            Thread.sleep(minutes*60000);
        }catch(InterruptedException ie){
            System.out.println("Thread interrupted");
        }
    }

    public static void hours(int hours){
        try{
            Thread.sleep(hours*3600000);
        }catch(InterruptedException ie){
            System.out.println("Thread interrupted");
        }
    }
}
