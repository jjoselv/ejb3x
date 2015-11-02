/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author usuario
 */
@Singleton
public class Repositorio<T> {

    private static final Logger LOG = Logger.getLogger(Repositorio.class.getName());

    private final Map<Long, Future<T>> repo = new HashMap<>();

    public void guardar(final Long id, final Future<T> f) {
        repo.put(id, f);
    }

    @PreDestroy
    private void limpiar() {
        Set<Map.Entry<Long, Future<T>>> entrySet = repo.entrySet();
        for (Map.Entry<Long, Future<T>> entry : entrySet) {
            Future<T> valor = entry.getValue();
            if (valor.isDone() || valor.isCancelled()) {
                repo.remove(entry.getKey());
            }
        }
    }

    public T obtener(final Long id) {
        T r = null;
        try {
            Future<T> f = repo.get(id);
            if (f.isDone()) {
                LOG.log(Level.INFO, "Futuro terminado");
                r = f.get();
                if (r == null) {
                    LOG.log(Level.INFO, "r es nulo");
                }
            } else {
                LOG.log(Level.INFO, "Futuro procesando");
            }
        } catch (InterruptedException | ExecutionException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
