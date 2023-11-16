package src.main.java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class MailMan {

    private final String senderEmail;
    private final String senderPassword;
    private final Properties properties;


    public MailMan() {
        senderEmail = "hotelsun380@gmail.com";
        senderPassword = "cdpo sghi ztbh ogfe";
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
    }

    public static void main(String[] args) {

        // this is a temporary main method tester.
        // change the Guest information to test your own email.
        MailMan mailman = new MailMan();
        Guest guest = new Guest("Erik Mendoza",
                "mendoza.erik2903@gmail.com",
                "8182137221", "fakeaddress123");
        Reservation reservation = new Reservation(guest.getId(), 101,
                new Date(2023, Calendar.NOVEMBER, 29, 6, 30),
                new Date(2023, Calendar.DECEMBER, 3, 6, 30));
        mailman.sendEmail(mailman.properties, 1, guest, reservation);
    }


    public void sendEmail(Properties properties, int mailCode, Guest guest, Reservation reservation) {
        Session newSession = createSession(properties, senderEmail, senderPassword);
        Message newMessage = createMessage(newSession, mailCode, guest, reservation);
    }

    private Session createSession(Properties properties, String senderEmail, String senderPassword) {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        return session;
    }


    private Message createMessage(Session session, int mailCode, Guest guest, Reservation reservation) {
        try {

            Message message = new MimeMessage(session);

            // Set the sender's and recipient's email addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(guest.getEmail()));

            // Set the email subject and body
            // We can edit this code to change the email contents
            if (mailCode == 1) {
                message.setSubject("This is your new reservation!");
            } else if (mailCode == 2) {
                message.setSubject("Your reservation has changed!");
            }
            message.setText(guest.getName() + ", here are your reservation details below.\n\n" +
                    "Guest ID: " + reservation.getGuestID() + "\n" +
                    "Reservation ID: " + reservation.getReservationID() + "\n" +
                    "Date of Reservation: " + reservation.getCheckIn() + "\n" +
                    "\tup until " + reservation.getCheckOut() + ".");


            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");
            return message;
        } catch (MessagingException e) {
        e.printStackTrace();
    }
        return null;
    }

}