package GUI;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.Label;
import java.awt.*;
import java.util.logging.Handler;
public class ConfirmBox {
    static boolean answer;

    public static boolean display(String title, String message) {

        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        ///////////////////////////////////////////////////////
        Button yesButton=new Button("Yes");
        Button noButton=new Button("No");
        yesButton.setOnAction(e->{
            answer=true;
            window.close();
        });
        noButton.setOnAction(e->{
            answer=false;
            window.close();
        });



        Label label = new Label(message);
        VBox layout = new VBox(20);

        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,400,200);
        window.setScene(scene);
        window.showAndWait();
        return answer;

    }
}













