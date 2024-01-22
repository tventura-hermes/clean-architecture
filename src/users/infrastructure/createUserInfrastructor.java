package users.infrastructure;

import users.domain.createUserRepository;
import users.domain.userInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createUserInfrastructor implements createUserRepository{

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/hexagonal_architecture";
    private static final String USER = "tariq";
    private static final String PASSWORD = "123";

    @Override
    public void saveUser(userInterface dataUser) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, dataUser.getUser());
                preparedStatement.setString(2, dataUser.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones en un entorno de producción
        }
    }
}
