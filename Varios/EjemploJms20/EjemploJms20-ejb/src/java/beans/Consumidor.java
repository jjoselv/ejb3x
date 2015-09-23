/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import modelo.Persona;

/**
 *
 * @author usuario
 */
@MessageDriven(mappedName = "jms/test")
public class Consumidor implements MessageListener {

    @Override
    public void onMessage(Message mensaje) {
        try {
            Persona persona = mensaje.getBody(Persona.class);
            System.out.println("Recibido: " + persona);
        } catch (JMSException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
