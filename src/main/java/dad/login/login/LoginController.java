package dad.login.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    private LoginView view = new LoginView();
    private LoginModel model = new LoginModel();

    public LoginController() {

        view.getUserText().textProperty().bindBidirectional(model.userProperty());
        view.getPsswdText().textProperty().bindBidirectional(model.passwordProperty());

        view.getAccederButton().setOnAction(this::onAccessAction);
        view.getCancelarButton().setOnAction(this::onCancelAction);

    }

    private void onAccessAction(ActionEvent e) {

        AuthService ldap = model.isUseLdap() ? new LdapAuthService() : new FileAuthService();

        try {
            if (ldap.login(model.getUser(), model.getClave())) {
                Alert alertSuccesLogin = new Alert(AlertType.INFORMATION);
                alertSuccesLogin.setTitle("LOGIN");
                alertSuccesLogin.setHeaderText("Acceso permitido");
                alertSuccesLogin.setContentText("Las credenciales de acceso son válidas");
            } else {
                Alert alertLoginFail = new Alert(AlertType.ERROR);
                alertLoginFail.setTitle("LOGIN");
                alertLoginFail.setHeaderText("Acceso denegado");
                alertLoginFail.setContentText("El usuario y/o la contraseña no son válidos");
                alertLoginFail.showAndWait();
            }

        } catch (Exception exception) {
            Alert alertError = new Alert(AlertType.ERROR);
            alertError.setTitle("LOGIN");
            alertError.setHeaderText("ERROR");
            alertError.setContentText("Se ha producido un error");
            alertError.showAndWait();
        }
    }

    private void onCancelAction(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }


}