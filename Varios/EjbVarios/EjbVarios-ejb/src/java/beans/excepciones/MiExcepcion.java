/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author jose maria
 */
@ApplicationException(rollback = true)
public class MiExcepcion extends Exception {

    /**
     * Creates a new instance of
     * <code>MiExcepcion</code> without detail message.
     */
    public MiExcepcion() {
    }

    /**
     * Constructs an instance of
     * <code>MiExcepcion</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MiExcepcion(String msg) {
        super(msg);
    }
}
