package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Profile {
    Image dp;
    Image icon = new Image("/sample/bank.ico");

    Stage window = new Stage();
    String bal="";

    Boolean destroy=false;

    Profile(String depositorName, String accountNumber, String balance, String father, String mother, String ddob, String phone, String password, String email, String address, String city, String postal, String bank,String accountType) {
        BankAccount client = new BankAccount(depositorName, accountNumber, balance, father, mother, ddob, phone, password, email, address, city, postal, bank,accountType);

        bal=balance;

        try {
            dp = new Image("/sample/" + depositorName + ".jpg", 500, 500, false, false);

        } catch (Exception e) {
            dp = new Image("/sample/default.png", 500, 500, false, false);

        }

        double newbal=1.0;

        if (client.getBank() == "Sonali") {
            Sonali sonali = new Sonali();
            newbal=sonali.setnewBalance(client.getTypeOfAccount(),Double.parseDouble(client.getBalance()));
        }
        else if(client.getBank()=="Agrani"){
            Agrani agrani = new Agrani();
            newbal=agrani.setnewBalance(client.getTypeOfAccount(),Double.parseDouble(client.getBalance()));
        }
        else{
            Janata janata = new Janata();
            newbal = janata.setnewBalance(client.getTypeOfAccount(),Double.parseDouble(client.getBalance()));
        }

        Label Name = new Label("Name: " + client.getDepositorName());
        Label fatherName = new Label("Father's Name: " + client.getFather());
        Label motherName = new Label("Mother's Name: " + client.getMother());
        Label dob = new Label("Date of Birth: " + client.getDdob());

        Label pphone = new Label("Phone: " + client.getPhone());
        Label eemail = new Label("Email: " + client.getEmail());
        Label aaddress = new Label("Address: " + client.getAddress());
        Label ciity = new Label("City: " + client.getCity());
        Label poostal = new Label("Postal Code: " + client.getPostal());


        Button bbalance = new Button("Check Balance");
        Button Transaction = new Button("Transaction");

        Label accountno = new Label("Account ID: " + client.getAccountNumber());
        Label banktype = new Label("Bank: " + client.getBank());

        Label acctype = new Label("Account Type: "+client.getTypeOfAccount());

        Button setdp = new Button("Upload new Profile Picture");



        BorderPane pane = new BorderPane();





        GridPane grid = new GridPane();

        grid.setHgap(30);
        grid.setVgap(10);

        //GridPane.setConstraints(new ImageView(dp), 0, 0);
        GridPane.setConstraints(new ImageView(dp), 0, 0);

        GridPane.setConstraints(Name, 0, 1);

        GridPane.setConstraints(accountno, 0, 2);


        GridPane.setConstraints(fatherName, 0, 3);


        GridPane.setConstraints(motherName, 0, 4);


        GridPane.setConstraints(dob, 0, 5);


        GridPane.setConstraints(pphone, 1, 1);

        GridPane.setConstraints(eemail, 1, 2);

        GridPane.setConstraints(aaddress, 1, 3);

        GridPane.setConstraints(ciity, 1, 4);
        GridPane.setConstraints(poostal, 1, 5);

        //GridPane.setConstraints(bbalance, 0, 6);

        GridPane.setConstraints(banktype, 1, 6);

        GridPane.setConstraints(setdp,1,0);

        GridPane.setConstraints(acctype,0,6);

        GridPane.setConstraints(Transaction,2,0);

        GridPane.setConstraints(bbalance,3,0);




        grid.setPadding(new Insets(20, 20, 20, 20));


        grid.getChildren().addAll(Name, accountno, fatherName, motherName, dob, pphone, eemail, aaddress, ciity, poostal, banktype, setdp,new ImageView(dp),acctype,bbalance,Transaction);


       // pane.getChildren().addAll(box,grid);

        Scene scene = new Scene(grid, 1100, 780);

        scene.getStylesheets().add("/sample/dark_pro.css");

        window.setScene(scene);
        window.show();


        window.getIcons().add(icon);

        window.setTitle("Banking System");





        bbalance.setOnAction(e->{


            try{
                File file= new File("Info.txt");
                //"C:\\Users\\saadm\\IdeaProjects\\Banking System\\Info.txt"
                //BufferedReader br = new BufferedReader(new FileReader(file));

                Scanner x= new Scanner(file);
                int cnt=0;


                String words[] = new String[14];
                while (x.hasNext()) {
                    for (int i = 0; i < 14; i++) {
                        words[i] = x.next();
                    }
                    //String a= "\n"+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next()+" "+x.next();
                    if (words[0].equals(client.getAccountNumber())) {
                        Infobox info = new Infobox(client.getDepositorName()+" your balance is : "+words[11]);
                        cnt++;

                    }

                }
              x.close();

            }
            catch(IOException ee){
                System.out.println("Exception Caught");
            }
        });

        setdp.setOnAction(
                e -> {


                    FileChooser fileChooser = new FileChooser();

                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Picture Files", "*.png","*.jpg"));

                    File selectedFile = fileChooser.showOpenDialog(window);


                    String loc = String.format("%s", selectedFile.getAbsolutePath());
                    loc = loc.replace("\\", "\\\\");


                    try {


                        ///THIS PART IS USED TO COPY A FILE FROM THE GIVEN DIRECTORY TO THE BIN DIRECTORY

                        Path source = Paths.get(loc);
                        Path dest = Paths.get("C:\\Users\\saadm\\IdeaProjects\\Banking System\\src\\sample");
                        CopyOption options[] = new CopyOption[]{
                                StandardCopyOption.REPLACE_EXISTING,
                                // StandardCopyOption.COPY_ATTRIBUTES
                        };
                        Files.createDirectories(dest);
                        Path target = dest.resolve(depositorName+".jpg");
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

                    } catch (Exception ee) {

                        Error error = new Error("The link is not valid");

                    }

                    Infobox info= new Infobox("Reload this application to view changes");
                }

        );

        Transaction.setOnAction(e->{

            Transaction trans= new Transaction();
            trans.run(client,destroy);
            if(destroy==true){
                window.close();
            }
            System.out.println(destroy);
        });


    }

}



