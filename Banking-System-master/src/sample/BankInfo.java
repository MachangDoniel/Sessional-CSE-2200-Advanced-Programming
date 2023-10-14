package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankInfo {

    Stage window = new Stage();
    Image icon = new Image("/sample/bank.ico");

    Image sonali = new Image("/sample/sonali.png",300,200,false,false);
    Image agrani = new Image("/sample/agrani.png",300,200,false,false);
    Image janata = new Image("/sample/janata.png",300,200,false,false);


    BankInfo(){
        GridPane grid = new GridPane();
        grid.setVgap(30);
        grid.setHgap(30);

        grid.setPadding(new Insets(30,30,30,30));

        Label ssonali = new Label("Sonali Bank\nSavings Interest: 1%\nFixed Interest: 2.5%");

        Label jjanata = new Label("Janata Bank\nSavings Interest: 1%\nFixed Interest: 2%");

        Label aagrani = new Label("Agrani Bank\nSavings Interest: 1%\nFixed Interest: 3%");

        BorderPane pane = new BorderPane();

        GridPane.setConstraints(ssonali,0,2);
        GridPane.setConstraints(aagrani,0,7);
        GridPane.setConstraints(jjanata,0,12);

        grid.getChildren().addAll(ssonali,aagrani,jjanata);




        VBox box = new VBox();
        box.setSpacing(30);
        box.setPadding(new Insets(30,30,30,30));
        box.getChildren().addAll(new ImageView(sonali),new ImageView(agrani),new ImageView(janata));

        pane.setLeft(box);
        pane.setRight(grid);

        Scene scene = new Scene(pane, 800, 730);

        scene.getStylesheets().add("/sample/dark_pro.css");

        window.setScene(scene);
        window.show();


        window.getIcons().add(icon);

        window.setTitle("Banking System");
    }
}
