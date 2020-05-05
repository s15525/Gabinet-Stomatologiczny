package test;

import diagramClass.Pracownik;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        //Dziedziczenie overlapping
        Pracownik martaSekrektarka = new Pracownik(123,1997,200.0);
        Pracownik ewaAsystent = new Pracownik(321,"Zarzadzanie");
        Pracownik martynaStomatolog = new Pracownik(453,1,"Multisport", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 300.0,new int[]{1});


    }
}
