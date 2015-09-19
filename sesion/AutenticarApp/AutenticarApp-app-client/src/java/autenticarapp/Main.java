/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autenticarapp;

import curso.ejb3.pojos.Usuario;
import curso.ejb3.sesion.stateless.AutenticarRemote;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
public class Main {
    @EJB
    private static AutenticarRemote autenticarBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario = new Usuario("curso", "curso");
        System.out.println(autenticarBean.autenticar(usuario) ? "Autenticado" : "No autenticado");
    }

}
