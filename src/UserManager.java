import java.io.*;
import java.util.*;

class UserManager {
    private static UserManager instance;
    private static final String USER_FILE = "User.csv";
    private static final String ADMIN_FILE = "Admin.csv";
    private Map<String, String[]> users = new HashMap<>();
    private Map<String, String[]> admins = new HashMap<>();

    private UserManager() {
        loadUsers();
        loadAdmins();
    }

    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                users.put(data[0], data);
            }
        } catch (IOException e) {
            System.out.println("Error loading User.csv: " + e.getMessage());
        }
    }

    private void loadAdmins() {
        try (BufferedReader br = new BufferedReader(new FileReader(ADMIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                admins.put(data[0], data);
            }
        } catch (IOException e) {
            System.out.println("Error loading Admin.csv: " + e.getMessage());
        }
    }

    public Map<String, String[]> getUsers() {
        return users;
    }

    public Map<String, String[]> getAdmins() {
        return admins;
    }

    public void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (String[] userData : users.values()) {
                bw.write(String.join(",", userData) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving User.csv: " + e.getMessage());
        }
    }
}
