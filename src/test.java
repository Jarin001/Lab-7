import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    private RegularUser regularUser;

    @BeforeEach
    public void setUp1() {
        // Setup a mock RegularUser
        regularUser = new RegularUser("1", "user1", "user1@example.com", "password1");
    }

    @Test
    public void testRegularUserAuthentication() {
        // Test that a regular user can authenticate with correct credentials
        assertDoesNotThrow(() -> regularUser.authenticate("user1", "password1"));
    }

    @Test
    public void testRegularUserAuthenticationFail() {
        // Test that authentication fails with incorrect credentials
        Exception exception = assertThrows(Exception.class, () -> {
            regularUser.authenticate("user1", "wrongPassword");
        });
        assertEquals("Authentication failed for Regular user.", exception.getMessage());
    }

    @Test
    public void testViewUsers1() {
        // Mock data should allow user viewing
        assertDoesNotThrow(() -> regularUser.viewUsers());
    }

        private PowerUser powerUser;

        @BeforeEach
        public void setUp2() {
            // Setup a mock PowerUser
            powerUser = new PowerUser("2", "power1", "power1@example.com", "password2");
        }

        @Test
        public void testPowerUserAuthentication() {
            // Test that a power user can authenticate with correct credentials
            assertDoesNotThrow(() -> powerUser.authenticate("power1", "password2"));
        }

        @Test
        public void testAddUser1() {
            // Test adding a user
            assertDoesNotThrow(() -> powerUser.addUser("newUser", "new@example.com", "newPassword", "Regular"));
        }

        @Test
        public void testViewUsers2() {
            // Test viewing users
            assertDoesNotThrow(() -> powerUser.viewUsers());
        }

        private AdminUser adminUser;

        @BeforeEach
        public void setUp3() {
            // Setup a mock AdminUser
            adminUser = new AdminUser("3", "admin1", "admin1@example.com", "adminPassword");
        }

        @Test
        public void testAdminUserAuthentication() {
            // Test that an admin user can authenticate with correct credentials
            assertDoesNotThrow(() -> adminUser.authenticate("admin1", "adminPassword"));
        }

        @Test
        public void testRenameFile() {
            // Test renaming a file
            assertDoesNotThrow(() -> adminUser.renameFile("User.csv", "User_backup.csv"));
        }

        @Test
        public void testChangePrivileges() {
            // Test changing user privileges
            assertDoesNotThrow(() -> adminUser.changePrivileges("1", "Power"));
        }

        @Test
        public void testAddUser2() {
            // Test adding a user as admin
            assertDoesNotThrow(() -> adminUser.addUser("newAdmin", "admin@example.com", "adminPass", "Admin"));
        }

}

