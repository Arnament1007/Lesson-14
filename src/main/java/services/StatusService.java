package services;

import entities.Client;
import utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusService {
    private static final String SAVE = "INSERT INTO customers (name, email, phone, about) VALUES (?,?,?,?)";
    private static final String UPDATE_ALL = "UPDATE customers SET name, email, phone, about = ?, ?, ?, ? where id = ?";

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            ;
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setInt(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmail(int id, String newName, String newEmail, int newPhone, String newAbout) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALL)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setInt(3, newPhone);
            preparedStatement.setString(4, newAbout);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
