package test;

import diagramClass.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        //ekstencja
        WizytaExtent wizytaExtent = new WizytaExtent();

        Wizyta wizyta = new Wizyta(1,06, 04, 2020, "08:30", "19:00", 20.00, new int[]{});
        wizytaExtent.addWizyta(wizyta);

        Wizyta wizyta2 = new Wizyta(1,07, 04, 2020, "12:30", "19:00", 100.00,new int[]{});
        wizytaExtent.addWizyta(wizyta2);
        System.out.println();

        //ekstencja trwalosc
        wizytaExtent.saveState();
        WizytaExtent wizytaExtentFromSave = new WizytaExtent();
        wizytaExtentFromSave.getState();
        wizytaExtentFromSave.showWizytaExtent();
        System.out.println();

        //Atrybut  zlozony
        System.out.println(wizyta.getDataWizyty());
        wizytaExtent.showWizytaExtent();
        System.out.println();

        //Atrybut opcjonalny
        wizyta.setOpis("Pacjent podczas wizyty byl niespokojny");
        System.out.println();

        //atrybut powtarzalny
        Klient marek = new Klient("20.12.2000", "424235325325", new ArrayList<String>() {{
            add("300303030303");
            add("1214214214214");
        }});
        marek.imie = "Marek";
        marek.nazwisko = "Kowal";
        System.out.println();

        //Atrybut klasowy w klasie diagramClass.WizytaExtent

        //atrybut pochodny zysk po odliczeniu podatku za obsluge
        double zysk = wizyta.getZysk();
        System.out.println("Zysk: " + zysk);
        System.out.println();

        //metoda klasowa
        StomatologExtent stomatologExtent = new StomatologExtent();
        System.out.println(stomatologExtent.ObliczPensje());
        System.out.println();

        //mozna wywolac na ekstencji bez obiektow
        Stomatolog ewa = new Stomatolog(1,"Multisport", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 300.0,new int[]{1});
        stomatologExtent.addStomatolog(ewa);
        System.out.println(stomatologExtent.ObliczPensje());
        System.out.println();

        //Przysloniecie metod
        Osoba pawel = new Klient("13.08.2000", "145215215215", new ArrayList<String>() {{
            add("300303030303");
            add("1214214214214");
        }});
        Osoba krystian = new Stomatolog(1,"Rower for free", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 500.0,new int[]{1});

        pawel.getData();
        krystian.getData();

        //Nadpisanie metody To String w klasie klient

        System.out.println(marek);
    }
}
