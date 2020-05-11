package diagramClass;

import java.util.ArrayList;
import java.util.List;

//klasa abstrakcyjna

public abstract class Osoba {
    //Dziedziczenie dynamiczne
    protected String imie;
    protected String nazwisko;
    private List<Plec> plecs = new ArrayList<>();

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Plec setKobieta(String nazwiskoPanienskie){
            Plec plec = new Kobieta(nazwiskoPanienskie);
            plecs.add(plec);
            return plec;
    }
    public Plec setMezczyzna(String nazwiskoRodoweMatki){
        Plec plec = new Mezczyzna(nazwiskoRodoweMatki);
        plecs.add(plec);
        return plec;
    }

    public String getData() {
        return imie+nazwisko;
    }

    public String toString() {
        return "Oto moje imie " + imie + " Oto moje nazwisko " + nazwisko ;
    }

    public static class Plec{
        Plec(){
        }
    }
}
