/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.timer;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;

/**
 *
 * @author jose maria
 */
@Stateless
@LocalBean
public class TimerBean {

    @Schedule(dayOfWeek = "Sun", hour = "0")
    public void realizarProcesoBatchCadaDomingo() {
    }

    @Schedule(minute = "*/5", hour = "*")
    public void realizarProcesoBatchCadaCincoMinutos() {
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
