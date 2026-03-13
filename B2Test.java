import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class B2Test {
    @Test
    void TC01_age18_valid(){
        B2 service = new B2();
        int age = 18;
        boolean result = service.checkRegistrationAge(age);
        assertEquals(true , result);
    }
    @Test
    void TC02_age17_invalid(){
        B2 service = new B2();
        int age = 17;
        boolean result = service.checkRegistrationAge(age);
        assertEquals(false , result);
    }
    @Test
    void TC03_negativeAge_exception(){
        B2 service = new B2();
        int age = -1;
        boolean result = service.checkRegistrationAge(age);
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}
