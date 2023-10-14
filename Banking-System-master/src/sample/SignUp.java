package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SignUp {
    Stage window= new Stage();
    Image icon = new Image("/sample/bank.ico");
    ComboBox<String> cbox;
    ComboBox<String> accounttype;
    void draw(){
        Label Name= new Label("Name: ");
        Label fatherName= new Label("Father's Name: ");
        Label motherName= new Label("Mother's Name: ");
        Label dob = new Label("Date of Birth: ");
        Label Password= new Label("Password: ");

        Label phone= new Label("Phone: ");
        Label email= new Label("Email: ");
        Label address= new Label("Adress: ");
        Label city= new Label("City: ");
        Label postal= new Label("Postal Code: ");

        TextField name= new TextField();
        name.setPromptText("Enter name here e.g Gomes");

        TextField fathername= new TextField();
        fathername.setPromptText("Enter Father's name here");

        TextField mothername= new TextField();
        mothername.setPromptText("Enter Mother's name here");

        TextField phonenum= new TextField();
        phonenum.setMinWidth(200);
        phonenum.setPromptText("Enter phone number here");

        TextField add= new TextField();
        add.setPromptText("e.g 218st,West Carolina");

        TextField em= new TextField();
        em.setPromptText("e.g Gomes@gmail.com");

        TextField ci= new TextField();
        ci.setPromptText("e.g Dhaka");

        TextField post= new TextField();
        post.setPromptText("e.g 1230");

        TextField date= new TextField();
        date.setPromptText("DDDD-MMMM-YYYY");

        PasswordField pass= new PasswordField();

        cbox= new ComboBox<>();
        cbox.setPromptText("Choose Bank to open account on");
        cbox.getItems().addAll(
                "Agrani",
                "Sonali",
                "Janata"
        );

        accounttype = new ComboBox<>();
        accounttype.setPromptText("Choose type of account");
        accounttype.getItems().addAll(
                "Savings",
                "Fixed"
        );


        Label balance= new Label("Balance: ");
        TextField Balance= new TextField();
        Balance.setPromptText("e.g Deposit atleast 500tk");

        Button signup = new Button("Sign Up");
        signup.setMinWidth(200);

        GridPane grid = new GridPane();

        grid.setHgap(30);
        grid.setVgap(10);

        GridPane.setConstraints(Name,0,0);
        GridPane.setConstraints(name,1,0);

        GridPane.setConstraints(fatherName,0,4);
        GridPane.setConstraints(fathername,1,4);

        GridPane.setConstraints(motherName,0,8);
        GridPane.setConstraints(mothername,1,8);

        GridPane.setConstraints(dob,0,12);
        GridPane.setConstraints(date,1,12);

        GridPane.setConstraints(Password,0,16);
        GridPane.setConstraints(pass,1,16);

        GridPane.setConstraints(phone,3,0);
        GridPane.setConstraints(phonenum,4,0);

        GridPane.setConstraints(email,3,4);
        GridPane.setConstraints(em,4,4);

        GridPane.setConstraints(address,3,8);
        GridPane.setConstraints(add,4,8);

        GridPane.setConstraints(city,3,12);
        GridPane.setConstraints(ci,4,12);

        GridPane.setConstraints(postal,3,16);
        GridPane.setConstraints(post,4,16);

        GridPane.setConstraints(cbox,1,20);

        GridPane.setConstraints(balance,3,20);
        GridPane.setConstraints(Balance,4,20);

        GridPane.setConstraints(accounttype,1,25);

        GridPane.setConstraints(signup,4,25);
        grid.setPadding(new Insets(20,20,20,20));


        grid.getChildren().addAll(Name,fatherName,motherName,Password,dob,city,phone,email,address,postal,name,fathername,mothername,pass,date,em,add,ci,post,phonenum,cbox,signup,balance,Balance,accounttype);

        signup.setOnAction(e->{


                    String accnum = null;

                    try{
                    File file = new File("Number.txt");
                    //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Number.txt"

                    BufferedReader br = new BufferedReader(new FileReader(file));

                    String st;
                    while ((st = br.readLine()) != null)
                       accnum=st;

                    br.close();

                        FileWriter fw=new FileWriter("Number.txt");
                        //C:\Users\saadm\IdeaProjects\Banking System\Number.txt
                        Integer num= Integer.parseInt(accnum)+1;
                        fw.write(String.format("%s",num));
                        fw.close();
                    }
                    catch(Exception eee) { System.out.println("Exception Caught"); }


                String a= "\n"+accnum+" "+name.getText()+" "+fathername.getText()+" "+mothername.getText()+" "+date.getText()+" "+pass.getText()+" "+phonenum.getText()+" "+em.getText()+" "+add.getText()+" "+ci.getText()+" "+post.getText()+" "+Balance.getText()+" "+cbox.getValue()+" "+accounttype.getValue(); //System line seperator makes a newline while appending
//System.lineSeparator()+


            try {
                Files.write(Paths.get("Info.txt"),a.getBytes(), StandardOpenOption.APPEND);
            }
            catch (IOException ee) {
                System.out.println("FIle non exixtant");
                //exception handling left as an exercise for the reader
            }

            newAccountConfirmation confirmed= new newAccountConfirmation(name.getText(),accnum,Balance.getText(),cbox.getValue());


        });
        Scene scene= new Scene(grid,900,500);
        scene.getStylesheets().add("/sample/Dark.css");

        window.setScene(scene);
        window.show();


        window.getIcons().add(icon);

        window.setTitle("Banking System");


    }
}
