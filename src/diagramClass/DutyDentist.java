package diagramClass;

public class DutyDentist {
    private int id;
    private int idStomatolog;
    private int idDyzur;
    private int wynagrodzenieZaWizyte;

    public DutyDentist(int idStomatolog, int idDyzur, int wynagrodzenieZaWizyte) {
        this.idStomatolog = idStomatolog;
        this.idDyzur = idDyzur;
        this.wynagrodzenieZaWizyte = wynagrodzenieZaWizyte;
    }

}
