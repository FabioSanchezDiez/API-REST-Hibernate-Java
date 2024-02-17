package emails;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void sendConfirmationTest() {
        Email email = new Email("usuario1@gmail.com", "Usuario", "132343");
        email.sendConfirmation();
    }
}