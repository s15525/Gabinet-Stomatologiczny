package diagramClass;

public class Mezczyzna extends Osoba.Plec {
    private String nazwiskorodoweMatki;

    public Mezczyzna(String nazwiskorodoweMatki) {
        this.nazwiskorodoweMatki = nazwiskorodoweMatki;
    }


    public String getNazwiskorodoweMatki() {
        return nazwiskorodoweMatki;
    }
}
