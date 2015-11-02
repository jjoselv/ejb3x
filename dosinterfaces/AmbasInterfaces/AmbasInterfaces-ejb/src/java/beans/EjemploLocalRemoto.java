/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author khepherer
 */
@Stateless
public class EjemploLocalRemoto implements EjemploLocalRemotoRemote, EjemploLocalRemotoLocal {

    @Override
    public String metodoLocal(final String texto) {
        return "En metodoLocal. Recibido: " + texto;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String metodoRemoto(final String texto) {
        return "En metodoRemoto. Recibido: " + texto;
    }
    
}
