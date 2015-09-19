/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.sesion.stateless;

import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface LoginRemote {

    Boolean login(String nombre, String clave);
}
