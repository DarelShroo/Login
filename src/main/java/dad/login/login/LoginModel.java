package dad.login.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {

    private StringProperty user = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private BooleanProperty useLdap = new SimpleBooleanProperty();

    public StringProperty userProperty() {
        return this.user;
    }

    public String getUser() {
        return this.userProperty().get();
    }

    public void setUser(final String user) {
        this.userProperty().set(user);
    }

    public StringProperty passwordProperty() {
        return this.password;
    }

    public String getClave() {
        return this.passwordProperty().get();
    }

    public void setClave(final String password) {
        this.passwordProperty().set(password);
    }

    public BooleanProperty useLdapProperty() {
        return this.useLdap;
    }

    public boolean isUseLdap() {
        return this.useLdapProperty().get();
    }

    public void setUseLdap(final boolean useLdap) {
        this.useLdapProperty().set(useLdap);
    }
}