import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class B1Test {
    @Test
    void TC01_validUsername(){
        // arrange
        B1 validator = new B1();
        String username = "user123";
        // act
        boolean result = validator.isValidUsername(username);
        // assert
        assertTrue(result);
    }
    @Test
    void TC02_usernameTooShort(){
        // arrange
        B1 validator = new B1();
        String username = "user";
        // act
        boolean result = validator.isValidUsername(username);
        // assert
        assertFalse(result);
    }
    @Test
    void TC03_usernameContainsSpace(){
        // arrange
        B1 validator = new B1();
        String username = "user name";
        // act
        boolean result = validator.isValidUsername(username);
        // assert
        assertFalse(result);
    }
}
