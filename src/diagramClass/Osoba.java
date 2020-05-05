package diagramClass;

public abstract class Osoba {
    //Dziedziczenie dynamiczne
    protected String imie;
    protected String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getData() {
        return imie+nazwisko;
    }

    public String toString() {
        return "Oto moje imie " + imie + " Oto moje nazwisko " + nazwisko ;
    }
}
