package diagramClass;

public class Zabieg extends ObjectPlus4 {
    int zuzycieMaterialow;
    int zuzycieNarzedzi;
    double czasNaswietlania;

    public Zabieg(int zuzycieMaterialow, int zuzycieNarzedzi, double czasNaswietlania) {
        this.zuzycieMaterialow = zuzycieMaterialow;
        this.zuzycieNarzedzi = zuzycieNarzedzi;
        this.czasNaswietlania = czasNaswietlania;
    }
}
