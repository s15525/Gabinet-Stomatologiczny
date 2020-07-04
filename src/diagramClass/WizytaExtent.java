package diagramClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WizytaExtent {
    //atrybut klasowy
//    private static String pathToStateExtent = "C:\\Users\\Lukasz Tolpa\\IdeaProjects\\MASEndProject\\new.csv";

    //ekstencja
    private List<Wizyta> extentWizyta = new ArrayList<>();

    public void addWizyta(Wizyta wizyta) {
        extentWizyta.add(wizyta);
    }

    public void removeWizyta(Wizyta wizyta) {
        extentWizyta.add(wizyta);
    }

    public void showWizytaExtent() {
        System.out.println(Wizyta.class.getName());
        extentWizyta.forEach(System.out::println);
    }

    //ekstencja trwalosc
    public void saveState() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");

            for (Wizyta wizyta :
                    extentWizyta) {
                // the mysql insert statement
                String query = " insert into Wizyta (`date`, `godzina_rozpoczecia`, " +
                        "`godzina_zakonczenia`, `koszt`, `IdDyzury`,`IdKlient`)"
                        + " values (?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, wizyta.getDataWizyty());
                preparedStmt.setString(2, wizyta.getGodzina_rozpoczecia());
                preparedStmt.setString(3, wizyta.getGodzina_zakonczenia());
                preparedStmt.setDouble(4, wizyta.getKoszt());
                preparedStmt.setString(5, "");
                preparedStmt.setInt(6, wizyta.getKlientIds());

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
               extentWizyta.add(new Wizyta(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]),
                       Integer.parseInt(tab[2]),godzina_rozpoczecia,godzina_zakonczenia,koszt,new int[]{},idKlient));
            }
            // execute the preparedstatement


            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e);
        }
    }

    public Wizyta findWizytyKlient(int id) throws Exception {
        for(Wizyta wizyta : extentWizyta) {
            if(wizyta.klientIds == id) {
                return wizyta;
            }
        }
        throw new Exception("Unable to find a Wizyta with the id = " + id);
    }
}
