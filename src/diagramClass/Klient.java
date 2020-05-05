package diagramClass;

import java.util.ArrayList;
import java.util.List;

public class Klient extends Osoba {
    //Dziedziczenie dynamiczne
    public String dataurodzenia;
    public String pesel;
    //atrybut powtarzalny;
    public List<String> numeryTelefonu;
    private List<Zab> zabs = new ArrayList<>();

    public Klient(String imie, String nazwisko, String dataurodzenia, String pesel, List<String> numeryTelefonu) {
        super(imie, nazwisko);

        this.dataurodzenia = dataurodzenia;
        this.pesel = pesel;
        this.numeryTelefonu = numeryTelefonu;
    }

    public Klient(Osoba osoba, String dataurodzenia, String pesel, List<String> numeryTelefonu) {
        super(osoba.imie, osoba.nazwisko);

        this.dataurodzenia = dataurodzenia;
        this.pesel = pesel;
        this.numeryTelefonu = numeryTelefonu;
    }

    public Zab createZab(String stanOgolny, int ilosc, String zapach, String kolor) {
        Zab zab = new Zab(stanOgolny, ilosc, zapach, kolor);
        zabs.add(zab);
        return zab;
    }

    //Przesloniecie metod
    public String getData() {
        return dataurodzenia;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "dataurodzenia='" + dataurodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numeryTelefonu=" + numeryTelefonu +
                ", zabs=" + zabs +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }

    public class Zab {
        private String stanOgolny;
        private int ilosc;
        private String zapach;
        private String kolor;

        public Zab(String stanOgolny, int ilosc, String zapach, String kolor) {
            this.stanOgolny = stanOgolny;
            this.ilosc = ilosc;
            this.zapach = zapach;
            this.kolor = kolor;
        }

        @Override
        public String toString() {
            return "Zab{" +
                    "stanOgolny='" + stanOgolny + '\'' +
                    ", ilosc=" + ilosc +
                    ", zapach='" + zapach + '\'' +
                    ", kolor='" + kolor + '\'' +
                    '}';
        }
    }
}
