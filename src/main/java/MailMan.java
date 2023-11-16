package src.main.java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailMan {


    /*
    String senderEmail;
    String senderPassword;
    Properties properties;


    public MailMan() {
        senderEmail = "hotelsun380@gmail.com";
        senderPassword = "cdpo sghi ztbh ogfe";
    }
     */

    public static void main(String[] args) {
        // Sender's email address FINAL
        String senderEmail = "hotelsun380@gmail.com";
        // Sender's password FINAL
        String senderPassword = "cdpo sghi ztbh ogfe";

        // Recipient's email address
        String recipientEmail = "mendoza.erik2903@gmail.com";

        // Set the properties for the email server FINAL
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with the properties and an authenticator
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's and recipient's email addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the email subject and body
            message.setSubject("This is your reservation!");
            message.setText("Guest ID: <UUID String>\n" +
                    "Reservation ID: <UUID String>");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    /*

    public void startEmail(Properties properties) {
        Session newSession = createSession(properties, senderEmail, senderPassword);
        Message newMessage = createMessage();
    }

    public Session createSession(Properties properties, String senderEmail, String senderPassword) {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        return session;
    }


    public Message createMessage(Session session) {
        Message message = new MimeMessage(session);

        // Set the sender's and recipient's email addresses
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

        // Set the email subject and body
        message.setSubject("This is your reservation!");
        message.setText("Guest ID: <UUID String>\n" +
                "Reservation ID: <UUID String>");

        // Send the email
        Transport.send(message);

        System.out.println("Email sent successfully!");

    } catch (MessagingException e) {
        e.printStackTrace();
    }

        return message;
    }


    public String mailReservation(Guest guest, Reservation reservation) {
        String recipientEmail = guest.getEmail();

        return "";
    }

    public String mailEdition(Guest guest, Reservation reservation){

        Message message = new MimeMessage(session);
        String recipientEmail = guest.getEmail();

        return "";
    }

    */
}