package test;

import diagramClass.Guest;
import diagramClass.Client;
import diagramClass.Person;
import diagramClass.Worker;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        //Dziedziczenie overlapping
        Worker martaSekrektarka = new Worker(123, 1997, 200.0);
        Worker ewaAsystent = new Worker(321, "Zarzadzanie");
        Worker martynaStomatolog = new Worker(453, 1, "Multisport", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 300.0, new int[]{1});

        //Dziedziczenie dynamiczne
        Person marek = new Guest("Marek", "Pawlowski", "18.12.2000");
        Person kacper = new Guest("Marek", "Pawlowski", "18.12.2000");
        System.out.println(marek);

        marek = new Client(marek, "23.08.1997", "977997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        kacper = new Client(marek, "23.08.1997", "977997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        System.out.println(marek);
        //Dziedziczenie wieloaspektowe
        Person marta = new Guest("Marta", "Martinczuk", "18.11.2000");

        marek.setMezczyzna("Ziolko");
        marta.setKobieta("Golebiewska");

        //Polimorficzne wywolanie metod
        //klient
        Person vanessa = new Guest("Vanessa", "Pawlowski", "18.12.2000");
        System.out.println(vanessa.getData());
        //gosc
        System.out.println(marek.getData());
    }
}
