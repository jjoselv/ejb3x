/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.util.List;
import javax.ejb.Remote;
import pojos.Usuario;

/**
 *
 * @author Chema
 */
@Remote
public interface SimpleRemote {

    Usuario guardarUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);

    Usuario borrarUsuario(Usuario usuario);

    List<Usuario> getUsuarios();
}
