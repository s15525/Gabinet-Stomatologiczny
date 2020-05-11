package diagramClass;

public class Gosc extends Osoba {
    //ograniczenie atrybutu
    private String dataOdwiedzin;

    public Gosc(String imie, String nazwisko, String dataOdwiedzin) {
        super(imie, nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
    }

    public Gosc(Osoba osoba,String dataOdwiedzin) {
        super(osoba.imie,osoba.nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
    }

    public String getData() {
        return "Data odwiedzin " + dataOdwiedzin;
    }

    public void setDataOdwiedzin(String dataOdwiedzin) {
        this.dataOdwiedzin = dataOdwiedzin;
    }

    @Override
    public String toString() {
        return "Gosc{" +
                "dataOdwiedzin='" + dataOdwiedzin + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
