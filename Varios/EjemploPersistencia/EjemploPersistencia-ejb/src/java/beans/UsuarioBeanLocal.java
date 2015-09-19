/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface UsuarioBeanLocal {

    void nuevo(UsuarioPersistente usuario);

    List<UsuarioPersistente> todos();
    
}
