package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Error {
    Stage window = new Stage();
    Image image = new Image("/sample/error.png");
    Image icon = new Image("/sample/bank.ico");
    Error(String message){
        Label label = new Label(message);

        HBox box= new HBox();
        box.setSpacing(20);
        box.getChildren().addAll(new ImageView(image),label);
        box.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(box,275,60);

        scene.getStylesheets().add("/sample/Dark.css");
        window.setScene(scene);

        window.getIcons().add(icon);

        window.setTitle("Banking System");

        window.show();

    }

}
