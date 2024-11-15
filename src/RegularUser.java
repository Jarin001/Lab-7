import java.io.*;
import java.util.*;
class RegularUser extends User implements Readable {
    public RegularUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Regular");
    }

    @Override
    public boolean authenticate(String username, String password) throws Exception {
        Map<String, String[]> users = UserManager.getInstance().getUsers();
        return users.values().stream()
                .anyMatch(data -> data[1].equals(username) && data[3].equals(password) && data[4].equals("Regular"));
    }

    @Override
    public void viewUsers() throws Exception {
        Map<String, String[]> users = UserManager.getInstance().getUsers();
        users.values().forEach(data -> System.out.println(Arrays.toString(data)));
    }
}

