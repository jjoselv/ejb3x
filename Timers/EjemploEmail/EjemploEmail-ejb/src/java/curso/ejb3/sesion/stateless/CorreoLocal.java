/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package curso.ejb3.sesion.stateless;

import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface CorreoLocal {

    void enviar(String destino, String asunto, String cuerpo);
    
}
