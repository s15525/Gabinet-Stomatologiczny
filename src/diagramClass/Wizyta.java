package diagramClass;

public class Wizyta {
    //atrybut zlozony
    private int id;
    private int dzienMiesiaca;
    private int miesiac;
    private int rok;
    private String dataWizyty;
    //
    private String godzina_rozpoczecia;
    private String godzina_zakonczenia;
    private double koszt;
    //atrybut opcjonalny
    private String opis;
    //Zwykla asocjacja binarna
    public int[] dyzurIds;

    public Wizyta(int id,int dzienMiesiaca, int miesiac, int rok, String godzina_rozpoczecia, String godzina_zakonczenia, double koszt,int[] dyzurIds) {
        this.id = id;
        this.dzienMiesiaca = dzienMiesiaca;
        this.miesiac = miesiac;
        this.rok = rok;
        this.godzina_rozpoczecia = godzina_rozpoczecia;
        this.godzina_zakonczenia = godzina_zakonczenia;
        this.koszt = koszt;
        this.dataWizyty = dzienMiesiaca + "." + miesiac + "." + rok;

        this.dyzurIds = dyzurIds;
    }

    public int getDzienMiesiaca() {
        return dzienMiesiaca;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public int getRok() {
        return rok;
    }

    public String getDataWizyty() {
        return dataWizyty;
    }

    public String getGodzina_rozpoczecia() {
        return godzina_rozpoczecia;
    }

    public String getGodzina_zakonczenia() {
        return godzina_zakonczenia;
    }

    public double getKoszt() {
        return koszt;
    }

    public int getId() {
        return id;
    }

    public String getDyzurIds() {
        String dyzurIdsString = null;
        for (int i = 0; i< dyzurIds.length ; i++){
            dyzurIdsString += " "+ dyzurIds[i] ;
        }
        return dyzurIdsString;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    //Atrybut pochodny
    public double getZysk() {
        return koszt - koszt * 0.08;
    }

}
