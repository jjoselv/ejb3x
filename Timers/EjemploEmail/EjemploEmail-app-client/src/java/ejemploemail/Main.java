/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploemail;

import curso.ejb3.sesion.stateless.CorreoRemote;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
public class Main {
    @EJB
    private static CorreoRemote correoBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Intentando enviar mensaje de correo...");
        correoBean.enviar("abc@xyz.com", "Prueba JavaMail", "Mensaje enviado");
        System.out.println("Mensaje enviado.");
    }

}
