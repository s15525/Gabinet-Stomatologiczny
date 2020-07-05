package GUI;

import diagramClass.Visit;
import diagramClass.VisitExtent;
import javafx.geometry.Insets;
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

import java.util.Calendar;

public class SignAtVisitWindow {
    public static void displaySingAtWizyta(int idKlient){
        VisitExtent visitExtent = new VisitExtent();
        Calendar cal = Calendar.getInstance();

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Rejestrowanie na wizyte");
        window.setHeight(200);
        window.setWidth(620);

        Label dzienLabel = new Label("Dzien :");
        Label spacer1 = new Label();
        Label miesiacLabel = new Label("Miesiac :");
        Label godzinaRozpoczeciaLabel = new Label("Godzina rozpoczecia w formacie HH:MM :");
        Label godzinaZakonczeniaLabel = new Label("Godzina zakonczenia w formacie HH:MM :");
        Button add = new Button("Zatwierdz");
        Button cancel = new Button("Anuluj");
        ComboBox<Integer> dzienCombobox = new ComboBox<>();
        ComboBox<Integer> miesiacCombobox = new ComboBox<>();
        miesiacCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        dzienCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13
                ,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
        TextField godzinaRozpoczecia = new TextField();
        TextField godzinaZakonczenia = new TextField();
        godzinaRozpoczecia.setMaxWidth(50);
        godzinaZakonczenia.setMaxWidth(50);


        add.setOnAction(event ->{
            Visit newVisit = new Visit(dzienCombobox.getItems().get(dzienCombobox.getSelectionModel().getSelectedIndex())
                    ,miesiacCombobox.getItems().get(miesiacCombobox.getSelectionModel().getSelectedIndex()),
                    cal.get(Calendar.YEAR),godzinaRozpoczecia.getText(),godzinaZakonczenia.getText(),
                    0,new int[]{},idKlient);
            newVisit.setKoszt();
            visitExtent.addWizyta(newVisit);
            visitExtent.saveState();
            window.close();});
        cancel.setOnAction(event -> window.close());

        VBox vBox = new VBox();
        final HBox hbgodzinaRozpoczeciaZakonczenia = new HBox();
        final HBox hbComboBoxData = new HBox();
        final HBox hbbutton = new HBox();
        hbbutton.getChildren().addAll(cancel,add);
        hbbutton.setAlignment(Pos.CENTER);
        hbbutton.setSpacing(10);
        hbgodzinaRozpoczeciaZakonczenia.getChildren().addAll(godzinaRozpoczeciaLabel,godzinaRozpoczecia,godzinaZakonczeniaLabel,godzinaZakonczenia);
        hbgodzinaRozpoczeciaZakonczenia.setSpacing(10);
        hbgodzinaRozpoczeciaZakonczenia.setAlignment(Pos.CENTER);
        hbgodzinaRozpoczeciaZakonczenia.setPadding(new Insets(5, 12, 15, 12));
        hbComboBoxData.getChildren().addAll(dzienLabel,dzienCombobox,miesiacLabel,miesiacCombobox);
        hbComboBoxData.setPadding(new Insets(15, 12, 15, 12));
        hbComboBoxData.setSpacing(10);
        hbComboBoxData.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hbComboBoxData,spacer1,hbgodzinaRozpoczeciaZakonczenia,hbbutton);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }
}
