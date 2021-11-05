package dad.login;

import dad.login.login.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginController loginController = new LoginController();

        Scene loginScene = new Scene(loginController.getView(), 320, 200);

        Stage loginStage = new Stage();
        loginStage.setTitle("LOGIN");
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}