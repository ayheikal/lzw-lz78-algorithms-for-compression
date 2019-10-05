package GUI.GUI;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
import java.awt.*;

public class mom extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=new Stage();
        window.setTitle("MOM");
        HBox topMenu=new HBox(15);
        Button button2=new Button("file");
        Button button3=new Button("edit");
        Button button1=new Button("save");
        topMenu.getChildren().addAll(button3,button2,button1);

        VBox leftMenu=new VBox(15);
        Button buttonA=new Button("A");
        Button buttonB=new Button("B");
        Button buttonC=new Button("C");
        leftMenu.getChildren().addAll(buttonC,buttonA,buttonB);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);


        Scene scene=new Scene(borderPane,300,200);
        window.setScene(scene);
        window.show();




    }
}
