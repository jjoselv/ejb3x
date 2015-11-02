/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.jws.WebService;
import javax.inject.Inject;
import modelo.Factura;
import repo.Repositorio;

/**
 *
 * @author usuario
 */
@WebService
@Singleton
public class SoapAsyncWs {

    private static final Logger LOG = Logger.getLogger(SoapAsyncWs.class.getName());

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    @Inject
    private Repositorio<Factura> repo;

    @PreDestroy
    private void limpiar() {
        executorService.shutdown();
    }

    /**
     * Web service operation
     *
     * @param factura
     * @return
     */
    public Long procesarFactura(final Factura factura) {
        factura.setId(System.currentTimeMillis());
        Future<Factura> f = executorService.submit(new Callable<Factura>() {
            @Override
            public Factura call() throws Exception {
                LOG.log(Level.INFO, "Comenzando proceso asíncrono");
                factura.setImporte(factura.getImporte() * 2);
                Thread.sleep(2000L);
                LOG.log(Level.INFO, "Finalizado proceso asíncrono");
                return factura;
            }
        });
        repo.guardar(factura.getId(), f);
        return factura.getId();
    }

    public Factura obtenerFactura(Long id) {
        return repo.obtener(id);
    }
}
