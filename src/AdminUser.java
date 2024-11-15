import java.io.*;
import java.util.*;
class AdminUser extends User implements Readable, Writable, AdminOperations {
    public AdminUser(String userId, String username, String email, String password) {
        super(userId, username, email, password, "Admin");
    }

    @Override
    public boolean authenticate(String username, String password) throws Exception {
        Map<String, String[]> admins = UserManager.getInstance().getAdmins();
        return admins.values().stream()
                .anyMatch(data -> data[1].equals(username) && data[3].equals(password));
    }

    @Override
    public void viewUsers() throws Exception {
        new RegularUser(userId, username, email, password).viewUsers();
    }

    @Override
    public void addUser(String username, String email, String password, String userType) throws Exception {
        new PowerUser(userId, username, email, password).addUser(username, email, password, userType);
    }

    @Override
    public void renameFile(String oldFileName, String newFileName) {
        File oldFile = new File(oldFileName);
        File newFile = new File(newFileName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("File renaming failed.");
        }
    }

    @Override
    public void changePrivileges(String userId, String newPrivilege) throws Exception {
        Map<String, String[]> users = UserManager.getInstance().getUsers();
        if (users.containsKey(userId)) {
            users.get(userId)[4] = newPrivilege;
            UserManager.getInstance().saveUsers();
            System.out.println("Privileges updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
