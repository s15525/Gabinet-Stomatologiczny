package diagramClass;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientExtent {
    private List<Client> extentClient = new ArrayList<>();

    public void addKlient(Client client) {
        extentClient.add(client);
    }

    public void removeKlient(Client client) {
        extentClient.add(client);
    }

    public void showKlientExtent() {
        System.out.println(Visit.class.getName());
        extentClient.forEach(System.out::println);
    }

    public List<Client> getExtentClient() {
        return extentClient;
    }

    //ekstencja trwalosc
    public void saveState() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");

            for (Client client :
                    extentClient) {
                // the mysql insert statement
                String query = " insert into Klient (`imie`, `nazwisko`, `dataUrodzenia`,`pesel`,`nrTelefonu`,`plec`,`informacjaDodatkowa`)"
                        + " values (?, ?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, client.getImie());
                preparedStmt.setString(2, client.getNazwisko());
                preparedStmt.setString(3, client.getDataurodzenia());
                preparedStmt.setString(4, client.getPesel());
                preparedStmt.setString(5, client.getNumeryTelefonu());
                preparedStmt.setString(6, client.getPlecKto());
                preparedStmt.setString(7, client.getInformacjaDodatkowa());

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

                Client client = new Client(imie,nazwisko,dataUrodzenia,pesel,new ArrayList<>(Arrays.asList(tab)));

                if (plec.equals("kobieta")){
                    client.setKobieta(informacjaDodatkowa);
                }else{
                    client.setMezczyzna(informacjaDodatkowa);
                }

                extentClient.add(client);
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
