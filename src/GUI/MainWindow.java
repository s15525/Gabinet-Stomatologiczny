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
    private TableView<KlientTable> osobaTableView = new TableView<KlientTable>();
    private Button wyswietlWizyty = new Button("Wyswietl wizyty");
    private final ObservableList<KlientTable> data =
            FXCollections.observableArrayList(
//                    new KlientTable("Norbert","Gierczak","18-18-2424","255235325325235","2421525252")
                    //new Klient("Norbert","Gierczak", "23.08.1997", "977997979797", new ArrayList<>() {{
                    //            add("7878878787");
                    //            }});
            );
    private final HBox hb = new HBox();
    private KlientExtent klientExtentExist = new KlientExtent();
    private KlientExtent klientExtentNew = new KlientExtent();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        klientExtentNew.saveState();
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        ScrollPane scrollPane = new ScrollPane();
        primaryStage.setTitle("Osoba");
        primaryStage.setWidth(770);
        primaryStage.setHeight(500);
        final Label label = new Label("Lista klientow");

        osobaTableView.setEditable(true);


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


        osobaTableView.setItems(data);
        osobaTableView.getColumns().addAll(imie, nazwisko, dataUrodzenia,pesel,nrtelefonu);

        scrollPane.setContent(osobaTableView);
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
                klientExtentNew.addKlient(newKlient);
                if (newKlient != null) {
                    KlientTable klientTable = new KlientTable(newKlient.getImie(), newKlient.getNazwisko(), newKlient.getDataurodzenia(), newKlient.getPesel(), newKlient.getNumeryTelefonu());
                    data.add(klientTable);
                }
            }
        });

        wyswietlWizyty.setOnAction(event -> ProgressBarPodtwierdzenie.processBarDisplay());

        hb.getChildren().addAll(wyswietlWizyty,addKlientButton);
        hb.setAlignment(Pos.CENTER_RIGHT);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(label, osobaTableView, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
