package diagramClass;

public class Asystent extends ObjectPlusPlus {
    private String kwalfikacje;

    public Asystent( String kwalfikacje) {
        this.kwalfikacje = kwalfikacje;
    }

    @Override
    public String toString() {
        return "Asystent{" +
                "kwalfikacje='" + kwalfikacje + '\'' +
                '}';
    }
}
