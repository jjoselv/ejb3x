/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.pojos;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Usuario implements Serializable {

    private String usuario;
    private String clave;

    public Usuario() {
    }

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
