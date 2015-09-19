/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package curso.ejb3.sesion.stateful;

import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface ContadorRemote {

    Integer getValor();

    void setValor(Integer valor);
    
    public void remove();
}
