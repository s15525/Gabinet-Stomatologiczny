package diagramClass;

public class Sekretarka extends ObjectPlusPlus {
    private int rokRozpoczeciaPracy;
    private double pensja;

    public Sekretarka(int rokRozpoczeciaPracy, double pensja) {
        this.rokRozpoczeciaPracy = rokRozpoczeciaPracy;
        this.pensja = pensja;
    }

    private void ObliczPodwyzke(int rokRozpoczeciaPracy){
        pensja = pensja * rokRozpoczeciaPracy;
    }
}
