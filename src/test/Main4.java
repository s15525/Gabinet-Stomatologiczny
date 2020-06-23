package test;

import diagramClass.*;

import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args){
        //Atrybut
        Gosc kamil = new Gosc("Kamil","Karolak","13.08.1998");
        kamil.setDataOdwiedzin("13.09.2200");
        System.out.println(kamil);
        kamil.setDataOdwiedzin("13.09.2019");
        System.out.println(kamil);
        System.out.println();
        //unique
        Klient marek = new Klient("Marek", "Pawlowski", "23.09.1997", "987997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        Klient kacper = new Klient("Kacper", "Pawlowski", "23.08.1997", "997997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        //Klient nie zostanie dodany do extencji poniewaz ma taki sam pesel jak nr 1
        Klient pawel = new Klient("Pawel", "Pawlowski", "23.10.1997", "987997979797", new ArrayList<>() {{
            add("7878878787");
        }});
        pawel.showKlientExtent();
        System.out.println();
        //Subset
        Stomatolog ewa = new Stomatolog(1,"Rower",new ArrayList<>(),30000.0,new int[]{});
        Dyzur pierwszy = new Dyzur(1,"13.09.1997",12,12,new int[]{},new int[]{});
        String roleStomatolog = "StomatologRola";
        String roleDyzur = "DyzurRola";
        String rolaWSubset = "Zarzadca zmiana";
        try {
            ewa.addLink(roleDyzur,roleStomatolog,pierwszy);
            ewa.addLink_subset(rolaWSubset,roleStomatolog,roleDyzur,pierwszy);

            ewa.showLinks(roleDyzur,System.out);
            ewa.showLinks(rolaWSubset,System.out);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Ordered

    }
}
