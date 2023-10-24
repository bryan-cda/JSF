package br.com.javawebservlet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static final String mockUsername = "foo";
    private static final String mockPassword = "bar";
    private static final String mockUser = "Bryan";
    List<User> mockDataBase = new ArrayList<>();

    public Boolean authenticateUserByUsernameAndPassword(String username, String password) throws ClassNotFoundException {
        mockDataBase.add(new User(mockUser,mockUsername, mockPassword));

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

    public User findByUsername(String username) {
        return mockDataBase.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList()).get(0);
    }
}
