package Login;
import java.sql.*;

public class UserDisplay {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/java_login_register";
        String username = "root";
        String password = "1562005";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT * FROM users";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    
                    String userid_ = resultSet.getString("username");
                        String passwordHash = resultSet.getString("password");
                 
                
                    System.out.println("Username: " + userid_);
                    System.out.println("Password Hash: " + passwordHash);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
