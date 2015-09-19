/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotimer;

import curso.ejb3.sesion.stateless.TimerDemoRemote;
import javax.ejb.EJB;

/**
 *
 * @author user
 */
public class Main {
    @EJB
    private static TimerDemoRemote timerDemoBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Intentando activar timer...");
        timerDemoBean.activarTimer();
    }
}
