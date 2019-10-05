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

public class FirstApplication extends Application {
    Button button,button2;
    Stage window;
    Scene scene1,scene2;

    public static void main(String []args)
    {
        launch(args);

    }
   @Override
    public void start(Stage primaryStage)throws Exception{
        window=primaryStage;
        Label label1=new Label("MO_SALAH TREAJAKAKAOAJ sjsi jdhdokdn joieje");
        button=new Button("2 next scene");
        button.setOnAction(e->window.setScene(scene2));
        //layout1
       VBox layout1=new VBox(30);
       layout1.getChildren().addAll(label1,button);

       scene1=new Scene(layout1,600,400);
       //button2
       button2=new Button("go back to scen1");
       button2.setOnAction(e->window.setScene(scene1));
       Label label2=new Label("Another scene lalalalalala");
       StackPane layout2=new StackPane();
       layout2.getChildren().addAll(label2,button2);
       scene2 =new Scene(layout2,600,350);
       window.setScene(scene1);
       window.setTitle("AY GaMaL");
       window.show();
















    }


}
