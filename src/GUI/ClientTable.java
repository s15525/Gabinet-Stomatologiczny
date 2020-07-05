package GUI;

public class ClientTable {
    String imie;
    String nazwisko;
    String dataurodzenia;
    String pesel;
    String numertelefonu;
    //Klasa sluzaca do wyswietlania zawartosci ekstencji klient
    public ClientTable(String imie, String nazwisko, String dataurodzenia, String pesel, String numertelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataurodzenia = dataurodzenia;
        this.pesel = pesel;
        this.numertelefonu = numertelefonu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    public String getNumertelefonu() {
        return numertelefonu;
    }

    public void setNumertelefonu(String numertelefonu) {
        this.numertelefonu = numertelefonu;
    }
}
