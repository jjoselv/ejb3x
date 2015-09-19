/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.singleton;

import entidades.ValorDeBolsa;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose maria
 */
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonBeanBean {

    @PersistenceContext
    private EntityManager em;
    private ValorDeBolsa valorDeBolsa;

    public Double getValorDeBolsaActual() {
        return valorDeBolsa.getValorActual();
    }

    public synchronized void setValorDeBolsa(Double nuevoValor) {
        valorDeBolsa.setValorActual(nuevoValor);
    }

    @PostConstruct
    private void cargarValorDeBolsa() {
        valorDeBolsa = em.find(ValorDeBolsa.class, 1L, LockModeType.PESSIMISTIC_READ);
    }

    @PreDestroy
    private void actualizarValorDeBolsa() {
        em.lock(valorDeBolsa, LockModeType.PESSIMISTIC_WRITE);
        em.merge(valorDeBolsa);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
