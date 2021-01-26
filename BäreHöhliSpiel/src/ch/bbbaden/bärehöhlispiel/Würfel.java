/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.bärehöhlispiel;

/**
 *
 * @author flori
 */
public class Würfel {

    private final int zahl;
    private final int position;
    private int zahlhinterseite;

    public Würfel(int zahl,int position) {
        this.zahl = zahl;
        this.position = position;
    }


    public int getZahl() {
        return zahl;
    }

    public int getZahlhinterseite() {
        return zahlhinterseite;
    }

    public int getZahlHinterseite(int zahl) {
        int zahlhinterseite = 0;
        switch (zahl) {
            case 1:
                zahlhinterseite = 6;
                break;
            case 2:
                zahlhinterseite = 5;
                break;
            case 3:
                zahlhinterseite = 4;
                break;
            case 4:
                zahlhinterseite = 3;
                break;
            case 5:
                zahlhinterseite = 2;
                break;
            case 6:
                zahlhinterseite = 1;
                break;
        }
        return zahlhinterseite;
    }
    
    

}
