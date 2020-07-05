package diagramClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VisitExtent {
    //atrybut klasowy
//    private static String pathToStateExtent = "C:\\Users\\Lukasz Tolpa\\IdeaProjects\\MASEndProject\\new.csv";

    //ekstencja
    private List<Visit> extentVisit = new ArrayList<>();

    public void addWizyta(Visit visit) {
        extentVisit.add(visit);
    }

    public void removeWizyta(Visit visit) {
        extentVisit.add(visit);
    }

    public void showWizytaExtent() {
        System.out.println(Visit.class.getName());
        extentVisit.forEach(System.out::println);
    }

    //ekstencja trwalosc
    public void saveState() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");

            for (Visit visit :
                    extentVisit) {
                // the mysql insert statement
                String query = " insert into Wizyta (`date`, `godzina_rozpoczecia`, " +
                        "`godzina_zakonczenia`, `koszt`, `IdDyzury`,`IdKlient`)"
                        + " values (?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, visit.getDataWizyty());
                preparedStmt.setString(2, visit.getGodzina_rozpoczecia());
                preparedStmt.setString(3, visit.getGodzina_zakonczenia());
                preparedStmt.setDouble(4, visit.getKoszt());
                preparedStmt.setString(5, "");
                preparedStmt.setInt(6, visit.getKlientIds());

                // execute the preparedstatement
                preparedStmt.execute();
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
        }
    }

    public void getState() {
        try {
            // create a mysql database connection
//            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");
            // the mysql insert statement
            String query = " SELECT `date`,`godzina_rozpoczecia`,`godzina_zakonczenia`,`koszt`,`IdKlient` FROM WIZYTA";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {

               String data = rs.getString(1);
               String godzina_rozpoczecia = rs.getString(2);
               String godzina_zakonczenia = rs.getString(3);
               double koszt = rs.getDouble(4);
               int idKlient = rs.getInt(5);
               String[] tab = data.split("\\.");
               extentVisit.add(new Visit(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]),
                       Integer.parseInt(tab[2]),godzina_rozpoczecia,godzina_zakonczenia,koszt,new int[]{},idKlient));
            }
            // execute the preparedstatement


            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
        }
    }

    public Visit findWizytyKlient(int id) throws Exception {
        for(Visit visit : extentVisit) {
            if(visit.klientIds == id) {
                return visit;
            }
        }
        throw new Exception("Unable to find a Wizyta with the id = " + id);
    }
}
