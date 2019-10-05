package GUI.GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Iterator;

public class Test {
  public static void creatFile(String Text)throws IOException{
      BufferedWriter writer=new BufferedWriter(new FileWriter("mo.txt",true));
  }


    public static void main(String[] args) {
        ArrayList<String>dic=new ArrayList<String>();

        for(int i=0;i<=127;i++){
            char m=(char) i;
            dic.add(Character.toString(m));
        }

        /***************************************************/
        String cw="";
        String pw="";
        String p="";
        String c="";
        String text="97 98 99 97 130";
        String[]arr=text.split(" ");



            System.out.println(dic.get(Integer.parseInt(arr[0])));
        for(int i=1;i<arr.length;i++){
            pw=cw;
            cw=arr[i];
            if(Integer.parseInt(cw)<=dic.size()){
                System.out.println(dic.get(Integer.parseInt(cw)));
                p=dic.get(Integer.parseInt(cw));
                String aux=dic.get(Integer.parseInt(cw));
                c=aux.substring(0,1);
                dic.add(p+c);

            }
            else{
                p=dic.get(Integer.parseInt(pw));
                c=p.substring(0,1);
                dic.add(p+c);
                System.out.println(p+c);





            }


        }
        /************************************/




    }
}
