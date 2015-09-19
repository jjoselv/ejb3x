/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.aop.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author user
 */
public class DemoInterceptor {
    @AroundInvoke
    public Object metodoInterceptor(InvocationContext inv) throws Exception {
        System.out.println("Se va a ejecutar el método " + inv.getMethod().getName());
        return inv.proceed();
    }
}
