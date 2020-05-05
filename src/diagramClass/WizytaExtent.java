package diagramClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WizytaExtent {
    //atrybut klasowy
    private static String pathToStateExtent = "C:\\Users\\Lukasz Tolpa\\IdeaProjects\\MASEndProject\\new.csv";
    //ekstencja
    private List<Wizyta> extendWizyta = new ArrayList<>();

    public void addWizyta(Wizyta wizyta) {
        extendWizyta.add(wizyta);
    }

    public void removeWizyta(Wizyta wizyta) {
        extendWizyta.add(wizyta);
    }

    public void showWizytaExtent() {
        System.out.println(Wizyta.class.getName());
        extendWizyta.forEach(System.out::println);
    }

    //ekstencja trwalosc
    public void saveState() {
        try {
            FileWriter csvWriter = new FileWriter("new.csv");
            for (Wizyta rowData : extendWizyta) {
                String row = rowData.getId() + "," + rowData.getDzienMiesiaca()+","+rowData.getMiesiac()+","+ rowData.getRok() + "," + rowData.getGodzina_rozpoczecia() + "," + rowData.getGodzina_zakonczenia() + "," + rowData.getKoszt() +","+ rowData.getDyzurIds();
                csvWriter.append(String.join(",", row));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getState() {
        try {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToStateExtent));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                String[] integerStrings = data[7].split(" ");
                int[] integers = new int[integerStrings.length];
                for (int i = 0; i < integers.length; i++) {
                    integers[i] = Integer.parseInt(integerStrings[i]);
                }
                    extendWizyta.add(new Wizyta(Integer.parseInt(data[0]),Integer.parseInt(data[1]), Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],data[5],Double.parseDouble(data[6]),integers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
