package diagramClass;

import java.util.List;

public class Worker extends ObjectPlusPlus {
    //Dziedziczenie overlapping
    private int NumerPracowniczy;
    private static String roleNameGeneralization = "generalization";
    private static String roleNameSekretarka = "SpecjalizacjaSekretarka";
    private static String roleNameAsystent = "SpecjalizacjaAsystent";
    private static String roleNameStomatolog = "SpecjalizacjaStomatolog";

    public Worker(int numerPracowniczy, int rokRozpoczeciaPracy, double pensja) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addSekretarka(rokRozpoczeciaPracy,pensja);
    }

    public Worker(int numerPracowniczy, String kwalfikacje) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addAsystent(kwalfikacje);
    }

    public Worker(int numerPracowniczy, int id, String benefityPracownicze, List<String> iloscDyplomow, double pensja, int[] dyzurIds) {
        super();
        this.NumerPracowniczy = numerPracowniczy;
        addStomatolog(id, benefityPracownicze, iloscDyplomow, pensja, dyzurIds);
    }

    private void addSekretarka(int rokRozpoczeciaPracy, double pensja) {
        Secretary secretary = new Secretary(rokRozpoczeciaPracy, pensja);
        this.addLink(roleNameSekretarka, roleNameGeneralization, secretary);
    }

    private void addAsystent(String kwalfikacje) {
        Assistant assistant = new Assistant(kwalfikacje);

        this.addLink(roleNameAsystent, roleNameGeneralization, assistant);
    }

    private void addStomatolog(int id, String benefityPracownicze, List<String> iloscDyplomow, double pensja, int[] dyzurIds) {
        Dentist dentist = new Dentist(id, benefityPracownicze, iloscDyplomow, pensja, dyzurIds);

        this.addLink(roleNameStomatolog, roleNameGeneralization, dentist);
    }


}
