package classes;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void sendConfirmationTest() {
        Email email = new Email("usuario1@gmail.com", "Usuario", "132343");
        email.sendConfirmation();
    }
}