/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author khepherer
 */
@Local
public interface EjemploLocalRemotoLocal {

    String metodoLocal(final String texto);
    
}
