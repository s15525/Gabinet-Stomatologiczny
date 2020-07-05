package diagramClass;

public class Women extends Person.Plec{
    private String nazwiskoPanienskie;

    public Women(String nazwiskoPanienskie) {
        this.nazwiskoPanienskie = nazwiskoPanienskie;
    }

    public String getNazwiskoPanienskie() {
        return nazwiskoPanienskie;
    }
}
