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
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LZW extends Application {
    String result;
    private static ObjectOutputStream output;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window=new Stage();
        window.setTitle("LZW comp&decomp by AY GaMaL");
        Button button1=new Button("Compress");
        Button button2=new Button("Decompress");
        Button button3=new Button("Browse->compression");
        Button button4=new Button("Browse->Decompression");
        GridPane.setConstraints(button3,3,1);
        GridPane.setConstraints(button4,3,2);

        //////////////////////////////////////////////////
        GridPane pan=new GridPane();
        pan.setPadding(new Insets(10,10,10,10));
        pan.setHgap(3);
        pan.setVgap(3);
        ////////////////////////////////////////////
        Label l1=new Label("Input...");
        ///////////////////////////////////////////////////////////
        GridPane.setConstraints(l1,0,0);
        TextArea area=new TextArea();
        area.setPromptText("text to compress or decompress");
        GridPane.setConstraints(area,1,0);
        ///////////////////////////////////////////////////////
        Label done=new Label("Wating any Action");
        GridPane.setConstraints(done,3,0);
        Label l2=new Label("The result.....");
        GridPane.setConstraints(l2,0,1);
        //////////////////////////////////////////////////////
        TextArea res=new TextArea();
        res.setPromptText("The result inshallah");
        GridPane.setConstraints(res,1,1);
        /////////////////////////////////////////////////////
        GridPane.setConstraints(button1,2,1);
        GridPane.setConstraints(button2,2,2);



        /**********************************************************************/
        button1.setOnAction(e->{

            String x=area.getText();
            String w=compression(x);
            res.appendText(w);
            done.setText("Compresssed text Done.....");


        });
        /*****************************************************************/
        /********************************************************************/
        button2.setOnAction(e->{

            String x=area.getText();
            String w=Decompress(x);
            res.appendText(w);
            done.setText("Decompresssed text Done.....");



        });
        /*****************************************************************/
        button3.setOnAction(e->
        {


            FileChooser fileChooser=new FileChooser();
            File f = fileChooser.showOpenDialog(window);
            try{

                Scanner scan=new Scanner(f);
                while(scan.hasNextLine()) {
                    String text = scan.nextLine();
                    result = compression(text);
                    createFile(result, "lzwcompress.txt");
                    done.setText("File Is Compressed");
                }
            }
            catch(Exception c){
                showAlertWithDefaultHeaderText();


            }


        });
        /**********************************************************************/
        button4.setOnAction(e->
        {


            FileChooser fileChooser=new FileChooser();
            File f = fileChooser.showOpenDialog(window);
            try{
                Scanner scan=new Scanner(f);
                while(scan.hasNextLine()){
                    String text=scan.nextLine();
                    result=Decompress(text);
                    createFile(result,"lzwDecompression.txt");
                    done.setText("File Is Decompressed");}

            }
            catch(Exception c){
                showAlertWithDefaultHeaderText();


            }

        });
        pan.setStyle("-fx-background-image: url('abu.PNG')");

        pan.getChildren().addAll(l1,area,l2,res,button1,button2,button3,button4,done);
        Scene scene=new Scene(pan,800,400);
        window.setScene(scene);

        window.show();








    }
    /**********************************************************************************/
    public  String compression(String text) {
        ArrayList<String>dic=new ArrayList<String>();
        for(int i=0;i<=127;i++){
            char m=(char) i;
            dic.add(Character.toString(m));
        }

        boolean flag=false;
        String toShow="";
        String p="";
        String c="";
        String PANDc="";
        text+=" ";

        for(int i=0;i<text.length();i++){

            c=text.substring(i,i+1);
            PANDc=p+c;
            if(dic.contains(PANDc)){

                p=PANDc;


            }

            else{

                toShow+=(dic.indexOf(p)+" ");
                dic.add(PANDc);
                p=c;

            }

        }


        return toShow;


    }

    /********************************************************************************/
    public String Decompress(String text) {
        ArrayList<String>dic=new ArrayList<String>();

        for(int i=0;i<=256;i++){
            char m=(char) i;
            dic.add(Character.toString(m));
        }

        /***************************************************/
        String cw="";
        String pw="";
        String p="";
        String c="";
        String[]arr=text.split(" ");

        String toShow="";
        cw=arr[0];
        toShow+=(dic.get(Integer.parseInt(arr[0])));
        for(int i=1;i<arr.length;i++){
            pw=cw;
            cw=arr[i];
            if(dic.contains(dic.get(Integer.parseInt(cw)))){
                toShow+=(dic.get(Integer.parseInt(cw)));
                p=dic.get(Integer.parseInt(pw));
                String aux=dic.get(Integer.parseInt(cw));
                c=aux.substring(0,1);
                dic.add(p+c);

            }
            else{
                p=dic.get(Integer.parseInt(pw));
                c=p.substring(0,1);
                dic.add(p+c);
                toShow+=(p+c);





            }


        }
        return toShow;
    }





    /*****************************************************************************/
    private void showAlertWithDefaultHeaderText() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning alert.error!");

        // alert.setHeaderText("Battery Status:");
        alert.setContentText("Recheck ur Input plz!");

        alert.showAndWait();
    }
    /*****************************************************************************/
    public void createFile(String str,String fileName)
            throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        writer.append(str);
        writer.append('\n');



        writer.close();
    }
}


