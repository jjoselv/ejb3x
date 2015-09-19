/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transacciones;

import javax.ejb.Local;

/**
 *
 * @author jose maria
 */
@Local
public interface TxBeanBeanLocal {

    String mensaje(String texto);
}
