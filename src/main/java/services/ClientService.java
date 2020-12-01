package services;

import entities.Client;
import entities.Statuses;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String GET_ALL = "SELECT * FROM customers";
    private static final String GET_CLIENTS = "SELECT * FROM clients c INNER JOIN accounts h ON c.id = h.client_id";
    private static final String GET_CLIENTS_OLDER_18 = "SELECT c.name, c.email, s.alies FROM clients c INNER JOIN clint_statuses cs ON c.id = cs.id INNER JOIN clients ON c.age > 18";

    public List<Client> getAll() {
        List<Client> customers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getInt("phone"));
                client.setAbout(resultSet.getString("about"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Client> getClients() {
        List<Client> customers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_CLIENTS);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getInt("phone"));
                client.setAbout(resultSet.getString("about"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Client> getClientsOlder18() {
        List<Client> customers = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_CLIENTS_OLDER_18);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                Statuses statuses = new Statuses();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                statuses.setAlies(resultSet.getString("alies"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
