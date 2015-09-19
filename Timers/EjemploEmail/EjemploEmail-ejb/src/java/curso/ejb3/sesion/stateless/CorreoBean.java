/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.sesion.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

/**
 *
 * @author user
 */
@Stateless
public class CorreoBean implements CorreoRemote, CorreoLocal {

    @Resource(name = "demo")
    private Session demo;
    private Session interior;

    public void enviar(String destino, String asunto, String cuerpo) {
        interior = demo.getInstance(demo.getProperties(), new SMTPAuthenticator());
        try {
            sendMail(destino,asunto,cuerpo);
        } catch (NamingException ex) {
            Logger.getLogger(CorreoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(CorreoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        MimeMessage message = new MimeMessage(interior);
        message.setSubject(subject);
        message.setRecipients(javax.mail.Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(email, false));
        message.setText(body);
        javax.mail.Transport.send(message);
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username = "un nombre";
            String password = "una clave";
            return new PasswordAuthentication(username, password);
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
