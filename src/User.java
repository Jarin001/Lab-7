import java.io.*;
import java.util.*;

abstract class User {
    protected String userId;
    protected String username;
    protected String email;
    protected String password;
    protected String userType;

    public User(String userId, String username, String email, String password, String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public abstract boolean authenticate(String username, String password) throws Exception;

    protected List<String[]> readCSV(String fileName) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        return data;
    }
}

