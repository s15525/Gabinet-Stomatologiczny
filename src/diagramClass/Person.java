package diagramClass;

import java.util.ArrayList;
import java.util.List;

//klasa abstrakcyjna

public abstract class Person {
    //Dziedziczenie dynamiczne
    protected String imie;
    protected String nazwisko;
    private String plecKto;
    private String informacjaDodatkowa;
    private List<Plec> plecs = new ArrayList<>();

    public Person(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Plec setKobieta(String nazwiskoPanienskie){
            Plec plec = new Women(nazwiskoPanienskie);
            plecKto = "kobieta";
            informacjaDodatkowa = nazwiskoPanienskie;
            plecs.add(plec);
            return plec;
    }
    public Plec setMezczyzna(String nazwiskoRodoweMatki){
        Plec plec = new Man(nazwiskoRodoweMatki);
        plecKto = "mezczyzna";
        informacjaDodatkowa = nazwiskoRodoweMatki;
        plecs.add(plec);
        return plec;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    public List<Plec> getPlecs() {
        return plecs;
    }

    public String getPlecKto() {
        return plecKto;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPlecKto(String plecKto) {
        this.plecKto = plecKto;
    }

    public String getInformacjaDodatkowa() {
        return informacjaDodatkowa;
    }

    public void setInformacjaDodatkowa(String informacjaDodatkowa) {
        this.informacjaDodatkowa = informacjaDodatkowa;
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
