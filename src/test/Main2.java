package test;
import diagramClass.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        //Asocjacja binarna diagramClass.Wizyta-dyzur
        Wizyta wizyta = new Wizyta(1,06, 04, 2020, "08:30", "19:00", 20.00, new int[]{1});
        Dyzur dyzur = new Dyzur(1,"18.08.19",60,3,new int[]{1},new int[]{1});
        //Asocjacja z parametrem diagramClass.Dyzur-diagramClass.Stomatolog
        DyzurStomatolog dyzurStomatolog = new DyzurStomatolog(1,1,200);
        Stomatolog stomatolog = new Stomatolog(1,"Multisport", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 300.0,new int[]{1});

        //Asocjacja kwalfikowana

        //Kompozycja
        Klient adam = new Klient("13.08.1997","972394234324",new ArrayList<>(){{add("787888787");}});
        adam.createZab("Dobry",2,"Dobry","czarny");
    }
}
