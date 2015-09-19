/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.sesion.stateless;

import curso.ejb3.aop.interceptors.DemoInterceptor;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

/**
 *
 * @author user
 */
@Stateless
@Interceptors({DemoInterceptor.class})
public class TimerDemoBean implements TimerDemoRemote, TimerDemoLocal {

    @Resource
    private SessionContext contexto;

    public void activarTimer() {
        TimerService ts = contexto.getTimerService();
        Timer timer = ts.createTimer(5000L, 1000L, "Un argumento");
        System.out.println("Timer " + timer.toString() + " creado.");
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")

    @Timeout    
    public void invocacionTimeout(Timer timer) {
        System.out.println("Método \"invocacionTimeout\" invocado");
        System.out.println("Desde el timer " + timer.toString());
        System.out.println("Con el argumento " + timer.getInfo().toString());
    }
    @AroundInvoke
    public Object check(InvocationContext inv) throws Exception{
        if(inv.getMethod().getName().equals("activarTimer")){
            System.out.println("Interceptada una llamada al método \"activarTimer\" desde dentro de la clase \"TimerDemoBean\"");
        }
        return inv.proceed();
    }
}
