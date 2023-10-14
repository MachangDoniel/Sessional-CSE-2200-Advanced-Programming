package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Infobox {
    Stage window = new Stage();
    Image image = new Image("/sample/info.png",30,30,false,false);
    Image icon = new Image("/sample/bank.ico");
    Infobox(String message){
        Label label = new Label(message);

        HBox box= new HBox();
        box.setSpacing(20);
        box.getChildren().addAll(new ImageView(image),label);
        box.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(box,600,60);

        scene.getStylesheets().add("/sample/Dark.css");
        window.setScene(scene);

        window.getIcons().add(icon);

        window.setTitle("Banking System");

        window.show();

    }
}
