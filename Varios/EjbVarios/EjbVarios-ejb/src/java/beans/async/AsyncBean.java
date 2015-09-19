/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.async;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author jose maria
 */
@Singleton
@LocalBean
@Asynchronous
public class AsyncBean {

    public void procesoLento() {
        // El cliente lanza este método sin preocuparse del resultado
        System.out.println("Proceso lento lanzado desde el cliente");
    }

    @Asynchronous  //Esta anotación es opcional. El método "hereda" la que hemos puesto a nivel de clase
    public Future<Long> procesoLento(Integer n) {
        System.out.println("Proceso lento con argumentos lanzado desde el cliente");
        return new AsyncResult<Long>(factorial(n));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Long factorial(Integer n) {
        if (n == 1) {
            return 1L;
        } else {
            return n * factorial(n - 1);
        }
    }
}
