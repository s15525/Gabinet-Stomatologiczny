package diagramClass;

public class Kobieta extends Osoba.Plec{
    private String nazwiskoPanienskie;

    public Kobieta(String nazwiskoPanienskie) {
        this.nazwiskoPanienskie = nazwiskoPanienskie;
    }

    public String getNazwiskoPanienskie() {
        return nazwiskoPanienskie;
    }
}
