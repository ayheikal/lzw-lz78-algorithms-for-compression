package GUI.GUI;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javafx.event.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.Label;
import java.awt.*;
import java.util.logging.Handler;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;

public class GridPan extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window=new Stage();
        window.setTitle("GridPane");
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(8);
        gridPane.setVgap(10);
        //name label
        Label nameLabel=new Label("Username: ");
        GridPane.setConstraints(nameLabel,0,0);


        //input
        TextField nameInput=new TextField("Bucky");
        GridPane.setConstraints(nameInput,1,0);

        Label passwordLabel=new Label("Password: ");
        GridPane.setConstraints(passwordLabel,0,1);

        TextField passwordInput=new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput,1,1);

        Button button=new Button("login");
        GridPane.setConstraints(button,1,2);
        button.setOnAction(e->{

        });
        TextArea textArea=new TextArea();
        textArea.setPromptText("text to compress or decompress");
        GridPane.setConstraints(textArea,0,6);

        gridPane.getChildren().addAll(nameLabel,nameInput,passwordLabel,passwordInput,button,textArea);
        Scene scene=new Scene(gridPane,600,400);
        window.setScene(scene);
        window.show();














    }
}
