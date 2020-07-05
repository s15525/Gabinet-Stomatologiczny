package GUI;

import diagramClass.Client;
import diagramClass.ClientExtent;
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
    private TableView<ClientTable> klientTableView = new TableView<ClientTable>();
    private Button wyswietlWizyty = new Button("Wyswietl szczegóły wizyty");
    private final ObservableList<ClientTable> data = FXCollections.observableArrayList();
    private final HBox hb = new HBox();
    private ClientExtent clientExtentExist = new ClientExtent();

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
        imie.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("imie"));

        TableColumn nazwisko = new TableColumn("nazwisko");
        nazwisko.setMinWidth(150);
        nazwisko.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("nazwisko"));

        TableColumn dataUrodzenia = new TableColumn("dataurodzenia");
        dataUrodzenia.setMinWidth(150);
        dataUrodzenia.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("dataurodzenia"));

        TableColumn pesel  = new TableColumn("pesel");
        pesel.setMinWidth(150);
        pesel.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("pesel"));

        TableColumn nrtelefonu  = new TableColumn("numerTelefonu");
        nrtelefonu.setMinWidth(150);
        nrtelefonu.setCellValueFactory(new PropertyValueFactory<ClientTable, String>("numertelefonu"));


        clientExtentExist.getState();

        for (Client k:
             clientExtentExist.getExtentClient()) {
            data.add(new ClientTable(k.getImie(),k.getNazwisko(),k.getDataurodzenia(),k.getPesel(),k.getNumeryTelefonu()));
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
                Client newClient = RegisterClientWindow.display();
                if (newClient != null) {
                    ClientExtent clientExtentNew = new ClientExtent();
                    clientExtentNew.addKlient(newClient);
                    clientExtentNew.saveState();
                    ClientTable clientTable = new ClientTable(newClient.getImie(), newClient.getNazwisko(), newClient.getDataurodzenia(), newClient.getPesel(), newClient.getNumeryTelefonu());
                    data.add(clientTable);
                    if (PeselCheckWindow.peselCheckDisplay()){
                        ProgressBarPodtwierdzenie.processBarDisplay();
                        SignAtVisitWindow.displaySingAtWizyta(clientExtentNew.getIdKlient(newClient.getImie(), newClient.getNazwisko()));
                    }else {
                        Alert.alertDisplay("Uwaga pacjent nie posiada ubezpieczenia zdrowotnego");
                        SignAtVisitWindow.displaySingAtWizyta(clientExtentNew.getIdKlient(newClient.getImie(), newClient.getNazwisko()));
                    }
                }
            }

        });

        wyswietlWizyty.setOnAction(event -> {
            clientExtentExist.getState();
            try {
                ClientTable clientTable = klientTableView.getItems().get(klientTableView.getSelectionModel().getFocusedIndex());
                ShowVisitWindow.showWizytaDisplay(clientExtentExist.getIdKlient(clientTable.getImie(), clientTable.getNazwisko()));
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
