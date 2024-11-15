import java.io.*;
import java.util.*;
class PowerUser extends User implements Readable, Writable {
    public PowerUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Power");
    }

    @Override
    public boolean authenticate(String username, String password) throws Exception {
        Map<String, String[]> users = UserManager.getInstance().getUsers();
        return users.values().stream()
                .anyMatch(data -> data[1].equals(username) && data[3].equals(password) && data[4].equals("Power"));
    }

    @Override
    public void viewUsers() throws Exception {
        new RegularUser(userId, username, email, password).viewUsers();
    }

    @Override
    public void addUser(String username, String email, String password, String userType) throws Exception {
        String userId = UUID.randomUUID().toString();
        String[] newUser = {userId, username, email, password, userType};
        UserManager.getInstance().getUsers().put(userId, newUser);
        UserManager.getInstance().saveUsers();
        System.out.println("User added successfully.");
    }
}

