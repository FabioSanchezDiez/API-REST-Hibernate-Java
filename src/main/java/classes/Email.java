package classes;

import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private String email;
    private String name;
    private String token;

    private final String EMAIL_HOST;
    private final String EMAIL_PORT;
    private final String EMAIL_USER;
    private final String EMAIL_PASS;

    private static final Dotenv dotenv = Dotenv.load();

    public Email(String email, String name, String token) {
        this.email = email;
        this.name = name;
        this.token = token;

        EMAIL_HOST = dotenv.get("EMAIL_HOST");
        EMAIL_PORT = dotenv.get("EMAIL_PORT");
        EMAIL_USER = dotenv.get("EMAIL_USER");
        EMAIL_PASS = dotenv.get("EMAIL_PASS");
    }

    public void sendConfirmation(){

        // Set up SMTP settings
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.port", EMAIL_PORT);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USER, EMAIL_PASS);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("accounts@fabiocode.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.email));
            message.setSubject("Confirma tu cuenta en FabioCode Academy");
            message.setContent(createBody(), "text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String createBody(){
        return "<html>\n" +
                "<style>\n" +
                "@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@500;700&display=swap');\n" +
                "h2 {\n" +
                "    font-size: 25px;\n" +
                "    font-weight: 500;\n" +
                "    line-height: 25px;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    background-color: #ffffff;\n" +
                "    max-width: 400px;\n" +
                "    margin: 0 auto;\n" +
                "    padding: 20px;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "    line-height: 18px;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "    position: relative;\n" +
                "    z-index: 0;\n" +
                "    display: inline-block;\n" +
                "    margin: 20px 0;\n" +
                "}\n" +
                "\n" +
                "a button {\n" +
                "    padding: 0.7em 2em;\n" +
                "    font-size: 16px !important;\n" +
                "    font-weight: 500;\n" +
                "    background: #000000;\n" +
                "    color: #ffffff;\n" +
                "    border: none;\n" +
                "    text-transform: uppercase;\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                "p span {\n" +
                "    font-size: 12px;\n" +
                "}\n" +
                "div p{\n" +
                "    border-bottom: 1px solid #000000;\n" +
                "    border-top: none;\n" +
                "    margin-top: 40px;\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n" +
                "    <h1>FabioCode - Academy</h1>\n" +
                "    <h2>Gracias por registrarte "+ this.name+ "!</h2>\n" +
                "    <p>Por favor confirma tu correo electronico para que puedas comenzar a utilizar tu cuenta en FabioCode Academy</p>\n" +
                "    <a href='"+"http://127.0.0.1:5500/verification.html?token="+ this.token +"'><button>Verificar</button></a>\n" +
        "    <p>Si tu no te registraste, por favor ignora este correo electrónico.</p>\n" +
                "    <div><p></p></div>\n" +
                "    <p><span>Este correo electronico fue enviado desde una dirección solamente de notificaciones que no puede aceptar correo electronico entrante. Por favor no respondas a este mensaje.</span></p>\n" +
                "</body>\n" +
                "</html>";
    }
}
