/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pojos.Usuario;

/**
 *
 * @author Chema
 */
@Stateless
public class SimpleBean implements SimpleRemote {

    @PersistenceContext
    private EntityManager em;

    public Usuario guardarUsuario(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return em.merge(usuario);
    }

    public Usuario borrarUsuario(Usuario usuario) {
        Usuario u = em.find(Usuario.class, usuario.getId());
        em.remove(u);
        return u;
    }

    public List<Usuario> getUsuarios() {
        return em.createQuery("select u from Usuario u").getResultList();
    }    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
