package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/java_login_register";
    private static final String username = "root";
    private static final String password = "1562005";

    public boolean insertUser(User user) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
             
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}