/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package curso.ejb3.sesion.stateless;

import curso.ejb3.pojos.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless
public class AutenticarBean implements AutenticarRemote, AutenticarLocal {

    public boolean autenticar(Usuario usuario) {
        if (usuario.getUsuario().equals("curso") && usuario.getClave().equals("curso")) {
            return true;
        } else {
            return false;
        }

    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
