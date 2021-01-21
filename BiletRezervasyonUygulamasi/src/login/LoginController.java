package login;

import connection.ConnectionClass;
import Models.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void loginCheck(UserModel userModel) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM USER_LOGIN WHERE username ='"
                    + userModel.getKullaniciAdi()
                    + "' AND password ='" + userModel.getParola() + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                view.success();
            } else {
                view.error();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
