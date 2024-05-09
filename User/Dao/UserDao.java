package JokeServer.User.Dao;

import JokeServer.User.Model.User;

public interface UserDao {

    void addUser(User user);
    void retrieveUser(int id);
    void updateUser(int id, String name, String surname, String username, String password);
    void deleteUser(int id);
}
