/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosimple;

import java.util.List;
import javax.ejb.EJB;
import pojos.Usuario;
import stateless.SimpleRemote;

/**
 *
 * @author Chema
 */
public class Main {

    @EJB
    private static SimpleRemote simpleBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario = simpleBean.guardarUsuario(new Usuario("uno", "uno"));
        System.out.println("Guardado " + usuario);
        System.out.println("Actualizando el nombre del usuario a dos");
        usuario.setNombre("dos");
        simpleBean.actualizarUsuario(usuario);
        mostrarUsuarios();
        System.out.println("Borrando usuario con clave " + usuario.getId());
        simpleBean.borrarUsuario(usuario);
        mostrarUsuarios();
    }

    private static void mostrarUsuarios() {
        System.out.println("Usuarios en la base de datos:");
        List<Usuario> usuarios = simpleBean.getUsuarios();
        if (usuarios.size() == 0) {
            System.out.println("No se encuentran usuarios");
        } else {
            for (Usuario u : simpleBean.getUsuarios()) {
                System.out.println(u);
            }
        }

    }
}
