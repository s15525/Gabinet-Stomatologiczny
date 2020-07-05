package diagramClass;

import java.util.List;

public class Dentist extends ObjectPlusPlus {
    private int id;
    private String dataZatrudnienia;
    private String benefityPracownicze;
    private List<String> iloscDyplomow;
    private double pensja;
    public int[] dyzurIds;

    public Dentist(int id, String benefityPracownicze, List<String> iloscDyplomow, double pensja, int[] dyzurIds) {
        this.id = id;
        this.benefityPracownicze = benefityPracownicze;
        this.iloscDyplomow = iloscDyplomow;
        this.pensja = pensja;
        this.dyzurIds = dyzurIds;
    }

    public double getPensja() {
        return pensja;
    }
    //Przesloniecie metod
    public String getData() {
        return dataZatrudnienia;
    }
}
