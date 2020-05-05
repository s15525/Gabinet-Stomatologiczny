package test;

import diagramClass.Gosc;
import diagramClass.Klient;
import diagramClass.Osoba;
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

        //Dziedziczenie dynamiczne
        Osoba marek = new Gosc("Marek","Pawlowski","18.12.2000");
        System.out.println(marek);

        marek = new Klient(marek,"23.08.1997","977997979797",new ArrayList<>(){{add("7878878787");}});
        System.out.println(marek);
        //Dziedziczenie wieloaspektowe

    }
}
