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

public class LZ78 extends Application {
    public String aux="";
    String mo_salah="";
    String result;
    private static ObjectOutputStream output;
    ArrayList<String>list=new ArrayList<String>();
    int pointer=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window=new Stage();
        window.setTitle("LZ78 comp&decomp by AY GaMaL");
        Button button1=new Button(" Compress ");
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
            list.add("\0");
            String x=area.getText();
            String w=compression(x,res);
            res.appendText(w);
            done.setText("Compresssed text Done.....");


        });
        /*****************************************************************/
        /********************************************************************/
        button2.setOnAction(e->{
            list.add("\0");
            String x=area.getText();
            String w=Decompress(x,res);
            res.appendText(w);
            done.setText("Decompresssed text Done.....");



        });
        /*****************************************************************/
        button3.setOnAction(e->
        {
            list.add("\0");

            FileChooser fileChooser=new FileChooser();
            File f = fileChooser.showOpenDialog(window);
            try{

                Scanner scan=new Scanner(f);
                while(scan.hasNext()) {
                    String text = scan.nextLine();


                    result = compression(text, res);
                    whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(result, "newFile.txt");
                }
            }
            catch(Exception c){
                showAlertWithDefaultHeaderText();


            }
            done.setText("File Is Compressed");

        });
        /**********************************************************************/
        button4.setOnAction(e->
        {
            list.add("\0");

            FileChooser fileChooser=new FileChooser();
            File f = fileChooser.showOpenDialog(window);
            try{
                Scanner scan=new Scanner(f);
                while(scan.hasNextLine()){
                String text=scan.nextLine();
                result=Decompress(text,res);
                whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(result,"newMO.txt");}

            }
            catch(Exception c){
                showAlertWithDefaultHeaderText();


            } done.setText("File Is Decompressed");

        });

        pan.setStyle("-fx-background-image: url('mo.PNG')");
        pan.getChildren().addAll(l1,area,l2,res,button1,button2,button3,button4,done);
        Scene scene=new Scene(pan,800,300);
        window.setScene(scene);

        window.show();








    }
    /**********************************************************************************/
    public  String compression(String x,TextArea res) {
        for (int i = 0; i < x.length(); i++) {

            for (int j = i + 1; j <= x.length(); j++) {
                aux = x.substring(i, j);
                if (list.contains(aux)) {
                    pointer = list.indexOf(aux);
                    if (j == x.length()) {
                        //res.appendText(" < " + pointer + "," + null + "> ");

                        mo_salah+=("<" + pointer + ","  + ">");

                        i = x.length();
                        break;
                    }

                } else {
                    list.add(aux);
                    //System.out.print(" < "+pointer+","+(aux.charAt(aux.length()-1))+"> ");
                   // res.appendText(" < " + pointer + "," + (aux.charAt(aux.length() - 1)) + "> ");
                   mo_salah+=("<" + pointer + "," + (aux.charAt(aux.length() - 1)) + ">");
                    pointer = 0;
                    i = j - 1;
                    break;
                }
            }
        }
        //res.appendText("/0");
        list.clear();
        String mom=mo_salah;
        mo_salah="";

        return mom;
    }
    /********************************************************************************/
    public String Decompress(String x,TextArea res){
        boolean answer=true;
        String toShow="";
        String integ="";
        int pointer=0;
        ArrayList<String>list=new ArrayList<String>();
        list.add(null);
        for(int i=0;i<x.length();i++) {

            if(x.charAt(i)=='<'||x.charAt(i)=='>'||x.charAt(i)==',')continue;
            if(x.charAt(i)>=48&&x.charAt(i)<=57) {
                //System.out.println(true);
                integ+=x.substring(i,i+1);
                pointer=Integer.parseInt(integ);
                //System.out.println(integ);
                continue;
            }


            else {
                if(pointer==0){
                    list.add(x.substring(i,i+1));
                    toShow+=x.substring(i,i+1);
                    integ="";
                    pointer=-1;

                }


                else {

                    if(list.size()>=pointer&&pointer>=0) {

                        toShow+=list.get(pointer);
                        toShow+=(x.substring(i,i+1));
                        String mo=list.get(pointer);
                        mo+=(x.substring(i,i+1));
                        list.add(mo);
                        mo="";
                        integ="";
                        pointer=-1;
                    }
                    else {
                        showAlertWithDefaultHeaderText();
                        //answer=false;
                    }


                }}
        }

        if(pointer>0)toShow+=list.get(pointer);
        list.clear();
        if(answer){
                return(toShow);
        }
        else
            return "";



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
                    public void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(String str,String fileName)
                            throws IOException {

                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                        writer.append(' ');
                        writer.append(str);

                        writer.close();
                    }
}


