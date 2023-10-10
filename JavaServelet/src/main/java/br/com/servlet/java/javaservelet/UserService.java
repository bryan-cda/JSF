package br.com.servlet.java.javaservelet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class UserService {
    public static final String mockUsername = "foo";
    public static final String mockPassword = "bar";
    List<User> mockDataBase = new ArrayList<>();

    public Boolean authenticateUserByUsernameAndPassword(String username, String password) throws ClassNotFoundException {
        mockDataBase.add(new User(mockUsername, mockPassword));

        long count = mockDataBase.stream()
                .filter(u -> normalizeCredentialsToCompare(u.getUsername())
                        .equals(normalizeCredentialsToCompare(username))
                        && normalizeCredentialsToCompare(u.getPassword())
                        .equals(normalizeCredentialsToCompare(password)))
                .count();

        return compareCountMajorThanZero(count);
    }

    public static String normalizeCredentialsToCompare(String credential){
        return credential.toUpperCase();
    }

    public static Boolean compareCountMajorThanZero(Long credential){
        return credential > 0;
    }
}
