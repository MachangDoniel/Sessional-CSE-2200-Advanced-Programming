package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Transaction {

    Stage window = new Stage();
    Image icon = new Image("/sample/bank.ico");
    double bal;
    boolean dispose;
    Transaction(){
        dispose=false;
    }
    void run(BankAccount banker,boolean destroy){

        Button Deposit = new Button("Deposit");
        Button withdraw= new Button("Withdraw");
        TextField tf= new TextField();
        tf.setPromptText("Enter an amount here");
        bal= Double.parseDouble(banker.getBalance());

        withdraw.setOnAction(e->{
            if(tf.getText() != null ){

                try {
                    if (Double.parseDouble(tf.getText()) >= 0.0) {

                        double Amount = Double.parseDouble(tf.getText());

                        if (bal - 500 <= Amount) {
                            Error error = new Error("Insufficient Balance!");
                        } else {
                            bal = bal - Amount;

                            if (banker.getBank().equals("Sonali")) {
                                Sonali sona = new Sonali();
                                bal = sona.setnewBalance(banker.getTypeOfAccount(), bal);
                            } else if (banker.getBank().equals("Agrani")) {
                                Agrani agra = new Agrani();
                                bal = agra.setnewBalance(banker.getTypeOfAccount(), bal);
                            } else {
                                Janata janata = new Janata();
                                bal = janata.setnewBalance(banker.getTypeOfAccount(), bal);
                            }

                            LinkedList<String> list = new LinkedList<>();

                            try {
                                File fil = new File("Info.txt");
                                //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                                //BufferedReader br = new BufferedReader(new FileReader(file));
                                String st;

                                Scanner x = new Scanner(fil);
                                String words[] = new String[14];
                                while (x.hasNext()) {
                                    for (int i = 0; i < 14; i++) {
                                        words[i] = x.next();
                                        System.out.println(i + " " + words[i]);
                                    }
                                    //String a= "\n"+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next();
                                    if (words[0].equals(banker.getAccountNumber())) {
                                        words[11] = String.format("%s", bal);
                                    }

                                    String a = "\n" + words[0];

                                    for (int i = 1; i < 14; i++) {
                                        a += " " + words[i];
                                    }
                                    list.add(a);
                                }
                                x.close();

                                Iterator<String> it = list.iterator();
                                String res = "";

                                while (it.hasNext()) {
                                    res += it.next();
                                }

                                FileWriter writer = new FileWriter(new File("Info.txt"));
                                //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                                writer.write(res);
                                writer.close();

                                Infobox info = new Infobox("Balance has been successfully updated, please reload page to do further Transactions");
                                dispose=true;
                                window.close();


                            } catch (IOException ee) {
                                System.out.println("Exception caught in handling Deposit");

                            }

                        }
                    }
                    else{
                        Error error= new Error("Please Enter a valid amount");
                    }
                }
                catch (Exception ee){
                    Error error= new Error("Please Enter a valid amount");
                }

            }
            else{
                Error error= new Error("Please Enter a valid amount");
            }
        });

        Deposit.setOnAction(e->{
            if(tf.getText() != null ) {
                try {
                    if (Double.parseDouble(tf.getText()) >= 0.0) {
                        double Amount = Double.parseDouble(tf.getText());


                        bal = bal + Amount;

                        if (banker.getBank().equals("Sonali")) {
                            Sonali sona = new Sonali();
                            bal = sona.setnewBalance(banker.getTypeOfAccount(), bal);
                        } else if (banker.getBank().equals("Agrani")) {
                            Agrani agra = new Agrani();
                            bal = agra.setnewBalance(banker.getTypeOfAccount(), bal);
                        } else {
                            Janata janata = new Janata();
                            bal = janata.setnewBalance(banker.getTypeOfAccount(), bal);
                        }

                        LinkedList<String> list = new LinkedList<>();

                        try {
                            File file = new File("Info.txt");
                            //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                            //BufferedReader br = new BufferedReader(new FileReader(file));
                            String st;

                            Scanner y = new Scanner(file);
                            String[] word = new String[14];
                            while (y.hasNext()) {
                                for (int i = 0; i < 14; i++) {
                                    word[i] = y.next();
                                }
                                //String a= "\n"+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next();
                                if (word[0].equals(banker.getAccountNumber())) {
                                    word[11] = String.format("%s", bal);
                                }

                                String a = "\n" + word[0];

                                for (int i = 1; i < 14; i++) {
                                    a += " " + word[i];
                                }
                                list.add(a);
                            }
                            y.close();

                            Iterator<String> it = list.iterator();
                            String re = "";

                            while (it.hasNext()) {
                                re += it.next();
                            }

                            FileWriter write = new FileWriter(new File("Info.txt"));
                            //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                            write.write(re);
                            write.close();

                            Infobox info = new Infobox("Balance has been successfully updated, please reload page to do further Transactions");
                            dispose=true;
                            window.close();

                        } catch (IOException ee) {
                            System.out.println("Exception caught in handling Deposit");
                        }

                    }
                    else{
                        Error error= new Error("Please Enter a valid amount");
                    }
                }
                catch(Exception ee){
                    Error error= new Error("Please Enter a valid amount");
                }
            }

            else{
                Error error= new Error("Please Enter a valid amount");
            }
        });

        GridPane grid= new GridPane();

        Label label = new Label("Enter Amount:");

        GridPane.setConstraints(label,0,0);
        GridPane.setConstraints(tf,1,0);
        GridPane.setConstraints(Deposit,0,1);
        GridPane.setConstraints(withdraw,1,1);
         grid.setPadding(new Insets(10,10,10,10));
         grid.setHgap(30);
         grid.setVgap(30);

         grid.getChildren().addAll(label,tf,Deposit,withdraw);

        window.setTitle("Banking System");

        Scene scene = new Scene(grid,500,100);

        scene.getStylesheets().add("/sample/Dark.css");

        window.setScene(scene);
        window.getIcons().add(icon);

        window.setTitle("Banking System");
        window.show();

        window.getIcons().add(icon);

        window.setTitle("Banking System");


        destroy=dispose;



    }
}
