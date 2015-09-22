/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transacciones;

import beans.excepciones.MiExcepcion;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author jose maria
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TxContainerBean {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String mensaje(String texto) throws MiExcepcion {
        if (texto.equals("lanza")) {
            throw new MiExcepcion("Test");
        }
        return "El mensaje es " + texto;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
