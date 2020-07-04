package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PeselCheckWindow {
     static boolean result;
    public static boolean peselCheckDisplay() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert");
        window.setHeight(200);
        window.setWidth(450);

        Label label = new Label("Weryfikacja uprawnien swiadczeniobiorcy prosze podac pesel ");
        Label spacer = new Label();
        TextField pesel = new TextField();
        Label spacer2 = new Label();
        Button button = new Button("Ok");


        button.setOnAction(event -> {
            result = peselById(pesel.getText());
            window.close();
        });
        VBox vBox = new VBox();
        final HBox hblabel = new HBox();
        final HBox hbPesel = new HBox();
        final HBox hbbutton = new HBox();
        hbbutton.getChildren().add(button);
        hbbutton.setAlignment(Pos.CENTER);
        hbPesel.getChildren().add(pesel);
        hbPesel.setAlignment(Pos.CENTER);
        hblabel.getChildren().add(label);
        hblabel.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hblabel, spacer, hbPesel, spacer2, hbbutton);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
        return result;
    }

    public static boolean peselById(String pesel) {
        int peselDb = 0;
        try {
            // create a mysql database connection
//            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/stomatolog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "Admin123@");
            // the mysql insert statement
            String query = " SELECT `pesel` FROM ewus WHERE `pesel`=" + pesel;

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();

            while (rs.next()) {
                peselDb = rs.getInt(1);
            }
            // execute the preparedstatement


            conn.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        if (peselDb == 0) {
            return false;
        } else {
            return true;
        }
    }

}
