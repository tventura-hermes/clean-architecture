package users.infrastructure;

import users.domain.createUserRepository;
import users.domain.userInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createUserInfrastructor implements createUserRepository{

    private static final String databaseUrl = "jdbc:postgresql://localhost:5432/hexagonal_architecture";
    private static final String user = "tariq";
    private static final String password = "123";

    @Override
    public void saveUser(userInterface dataUser) {
        try (Connection connection = DriverManager.getConnection(databaseUrl, user, password)) {
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, dataUser.getUser());
                preparedStatement.setString(2, dataUser.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}
