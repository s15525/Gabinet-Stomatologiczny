package GUI;

import diagramClass.Client;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RegisterClientWindow {
    static boolean klientReturn;

    public static Client display() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Dodaj klienta");
        window.setHeight(500);
        window.setWidth(500);

        Label imieLabel = new Label("Imie");
        TextField imie = new TextField();
        Label nazwiskoLabel = new Label("Nazwisko");
        TextField nazwisko = new TextField();
        Label dataurodzniaLabel = new Label("Data urodzenia w formacie DD-MM-YYYY");
        TextField dataurodzenia = new TextField();
        Label peselLabel = new Label("Pesel");
        TextField pesel = new TextField();
        Label nrtelefonuLabel = new Label("Numer telefonu jesli jest ich wiecej prosze o rozdzielenie ich przecinkiem -> , ");
        TextField nrtelefonu = new TextField();
        Label plecLabel = new Label("Plec");
        ComboBox<String> comboBoxPlec = new ComboBox<>();
        comboBoxPlec.getItems().addAll("Kobieta","Mezczyzna");
        Label informacjeDodatkoweLabel = new Label("Kobieta - Nazwisko panienskie, Mezczyzna - Nazwisko rodowe matki");
        TextField informacjeDodatkowe = new TextField();
        Label spacer = new Label();
        final HBox hb = new HBox();

        Button button = new Button("Zatwierdz");
        Button button1 = new Button("Cofnij");

        button.setOnAction(event -> {
            klientReturn = true;
            window.close();
        });
        button1.setOnAction(event -> {
            klientReturn = false;
            window.close();
        });

        hb.getChildren().addAll(button1, button);
        hb.setAlignment(Pos.CENTER);

        VBox layout = new VBox(5);
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.getChildren().addAll(imieLabel, imie, nazwiskoLabel, nazwisko, dataurodzniaLabel, dataurodzenia,
                peselLabel, pesel, nrtelefonuLabel, nrtelefonu,plecLabel,comboBoxPlec,
                informacjeDodatkoweLabel,informacjeDodatkowe, spacer, hb);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        String[] phoneNumbers = nrtelefonu.getText().split(",");
        List<String> phoneNumberList = new ArrayList<>();
        for (int i = 0; i < phoneNumbers.length; i++) {
            phoneNumberList.add(phoneNumbers[i]);
        }

        if (klientReturn) {
            Client newClient = new Client(imie.getText(), nazwisko.getText(), dataurodzenia.getText(), pesel.getText(), phoneNumberList);
            if (comboBoxPlec.getValue().equals("Mezczyzna")){
                newClient.setMezczyzna(informacjeDodatkowe.getText());
            }else {
                newClient.setKobieta(informacjeDodatkowe.getText());
            }
            return newClient;
        }else {
            return null;
        }
    }
}
