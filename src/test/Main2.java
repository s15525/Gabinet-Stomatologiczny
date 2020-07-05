package test;
import diagramClass.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        //Asocjacja binarna diagramClass.Wizyta-dyzur
        Visit visit = new Visit(06, 04, 2020, "08:30", "19:00", 20.00, new int[]{1},1);
        Duty duty = new Duty(1,"18.08.19",60,3,new int[]{1},new int[]{1});
        //Asocjacja z parametrem diagramClass.Dyzur-diagramClass.Stomatolog
        DutyDentist dutyDentist = new DutyDentist(1,1,200);
        Dentist dentist = new Dentist(1,"Multisport", new ArrayList<String>() {{
            add("Stomatologia ogolna");
        }}, 300.0,new int[]{1});

        visit.setKoszt();

        System.out.println("Koszt wizyty" + visit.getKoszt());
        //Asocjacja kwalfikowana

        //Kompozycja
        Client adam = new Client("Marek","Piekarczuk","13.08.1997","972394234324",new ArrayList<>(){{add("787888787");}});
        adam.createZab("Dobry",2,"Dobry","czarny");
    }
}
