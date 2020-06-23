package diagramClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Gosc extends Osoba {
    //ograniczenie atrybutu
    private String dataOdwiedzin;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDateTime now = LocalDateTime.now();
    private static List<Gosc> extent = new ArrayList<>();

    public Gosc(String imie, String nazwisko, String dataOdwiedzin) {
        super(imie, nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
        extent.add(this);
    }

    public Gosc(Osoba osoba, String dataOdwiedzin) {
        super(osoba.imie, osoba.nazwisko);
        this.dataOdwiedzin = dataOdwiedzin;
        extent.add(this);
    }

    public String getData() {
        return "Data odwiedzin " + dataOdwiedzin;
    }

    public void setDataOdwiedzin(String dataOdwiedzin) {
        String[] dataOdwiedzintab = dataOdwiedzin.split("[.]");
        String[] dataNow = dtf.format(now).split("[.]");
        if (Integer.parseInt(dataOdwiedzintab[0]) >= Integer.parseInt(dataNow[0]) && Integer.parseInt(dataOdwiedzintab[1]) >= Integer.parseInt(dataNow[1]) && Integer.parseInt(dataOdwiedzintab[2]) >= Integer.parseInt(dataNow[2])) {
            System.out.println("Data z przyszlosci");
        } else {
            this.dataOdwiedzin = dataOdwiedzin;
        }
    }

    @Override
    public String toString() {
        return "Gosc{" +
                "dataOdwiedzin='" + dataOdwiedzin + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }

    public String getDataOdwiedzin() {
        return dataOdwiedzin;
    }


}
