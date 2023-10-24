package br.com.javawebservlet;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BookStoreLoginService {

    UserService userService = new UserService();
    public Boolean login(String username, String password) throws ClassNotFoundException {
        return userService.authenticateUserByUsernameAndPassword(username, password) ? TRUE : FALSE;
    }
}
