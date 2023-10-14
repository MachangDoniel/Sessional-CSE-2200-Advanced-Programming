package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class newAccountConfirmation {

    Stage window = new Stage();

    Image icon = new Image("/sample/bank.ico");

    newAccountConfirmation(String name,String accnum,String balance,String bank){
        Label text= new Label(String.format("Congratulations %s on opening a new %s bank account",name,bank));

        Label anum=new Label("Account number : "+accnum);
        Label balanceinfo=new Label("Current balance : "+balance);

        VBox box = new VBox();
        box.setPadding(new Insets(10,30,10,10));
        box.setSpacing(50);

        box.getChildren().addAll(text,anum,balanceinfo);

        Scene scene = new Scene(box,500,200);
        scene.getStylesheets().add("/sample/Dark.css");

        window.setScene(scene);
        window.setScene(scene);

        window.getIcons().add(icon);

        window.setTitle("Banking System");

        window.show();
    }
}
