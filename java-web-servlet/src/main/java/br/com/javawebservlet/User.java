package br.com.javawebservlet;
public class User {
    private String user;
    private String username;
    private String password;

    public User(String user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
    }
    public User() {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
