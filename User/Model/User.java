package JokeServer.User.Model;

public class User {

    private int userID;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User(int userID, String name, String surname, String username, String password) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
