/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ejb3.sesion.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author user
 */
@Stateful(mappedName = "ejb/ContadorBean")
public class ContadorBean implements ContadorRemote, ContadorLocal {

    private Integer valor;

    public Integer getValor() {
        return ++valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @PostConstruct
    void postConstruct(){
        System.out.println("Método postconstruct invocado");
    }

    @PreDestroy
    void preDestroy(){
        System.out.println("Método preDestroy invocado");
    }
    @PrePassivate
    void prePassivate(){
        System.out.println("Método prePassivate invocado");        
    }
    @PostActivate
    void postActivate(){
        System.out.println("Método postActivate invocado");                
    }
    @Remove
    public void remove(){
        System.out.println("Método remove invocado");                        
    }
}
