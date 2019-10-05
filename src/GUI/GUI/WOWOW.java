package GUI.GUI;
import GUI.ConfirmBox;
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

import javafx.application.Application;
import javafx.stage.Stage;

public class WOWOW extends Application {
    Stage window;
    Button button;
    Scene scene;
    public static void main(String[]args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {

        window=primaryStage ;
        window.setTitle("window title");
        window.setOnCloseRequest(e->{
            e.consume();
            closeProgeram();
        });
        button=new Button("close window");
        button.setOnAction(e->closeProgeram());
        StackPane layout=new StackPane();
        layout.getChildren().addAll(button);
        scene=new Scene(layout,400,300);
        window.setScene(scene);
        window.show();

    }
    private void closeProgeram(){
        boolean answer=ConfirmBox.display("ti","Sure u want to exit?");
        if(answer)
            window.close();

    }
}
