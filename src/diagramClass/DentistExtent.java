package diagramClass;

import java.util.ArrayList;
import java.util.List;

public class DentistExtent {
    private List<Dentist> extendDentist = new ArrayList<>();

    public void addStomatolog(Dentist dentist) {
        extendDentist.add(dentist);
    }

    public void removeStomatolog(Dentist dentist) {
        extendDentist.add(dentist);
    }

    public void showStomatologExtent() {
        System.out.println(Dentist.class.getName());
        extendDentist.forEach(System.out::println);
    }

    public double ObliczPensje(){
        return extendDentist.stream().mapToDouble(Dentist::getPensja).sum();
    }

}
