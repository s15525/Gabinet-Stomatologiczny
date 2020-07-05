package diagramClass;

public class Assistant extends ObjectPlusPlus {
    private String kwalfikacje;

    public Assistant(String kwalfikacje) {
        this.kwalfikacje = kwalfikacje;
    }

    @Override
    public String toString() {
        return "Asystent{" +
                "kwalfikacje='" + kwalfikacje + '\'' +
                '}';
    }
}
