/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package curso.ejb3.sesion.stateless;

import curso.ejb3.pojos.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface AutenticarLocal {

    boolean autenticar(Usuario usuario);
    
}
