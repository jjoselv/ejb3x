/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.singleton;

import entidades.ComunidadAutonoma;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose maria
 */
@Singleton
@LocalBean
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class SingletonBeanContainer {

    @PersistenceContext
    private EntityManager em;
    private List<ComunidadAutonoma> comunidadAutonomas;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    private void cargarComunidadesAutonomas() {
        comunidadAutonomas = Collections.unmodifiableList(em.createNamedQuery("ComunidadAutonoma.findAll").getResultList());
    }

    @Lock(LockType.READ) //Esta anotación también puede colocarse a nivel de clase
    // @Lock(LockType.WRITE) Todos los métodos públicos del bean quedan bloqueados mientras un cliente
    // ejecuta este método
    public List<ComunidadAutonoma> getComunidadAutonomas() {
        return comunidadAutonomas;
    }
}
