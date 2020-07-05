package diagramClass;

public class Man extends Person.Plec {
    private String nazwiskorodoweMatki;

    public Man(String nazwiskorodoweMatki) {
        this.nazwiskorodoweMatki = nazwiskorodoweMatki;
    }


    public String getNazwiskorodoweMatki() {
        return nazwiskorodoweMatki;
    }
}
