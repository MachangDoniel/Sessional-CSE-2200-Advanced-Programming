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



public class mainInterface {
    Stage window;

    Image image = new Image("/sample/bank.png");


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
        Button forgot= new Button("Forgot password?");
        Button login = new Button("Login");

        GridPane center = new GridPane();
        center.setVgap(8);
        center.setHgap(10);

        GridPane.setConstraints(username,0,0);
        GridPane.setConstraints(name,1,0);
        GridPane.setConstraints(password,0,1);
        GridPane.setConstraints(pass,1,1);
        GridPane.setConstraints(login,0,5);
        GridPane.setConstraints(forgot,1,5);



        center.getChildren().addAll(username,name,password,pass,forgot,login);


        //center.setPadding(new Insets(20,20,20,20));

        pane.setCenter(center);
        pane.setTop(box);


        window.setTitle("Banking System");

        Scene scene = new Scene(pane,500,550);

        scene.getStylesheets().add("/sample/Dark.css");

        window.setScene(scene);
        window.show();

    }
}
