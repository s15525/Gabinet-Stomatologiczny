package diagramClass;

public class Gosc extends Osoba {
    private String dataOdwiedzin;

    public Gosc(String imie, String nazwisko, String dataOdwiedzin) {
        super(imie, nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
    }

    public Gosc(Osoba osoba,String dataOdwiedzin) {
        super(osoba.imie,osoba.nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
    }
}
