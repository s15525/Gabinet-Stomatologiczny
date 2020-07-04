package diagramClass;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KlientExtent {
    private List<Klient> extentKlient = new ArrayList<>();

    public void addKlient(Klient klient) {
        extentKlient.add(klient);
    }

    public void removeKlient(Klient klient) {
        extentKlient.add(klient);
    }

    public void showKlientExtent() {
        System.out.println(Wizyta.class.getName());
        extentKlient.forEach(System.out::println);
    }

    public List<Klient> getExtentKlient() {
        return extentKlient;
    }

    //ekstencja trwalosc
    public void saveState() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");

            for (Klient klient :
                    extentKlient) {
                // the mysql insert statement
                String query = " insert into Klient (`imie`, `nazwisko`, `dataUrodzenia`,`pesel`,`nrTelefonu`,`plec`,`informacjaDodatkowa`)"
                        + " values (?, ?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, klient.getImie());
                preparedStmt.setString(2, klient.getNazwisko());
                preparedStmt.setString(3, klient.getDataurodzenia());
                preparedStmt.setString(4, klient.getPesel());
                preparedStmt.setString(5, klient.getNumeryTelefonu());
                preparedStmt.setString(6, klient.getPlecKto());
                preparedStmt.setString(7, klient.getInformacjaDodatkowa());

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

            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");
            // the mysql insert statement
            String query = " SELECT `imie`, `nazwisko`, `dataUrodzenia`,`pesel`,`nrTelefonu`,`plec`,`informacjaDodatkowa` FROM Klient";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                String imie = rs.getString(1);
                String nazwisko = rs.getString(2);
                String dataUrodzenia = rs.getString(3);
                String pesel = rs.getString(4);
                String nrTelefonu = rs.getString(5);
                String plec = rs.getString(6);
                String informacjaDodatkowa = rs.getString(7);

                String[] tab = nrTelefonu.split("\n");

                Klient klient = new Klient(imie,nazwisko,dataUrodzenia,pesel,new ArrayList<>(Arrays.asList(tab)));

                if (plec.equals("kobieta")){
                    klient.setKobieta(informacjaDodatkowa);
                }else{
                    klient.setMezczyzna(informacjaDodatkowa);
                }

                extentKlient.add(klient);
            }
            // execute the preparedstatement


            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public int getIdKlient(String imie,String nazwisko){
        int idKlient = -1;

        try {

            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");
            // the mysql insert statement
            String query = " SELECT `IdKlient` FROM Klient WHERE `imie` = '" + imie +"' AND `nazwisko` = '"+nazwisko +"'";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                idKlient = rs.getInt(1);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return idKlient;
    }
}
