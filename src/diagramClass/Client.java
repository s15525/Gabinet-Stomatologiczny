package diagramClass;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    //Dziedziczenie dynamiczne
    public String dataurodzenia;
    //unique
    String pesel;
    //atrybut powtarzalny
    public List<String> numeryTelefonu;
    private List<Zab> zabs = new ArrayList<>();
    private static List<Client> extent = new ArrayList<>();

    public Client(String imie, String nazwisko, String dataurodzenia, String pesel, List<String> numeryTelefonu) {
        super(imie, nazwisko);
        this.dataurodzenia = dataurodzenia;
        this.numeryTelefonu = numeryTelefonu;
        this.pesel = pesel;
        extent.add(this);
        checkPeselExistsInExtent(pesel);
    }

    public Client(Person person, String dataurodzenia, String pesel, List<String> numeryTelefonu) {
        super(person.imie, person.nazwisko);
        this.dataurodzenia = dataurodzenia;
        this.numeryTelefonu = numeryTelefonu;
        this.pesel = pesel;
        extent.add(this);
        checkPeselExistsInExtent(pesel);
    }

    public String getDataurodzenia() {
        return dataurodzenia;
    }

    public void setDataurodzenia(String dataurodzenia) {
        this.dataurodzenia = dataurodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNumeryTelefonu() {
        String result = "";
        for (String a:
             numeryTelefonu) {
            result += a +"\n";
        }
        return result;
    }

    public void setNumeryTelefonu(List<String> numeryTelefonu) {
        this.numeryTelefonu = numeryTelefonu;
    }

    public Zab createZab(String stanOgolny, int ilosc, String zapach, String kolor) {
        Zab zab = new Zab(stanOgolny, ilosc, zapach, kolor);
        zabs.add(zab);
        return zab;
    }
    public void checkPeselExistsInExtent(String pesel){
        for (int i = 0; i < extent.size()-1; i++) {
           if(extent.get(i).pesel.equals(pesel)){
               extent.remove(extent.size()-1);
           }
        }
    }
    //Przesloniecie metod
    public String getData() {
        return "Data urodzenia "+ dataurodzenia;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "dataurodzenia='" + dataurodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numeryTelefonu=" + numeryTelefonu +
                ", zabs=" + zabs +
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

    public void showKlientExtent() {
        System.out.println(Client.class.getName());
        extent.forEach(System.out::println);
    }

}
