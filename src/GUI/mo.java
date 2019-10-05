package GUI;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.Label;
import java.awt.*;
import java.util.logging.Handler;
public class mo extends Application {
    Button button1;
    Stage window;
    Scene scene;
    boolean result;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=new Stage();
        window.setTitle("NUmber1");
        button1=new Button("click on me");
        button1.setOnAction(e->{

           result=ConfirmBox.display("HUDA PHARMACY","Allah Will recover u ");
            System.out.println(result);

        });
       String x=(result==true?"yes":"No");
        Label label=new Label(x);
        StackPane layout=new StackPane();
        layout.getChildren().addAll(label,button1);
        scene=new Scene(layout,600,400);
        window.setScene(scene);
        window.show();



    }
}
