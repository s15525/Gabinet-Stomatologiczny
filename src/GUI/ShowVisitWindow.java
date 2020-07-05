package GUI;

import diagramClass.Visit;
import diagramClass.VisitExtent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowVisitWindow {

    public static void showWizytaDisplay( int idKlienta) throws Exception {
        VisitExtent visitExtent = new VisitExtent();
        visitExtent.getState();
        Visit visit = visitExtent.findWizytyKlient(idKlienta);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wizyta klienta");
        window.setHeight(220);
        window.setWidth(500);

        Label data = new Label("Data wizyty");
        Label valueData = new Label();
        valueData.setText(visit.getDataWizyty());
        Label godzinaRozpoczecia = new Label("Godzina Rozpoczecia");
        Label valueGodzinaRozpoczecia = new Label();
        valueGodzinaRozpoczecia.setText(visit.getGodzina_rozpoczecia());
        Label godzinaZakonczenia = new Label("Godzina Zakonczenia");
        Label valueGodzinaZakonczenia = new Label();
        valueGodzinaZakonczenia.setText(visit.getGodzina_zakonczenia());
        Label kwota = new Label("Kwota");
        Label valueKwota = new Label();
        valueKwota.setText(String.valueOf(visit.getKoszt()));
        Button button = new Button("Ok");


        button.setOnAction(event -> window.close());
        VBox vBox = new VBox();
        final HBox hbDataLabel = new HBox();
        final HBox hbGRLabel = new HBox();
        final HBox hbGZLabel = new HBox();
        final HBox hbKwotaLabel = new HBox();
        final HBox hbbutton = new HBox();
        hbbutton.getChildren().add(button);
        hbDataLabel.getChildren().addAll(data,valueData);
        hbGRLabel.getChildren().addAll(godzinaRozpoczecia,valueGodzinaRozpoczecia);
        hbGZLabel.getChildren().addAll(godzinaZakonczenia,valueGodzinaZakonczenia);
        hbKwotaLabel.getChildren().addAll(kwota,valueKwota);
        setPos(hbDataLabel);
        setPos(hbGRLabel);
        setPos(hbGZLabel);
        setPos(hbKwotaLabel);
        setPos(hbbutton);


        vBox.getChildren().addAll(hbDataLabel,hbGRLabel,hbGZLabel,hbKwotaLabel,hbbutton);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }

    private static void setPos(HBox hBox){
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        hBox.setPadding(new Insets(5, 12, 15, 12));
    }
}
