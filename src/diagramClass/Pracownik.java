package diagramClass;

import java.util.List;

public class Pracownik extends ObjectPlusPlus {
    //Dziedziczenie overlapping
    private int NumerPracowniczy;
    private static String roleNameGeneralization = "generalization";
    private static String roleNameSekretarka = "SpecjalizacjaSekretarka";
    private static String roleNameAsystent = "SpecjalizacjaAsystent";
    private static String roleNameStomatolog = "SpecjalizacjaStomatolog";

    public Pracownik(int numerPracowniczy,int rokRozpoczeciaPracy, double pensja) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addSekretarka(rokRozpoczeciaPracy,pensja);
    }

    public Pracownik(int numerPracowniczy,String kwalfikacje) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addAsystent(kwalfikacje);
    }

    public Pracownik(int numerPracowniczy,int id, String benefityPracownicze, List<String> iloscDyplomow, double pensja, int[] dyzurIds) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addStomatolog(id, benefityPracownicze, iloscDyplomow, pensja, dyzurIds);
    }

    private void addSekretarka(int rokRozpoczeciaPracy, double pensja) {
        Sekretarka sekretarka = new Sekretarka(rokRozpoczeciaPracy, pensja);
        this.addLink(roleNameSekretarka, roleNameGeneralization, sekretarka);
    }

    private void addAsystent(String kwalfikacje) {
        Asystent asystent = new Asystent(kwalfikacje);

        this.addLink(roleNameAsystent, roleNameGeneralization, asystent);
    }

    private void addStomatolog(int id, String benefityPracownicze, List<String> iloscDyplomow, double pensja, int[] dyzurIds) {
        Stomatolog stomatolog = new Stomatolog(id, benefityPracownicze, iloscDyplomow, pensja, dyzurIds);

        this.addLink(roleNameStomatolog, roleNameGeneralization, stomatolog);
    }


}
