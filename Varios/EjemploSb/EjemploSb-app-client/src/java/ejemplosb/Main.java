/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosb;

import curso.ejb3.sesion.stateful.ContadorRemote;
import curso.ejb3.sesion.stateless.LoginRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author user
 */
public class Main {

    @EJB(mappedName = "ejb/ContadorBean")
    private static ContadorRemote contadorBean;
    @EJB(mappedName = "ejb/LoginBean")
    private static LoginRemote loginBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean r = loginBean.login("curso", "curso");
        System.out.println("Usuario " + (r ? "Autenticado" : "No Autenticado"));
        try {
            LoginRemote[] col = new LoginRemote[2];
            Context ctx = new InitialContext();
            for (int i = 0; i < col.length; i++) {
                col[i] = (LoginRemote) ctx.lookup("ejb/LoginBean");
            }
            for (int i = 0; i < col.length; i++) {
                System.out.println("Bean de sesión sin estado número " + i + col[i].toString());
            }
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        contadorBean.setValor(10);
        System.out.println("El valor actual es " + contadorBean.getValor());
        try {
            // TODO code application logic here
            ContadorRemote[] col = new ContadorRemote[2];
            Context ctx = new InitialContext();
            for (int i = 0; i < col.length; i++) {
                col[i] = (ContadorRemote) ctx.lookup("ejb/ContadorBean");
                col[i].setValor((i + 1) * 10);
            }
            for (int i = 0; i < col.length; i++) {
                System.out.println("Bean de sesión con estado número " + i + col[i].toString());
            }
            
            for (int i = 0; i < col.length; i++) {
                System.out.println("Valor del bean de sesión con estado número " + i + col[i].getValor());
            }
            
            for (int i = 0; i < col.length; i++) {
                col[i].remove();
                System.out.println("Eliminado bean de sesión con estado número " + i);
            }
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
