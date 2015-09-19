/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
       
    @Override
    public void nuevo(UsuarioPersistente usuario) {
        em.persist(usuario);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<UsuarioPersistente> todos() {
        return em.createQuery("select u from UsuarioPersistente u").getResultList();
    }
}
