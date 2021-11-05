package dad.login.see;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

    private final TextField userText;
    private final PasswordField psswdText;
    private final CheckBox useLdapCheck;
    private final Button accessButton;
    private final Button cancelButton;

    public LoginView() {
        super();

        userText = new TextField();
        userText.setPrefColumnCount(8);
        userText.setPromptText("Nombre de usuario");

        psswdText = new PasswordField();
        psswdText.setPrefColumnCount(8);
        psswdText.setPromptText("Contraseña de usuario");

        useLdapCheck = new CheckBox("Usar LDAP");

        accessButton = new Button("Acceder");

        cancelButton = new Button("Cancelar");


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.addRow(0, new Label("Usuario:"), userText);
        gridPane.addRow(1, new Label("Contraseña:"), psswdText);
        gridPane.addRow(2);
        gridPane.add(useLdapCheck, 1, 2);

        ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints()};
        gridPane.getColumnConstraints().setAll(cols);

        RowConstraints[] rows = { new RowConstraints(), new RowConstraints(), new RowConstraints()};
        gridPane.getRowConstraints().setAll(rows);

        //RESTRICCIONES PANEL GRID GENERAL
        cols[0].setHgrow(Priority.NEVER);
        cols[1].setHgrow(Priority.ALWAYS);

        HBox hBox = new HBox(5, accessButton,cancelButton);
        hBox.setSpacing(5);
        hBox.setFillHeight(false);
        hBox.setAlignment(Pos.CENTER);


        this.setSpacing(5);
        this.setFillWidth(false);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(gridPane, hBox);

    }

    public TextField getUserText() {
        return userText;
    }

    public PasswordField getPsswdText() {
        return psswdText;
    }

    public CheckBox getUseLdapCheck() {
        return useLdapCheck;
    }

    public Button getAccederButton() {
        return accessButton;
    }

    public Button getCancelarButton() {
        return cancelButton;
    }
}