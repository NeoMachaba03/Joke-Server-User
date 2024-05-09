package JokeServer.User.Dao;

import JokeServer.Database.DBConfig;
import JokeServer.User.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DBConfig implements UserDao {

    private Connection c = getCon();

    public boolean login(String username, String password){
        try (PreparedStatement statement = c.prepareStatement("SELECT * FROM users WHERE Username = ? AND Password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        try (PreparedStatement ps = c.prepareStatement("INSERT INTO users(Name, Surname, Username, Password) VALUES(?, ?, ?, ?)")) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nUser added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void retrieveUser(int id) {
        try (PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE UserID = ?");
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);

            while (rs.next()) {
                int userID = rs.getInt("UserID");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String username = rs.getString("Username");
                String password = rs.getString("Password");

                System.out.println("\nUserID: " + userID + "\tName: " + name + " " + surname + "\tUsername: " + username + "\tPassword: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int id, String name, String surname, String username, String password) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE users SET Name = ?, Surname = ?, Username = ?, Password = ? WHERE UserID = ?")) {

            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nUser has successfully been updated!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE UserID = ?")) {

            ps.setInt(1,id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nJoke has successfully been deleted!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}