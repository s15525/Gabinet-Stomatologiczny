package GUI;

import diagramClass.Klient;
import diagramClass.KlientExtent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {
    private TableView<KlientTable> klientTableView = new TableView<KlientTable>();
    private Button wyswietlWizyty = new Button("Wyswietl szczegóły wizyty");
    private final ObservableList<KlientTable> data = FXCollections.observableArrayList();
    private final HBox hb = new HBox();
    private KlientExtent klientExtentExist = new KlientExtent();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        ScrollPane scrollPane = new ScrollPane();
        primaryStage.setTitle("Osoba");
        primaryStage.setWidth(770);
        primaryStage.setHeight(500);
        final Label label = new Label("Lista klientow");

        klientTableView.setEditable(true);


        TableColumn imie = new TableColumn("imie");
        imie.setMinWidth(150);
        imie.setCellValueFactory(new PropertyValueFactory<KlientTable, String>("imie"));

        TableColumn nazwisko = new TableColumn("nazwisko");
        nazwisko.setMinWidth(150);
        nazwisko.setCellValueFactory(new PropertyValueFactory<KlientTable, String>("nazwisko"));

        TableColumn dataUrodzenia = new TableColumn("dataurodzenia");
        dataUrodzenia.setMinWidth(150);
        dataUrodzenia.setCellValueFactory(new PropertyValueFactory<KlientTable, String>("dataurodzenia"));

        TableColumn pesel  = new TableColumn("pesel");
        pesel.setMinWidth(150);
        pesel.setCellValueFactory(new PropertyValueFactory<KlientTable, String>("pesel"));

        TableColumn nrtelefonu  = new TableColumn("numerTelefonu");
        nrtelefonu.setMinWidth(150);
        nrtelefonu.setCellValueFactory(new PropertyValueFactory<KlientTable, String>("numertelefonu"));


        klientExtentExist.getState();

        for (Klient k:
             klientExtentExist.getExtentKlient()) {
            data.add(new KlientTable(k.getImie(),k.getNazwisko(),k.getDataurodzenia(),k.getPesel(),k.getNumeryTelefonu()));
        }


        klientTableView.setItems(data);
        klientTableView.getColumns().addAll(imie, nazwisko, dataUrodzenia,pesel,nrtelefonu);

        scrollPane.setContent(klientTableView);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setFitToHeight(true);
        scrollPane.setHmax(3);
        scrollPane.setHvalue(0);

        final Button addKlientButton = new Button("Dodaj klienta");

        addKlientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Klient newKlient = RegisterClientWindow.display();
                if (newKlient != null) {
                    KlientExtent klientExtentNew = new KlientExtent();
                    klientExtentNew.addKlient(newKlient);
                    klientExtentNew.saveState();
                    KlientTable klientTable = new KlientTable(newKlient.getImie(), newKlient.getNazwisko(), newKlient.getDataurodzenia(), newKlient.getPesel(), newKlient.getNumeryTelefonu());
                    data.add(klientTable);
                    if (PeselCheckWindow.peselCheckDisplay()){
                        ProgressBarPodtwierdzenie.processBarDisplay();
                        SignAtWizytaWindow.displaySingAtWizyta(klientExtentNew.getIdKlient(newKlient.getImie(),newKlient.getNazwisko()));
                    }else {
                        Alert.alertDisplay("Uwaga pacjent nie posiada ubezpieczenia zdrowotnego");
                        SignAtWizytaWindow.displaySingAtWizyta(klientExtentNew.getIdKlient(newKlient.getImie(),newKlient.getNazwisko()));
                    }
                }
            }

        });

        wyswietlWizyty.setOnAction(event -> {
            klientExtentExist.getState();
            try {
                KlientTable klientTable = klientTableView.getItems().get(klientTableView.getSelectionModel().getFocusedIndex());
                ShowWizytaWindow.showWizytaDisplay(klientExtentExist.getIdKlient(klientTable.getImie(),klientTable.getNazwisko()));
            } catch (Exception e) {
               Alert.alertDisplay("Klient nie jest zapisany na zadana wizyte");
            }
        });

        hb.getChildren().addAll(wyswietlWizyty,addKlientButton);
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setSpacing(20);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, klientTableView, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
