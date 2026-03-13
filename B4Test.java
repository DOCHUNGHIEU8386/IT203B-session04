import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class B4Test {

    private B4 passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new B4();
    }

    @Test
    void shouldReturnStrongWhenPasswordMeetsAllCriteria() {

        String result = passwordService.evaluatePasswordStrength("Abc123!@");

        assertEquals("Mạnh", result);
    }

    @Test
    void shouldReturnMediumWhenMissingUppercase() {

        String result = passwordService.evaluatePasswordStrength("abc123!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void shouldReturnMediumWhenMissingLowercase() {

        String result = passwordService.evaluatePasswordStrength("ABC123!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void shouldReturnMediumWhenMissingNumber() {

        String result = passwordService.evaluatePasswordStrength("Abcdef!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void shouldReturnMediumWhenMissingSpecialCharacter() {

        String result = passwordService.evaluatePasswordStrength("Abc12345");

        assertEquals("Trung bình", result);
    }

    @Test
    void shouldReturnWeakWhenPasswordTooShort() {

        String result = passwordService.evaluatePasswordStrength("Ab1!");

        assertEquals("Yếu", result);
    }

    @Test
    void shouldReturnWeakWhenOnlyLowercaseLetters() {

        String result = passwordService.evaluatePasswordStrength("password");

        assertEquals("Yếu", result);
    }

    @Test
    void shouldReturnWeakWhenOnlyUppercaseAndNumbers() {

        String result = passwordService.evaluatePasswordStrength("ABC12345");

        assertEquals("Yếu", result);
    }

    @Test
    void shouldEvaluateMultiplePasswordsUsingAssertAll() {

        assertAll(
                () -> assertEquals("Mạnh", passwordService.evaluatePasswordStrength("Abc123!@")),
                () -> assertEquals("Trung bình", passwordService.evaluatePasswordStrength("abc123!@")),
                () -> assertEquals("Yếu", passwordService.evaluatePasswordStrength("Ab1!"))
        );
    }
}