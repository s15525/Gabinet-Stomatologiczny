package test;

import diagramClass.Tools;
import diagramClass.MedicalEquipment;
import diagramClass.Intervention;

public class Main5 {
    public static void main(String[] args) {
        //XOR
        Intervention intervention1 = new Intervention(12, 12, 32);
        Tools lusterko = new Tools("Lusterko", 12.00, 21.00);
        MedicalEquipment okstenident = new MedicalEquipment("Plyn do plukania",2);

        intervention1.addAndRole("LusterkoRola");
        intervention1.addAndRole("SprzetRola");

        intervention1.addLinkAnd("ZabiegRola","NarzedzieRola",lusterko);
        intervention1.addLinkAnd("ZabiegRola","SprzetRola",okstenident);

        try {
            intervention1.showLinks("ZabiegRola",System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
