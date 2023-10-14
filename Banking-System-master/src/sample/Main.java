package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;


    Image image = new Image("/sample/bank.png");
    Image icon = new Image("/sample/bank.ico");

    @Override
    public void start(Stage primaryStage) throws Exception{

        Button login= new Button("Login");
        Button signup = new Button("Signup");
        Button banks = new Button("Check Bank Info");

        login.setMinWidth(100);
        signup.setMinWidth(100);

        window = primaryStage;
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));

        login.setOnAction(e->{
            Lo log= new Lo();
            log.run();
        });
        signup.setOnAction(e->{
            SignUp sign= new SignUp();
            sign.draw();
        });
        banks.setOnAction(e->{
            BankInfo info= new BankInfo();
        });

        GridPane hbox= new GridPane();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setHgap(85);
        hbox.setVgap(30);
        GridPane.setConstraints(login,0,0);
        GridPane.setConstraints(signup,1,0);
        GridPane.setConstraints(banks,2,0);
        hbox.getChildren().addAll(login,signup,banks);
        pane.setCenter(hbox);

        VBox vBox= new VBox();
        vBox.getChildren().add(new ImageView(image));

        vBox.setPadding(new Insets(50,50,50,50));

        pane.setTop(vBox);

        Scene scene = new Scene(pane,520,500);
        scene.getStylesheets().add("/sample/Dark.css");
        window.setScene(scene);

        window.getIcons().add(icon);

        window.setTitle("Banking System");

        window.show();

    }


    public static void main(String[] args) { launch(args); }
}
