/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package curso.ejb3.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author user
 */
@MessageDriven(mappedName = "jms/auditqueue", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class AuditorBeanBean implements MessageListener {
    
    public AuditorBeanBean() {
    }

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("Mensaje recibido: " + tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(AuditorBeanBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
