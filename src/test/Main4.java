package test;

import diagramClass.Gosc;
import diagramClass.Klient;
import diagramClass.Osoba;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args){
        //unique 
        Klient marek = new Klient("Marek", "Pawlowski", "23.09.1997", "987997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        Klient kacper = new Klient("Marek", "Pawlowski", "23.08.1997", "997997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        //Klient nie zostanie dodany do extencji
        Klient pawel = new Klient("Marek", "Pawlowski", "23.10.1997", "987997979797", new ArrayList<>() {{
            add("7878878787");
        }});

        pawel.showKlientExtent();


    }
}
