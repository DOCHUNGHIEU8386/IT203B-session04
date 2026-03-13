import btth.User;
import btth.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BTTHTest {

    private UserService userService;

    @BeforeEach
    void setUp() {

        // Arrange
        userService = new UserService();
    }

    @Test
    void shouldAddUserSuccessfully() {

        // Arrange
        User user = new User(1, "john", "john@gmail.com");

        // Act
        userService.addUser(user);

        // Assert
        assertEquals(1, userService.getUserCount());
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsNull() {

        // Arrange
        User user = new User(2, null, "test@gmail.com");

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(user);
        });
    }

    @Test
    void shouldReturnNullWhenUserNotFound() {

        // Arrange
        User user = new User(1, "john", "john@gmail.com");
        userService.addUser(user);

        // Act
        User result = userService.findUserById(99);

        // Assert
        assertNull(result);
    }

    @Test
    void shouldReturnTrueWhenEmailIsValid() {

        // Arrange
        String email = "test@gmail.com";

        // Act
        boolean result = userService.isValidEmail(email);

        // Assert
        assertTrue(result);
    }
}