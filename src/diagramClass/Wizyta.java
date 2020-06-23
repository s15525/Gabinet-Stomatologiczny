package diagramClass;

public class Wizyta {
    //atrybut zlozony
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
    public int klientIds;

    public Wizyta(int dzienMiesiaca, int miesiac, int rok, String godzina_rozpoczecia, String godzina_zakonczenia, double koszt,int[] dyzurIds,int klientIds) {
        this.dzienMiesiaca = dzienMiesiaca;
        this.miesiac = miesiac;
        this.rok = rok;
        this.godzina_rozpoczecia = godzina_rozpoczecia;
        this.godzina_zakonczenia = godzina_zakonczenia;
        this.koszt = koszt;
        this.dataWizyty = dzienMiesiaca + "." + miesiac + "." + rok;

        this.dyzurIds = dyzurIds;
        this.klientIds= klientIds;
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

    public String getDyzurIds() {
        String dyzurIdsString = null;
        for (int i = 0; i< dyzurIds.length ; i++){
            dyzurIdsString += " "+ dyzurIds[i] ;
        }
        return dyzurIdsString;
    }

    public int getKlientIds() {
        return klientIds;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setKoszt(){
        String[] godzRoz = godzina_rozpoczecia.split(":");
        String[] godzZak = godzina_zakonczenia.split(":");

        int rGodz = Integer.parseInt(godzZak[0]) - Integer.parseInt(godzRoz[0]) ;

        this.koszt = 50.0 * rGodz;
    }

    //Atrybut pochodny
    public double getZysk() {
        return koszt - koszt * 0.08;
    }

}
