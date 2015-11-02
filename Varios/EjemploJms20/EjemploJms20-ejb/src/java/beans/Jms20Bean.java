/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import modelo.Persona;

/**
 *
 * @author usuario
 */
@Stateless
@LocalBean
public class Jms20Bean {

    @Resource(lookup = "jms/test")
    private Destination queue;

    @Inject
    private JMSContext jmsContext;

    public String producir() {
        Persona persona = new Persona("abc");

        jmsContext.createProducer().send(queue, persona);

        return "Mensaje enviado";
    }
}
