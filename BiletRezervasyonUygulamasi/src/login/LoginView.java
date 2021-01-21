package login;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import messageType.IResultMessageInterface;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Models.UserModel;
import tools.Utility;

import java.sql.SQLException;

public class LoginView implements IResultMessageInterface {
    public TextField kullaniciAdiTextField;
    public PasswordField parolaField;
    public Label kullaniciAdiLbl;
    public Label parolaLbl;
    public Label connectionResult;
    public LoginController controller;
    public Button grsBtn;

    public void girisYapBtn(ActionEvent actionEvent) throws SQLException {
        controller = new LoginController(this);

        UserModel userModel = new UserModel();
        userModel.setKullaniciAdi(kullaniciAdiTextField.getText());
        userModel.setParola(parolaField.getText());

        controller.loginCheck(userModel);
    }

    @Override
    public void success() {
        connectionResult.setText(Utility.successMessage());
    }

    @Override
    public void error() {
        connectionResult.setText(Utility.errorMessage());
    }
}
