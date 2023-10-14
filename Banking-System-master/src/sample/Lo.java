package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lo {

    Stage window;

    Image image = new Image("/sample/bank.png");

    Image icon = new Image("/sample/bank.ico");
    void run(){
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,20,10,10));
        window = new Stage();

        VBox box = new VBox();
        box.setPadding(new Insets(50,50,50,50));
        box.getChildren().add(new ImageView(image));

        Label username= new Label("Username : ");
        Label password = new Label("Password: ");
        TextField name= new TextField();
        name.setPromptText("Enter name here e.g Gomes");
        PasswordField pass= new PasswordField();
        pass.setPromptText("Enter password here ");
        //Button forgot= new Button("Forgot password?");
        Button login = new Button("Login");
        login.setMinWidth(100);

        GridPane center = new GridPane();
        center.setVgap(8);
        center.setHgap(10);

        GridPane.setConstraints(username,0,0);
        GridPane.setConstraints(name,1,0);
        GridPane.setConstraints(password,0,1);
        GridPane.setConstraints(pass,1,1);
        GridPane.setConstraints(login,0,5);
        //GridPane.setConstraints(forgot,1,5);

        login.setOnAction(e->{

            int cnt=0;

            String depositorName = null;
            String typeOfAccount= null;
            String AccountNumber= null;
            String balance= null;
            String passw= null;
            String Father= null;
            String Mother= null;
            String ddob= null;
            String phone= null;
            String email= null;
            String address= null;
            String city= null;
            String postal= null;
            String Bank= null;
 //accnum+" "+name.getText()+" "+fathername.getText()+" "+mothername.getText()+" "+date.getText()+" "+pass.getText()+" "+phonenum.getText()+" "+em.getText()+" "+add.getText()+" "+ci.getText()+" "+post.getText()+" "+Balance.getText()+" "+cbox.getValue();
            try{
                File file= new File("Info.txt");
                //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                //BufferedReader br = new BufferedReader(new FileReader(file));
                String nameis=name.getText();
                String passis=pass.getText();
                String st;

                Scanner x= new Scanner(file);

                //while ((st = br.readLine()) != null) {
                  //  String[] words = st.split("\\s");
                while(x.hasNext()){


//                   int i = 0;
//
//                    for (String w : words) {
//                        System.out.println(i++ + " " + w);
//                    }


                    AccountNumber = x.next();
                    System.out.println(AccountNumber);
                    //System.out.println("Successfully printed 1");

                    depositorName = x.next();
                    System.out.println(depositorName);


                    Father = x.next();
                    //System.out.println("Successfully printed 2");

                    Mother = x.next();
                    //System.out.println("Successfully printed 2");

                    ddob = x.next();
                    // System.out.println("Successfully printed 2");

                    passw = x.next();
                    // System.out.println("Successfully printed 2");

                    phone = x.next();
                    // System.out.println("Successfully printed 2");

                    email = x.next();
                    // System.out.println("Successfully printed 2");

                    address = x.next();
                    // System.out.println("Successfully printed 2");

                    city = x.next();
                    // System.out.println("Successfully printed 2");

                    postal = x.next();
                    //System.out.println("Successfully printed 2");

                    balance = x.next();
                    //System.out.println("Successfully printed 2");

                    Bank = x.next();

                    typeOfAccount = x.next();


                    System.out.println(depositorName + " " + nameis + " " + passw + " " + passis);
                    if (depositorName.equals(nameis) && passw.equals(passis)) {
                        cnt++;
                        //System.out.println(depositorName+" "+Password);
                        break;
                    }
//                    for(int i=0;i<words.length;i++){
//                        System.out.println(i+" "+words[i]);
//                    }
               }




                if(cnt==0){
                    Error error= new Error("Wrong information Entered");
                }
                else{
                    //String depositorName, String typeOfAccount, String accountNumber, String balance, String father, String mother, String ddob, String phone, String password, String email, String address, String city, String postal, String bank
                    Profile client= new Profile(depositorName,AccountNumber, balance, Father, Mother, ddob, phone,passw, email, address, city, postal, Bank,typeOfAccount);
                }



                x.close();

            }
            catch(IOException ee){
                System.out.println("Exception Caught");
            }

        });

        center.getChildren().addAll(username,name,password,pass,login);


        //center.setPadding(new Insets(20,20,20,20));

        pane.setCenter(center);
        pane.setTop(box);


        window.setTitle("Banking System");

        Scene scene = new Scene(pane,520,600);

        scene.getStylesheets().add("/sample/Dark.css");

        window.setScene(scene);
        window.getIcons().add(icon);

        window.setTitle("Banking System");
        window.show();

        window.getIcons().add(icon);

        window.setTitle("Banking System");

    }
}
