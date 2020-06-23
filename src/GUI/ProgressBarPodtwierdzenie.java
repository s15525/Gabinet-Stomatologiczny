package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarPodtwierdzenie extends Thread {
    static double ii = 0;
    final static Float[] values = new Float[]{-1.0f, 0f, 0.6f, 1.0f};
    public static void processBarDisplay() {
        Group root = new Group();
        Stage stage = new Stage();
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Progress Controls");
        ProgressBar pb = new ProgressBar();
        pb.setPrefWidth(500);
        Button button = new Button("Rozpocznij pobieranie");
        Label spacer = new Label();
        Label spacer2 = new Label();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(new WorkerThread(pb));
            }
        });

        HBox hbProgresBar = new HBox();
        hbProgresBar.getChildren().add(pb);
        hbProgresBar.setAlignment(Pos.CENTER);
        HBox hbButtonStart = new HBox();
        hbButtonStart.getChildren().add(button);
        hbButtonStart.setAlignment(Pos.CENTER);
        final VBox vb = new VBox();
        vb.setSpacing(5);
        vb.getChildren().addAll(spacer,hbProgresBar,spacer2,hbButtonStart);
        scene.setRoot(vb);
        stage.show();
    }
    static class WorkerThread extends Thread {
        ProgressBar progressBar;
        public WorkerThread(ProgressBar pb) {
            this.progressBar = pb;
        }

        @Override
        public void run() {
            for (int i = 0; i < values.length ; i++) {
                try {
                    progressBar.setProgress(values[i]);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setProgress(i);
            }
        }
    }
}
