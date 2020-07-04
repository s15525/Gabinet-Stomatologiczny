package GUI;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {

    public static void alertDisplay(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert");
        window.setHeight(100);
        window.setWidth(350);

        Label label = new Label(message);
        Label spacer = new Label();
        Button button = new Button("Ok");


        button.setOnAction(event -> window.close());
        VBox vBox = new VBox();
        final HBox hblabel = new HBox();
        final HBox hbbutton = new HBox();
        hbbutton.getChildren().add(button);
        hbbutton.setAlignment(Pos.CENTER);
        hblabel.getChildren().add(label);
        hblabel.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hblabel,spacer,hbbutton);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
    }

}
