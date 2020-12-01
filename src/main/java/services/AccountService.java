package services;

import utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountService {
    private static final String DELETE = "DELETE FROM customers WHERE id = ?";
    private static final String SEARCH_BY_PHONE_NUMBER = "SELECT phone FROM clients WHERE phone = ?";
    private static final String GET_NUMBER = "SELECT number FROM accounts WHERE value > ?";

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByPhoneNumber(int phone) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_PHONE_NUMBER)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, phone);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getNumber(double value) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_NUMBER)) {
            connection.setAutoCommit(false);
            preparedStatement.setDouble(1, value);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
