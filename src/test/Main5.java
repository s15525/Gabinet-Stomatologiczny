package test;

import diagramClass.Narzedzia;
import diagramClass.SprzetMedyczny;
import diagramClass.Zabieg;

public class Main5 {
    public static void main(String[] args) {
        //XOR
        Zabieg zabieg1 = new Zabieg(12, 12, 32);
        Narzedzia lusterko = new Narzedzia("Lusterko", 12.00, 21.00);
        SprzetMedyczny okstenident = new SprzetMedyczny("Plyn do plukania",2);

        zabieg1.addAndRole("LusterkoRola");
        zabieg1.addAndRole("SprzetRola");

        zabieg1.addLinkAnd("ZabiegRola","NarzedzieRola",lusterko);
        zabieg1.addLinkAnd("ZabiegRola","SprzetRola",okstenident);

        try {
            zabieg1.showLinks("ZabiegRola",System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
