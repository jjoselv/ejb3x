/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.sesion.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author user
 */
@Stateless(mappedName="ejb/LoginBean")
public class LoginBean implements LoginRemote, LoginLocal {

    @Resource(name = "jms/auditqueue")
    private Queue auditqueue;
    @Resource(name = "jms/auditqueueFactory")
    private ConnectionFactory auditqueueFactory;
    private static final String NOMBRE = "curso";
    private static final String CLAVE = "curso";

    public Boolean login(String nombre, String clave) {
        Boolean r = nombre.equals(NOMBRE) && clave.equals(CLAVE) ? true : false;
        try {
            String s = "El usuario %s %s ha sido autenticado correctamente";
            s = String.format(s, nombre, r ? "" : "no");
            sendJMSMessageToAuditqueue(s);
        } catch (JMSException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    private Message createJMSMessageForjmsAuditqueue(Session session, String messageData) throws JMSException {
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData);
        return tm;
    }

    private void sendJMSMessageToAuditqueue(String messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = auditqueueFactory.createConnection();
            session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(auditqueue);
            messageProducer.send(createJMSMessageForjmsAuditqueue(session, messageData));
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
