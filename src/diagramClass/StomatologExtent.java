package diagramClass;

import java.util.ArrayList;
import java.util.List;

public class StomatologExtent {
    private List<Stomatolog> extendStomatolog = new ArrayList<>();

    public void addStomatolog(Stomatolog stomatolog) {
        extendStomatolog.add(stomatolog);
    }

    public void removeStomatolog(Stomatolog stomatolog) {
        extendStomatolog.add(stomatolog);
    }

    public void showStomatologExtent() {
        System.out.println(Stomatolog.class.getName());
        extendStomatolog.forEach(System.out::println);
    }

    public double ObliczPensje(){
        return extendStomatolog.stream().mapToDouble(Stomatolog::getPensja).sum();
    }

}
