package diagramClass;

public class Secretary extends ObjectPlusPlus {
    private int rokRozpoczeciaPracy;
    private double pensja;

    public Secretary(int rokRozpoczeciaPracy, double pensja) {
        this.rokRozpoczeciaPracy = rokRozpoczeciaPracy;
        this.pensja = pensja;
    }

    private void ObliczPodwyzke(int rokRozpoczeciaPracy){
        pensja = pensja * rokRozpoczeciaPracy;
    }
}
