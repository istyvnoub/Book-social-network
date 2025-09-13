import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/book_social_network";
        String username = "username";
        String password = "password";
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connexion réussie à PostgreSQL !");
            System.out.println("URL: " + url);
            System.out.println("User: " + username);
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion: " + e.getMessage());
        }
    }
}
