/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesoapasync;

import cliente.Factura;
import cliente.SoapAsyncWs;
import cliente.SoapAsyncWsService;

/**
 *
 * @author usuario
 */
public class ClienteSoapAsync {

    private final SoapAsyncWs port = new SoapAsyncWsService().getSoapAsyncWsPort();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteSoapAsync cliente = new ClienteSoapAsync();
        Factura f = new Factura();
        f.setImporte(1000d);
        Long id = cliente.port.procesarFactura(f);
        System.out.println("Procesando factura con id " + id);
        System.out.println("Simulando el hilo principal...");
        Factura procesada = null;
        while ((procesada = cliente.port.obtenerFactura(id)) == null) {
            System.out.println("Esperando...");
        }
        System.out.println("Se ha procesado la factura " + procesada.getId());
        System.out.println("El nuevo importe es " + procesada.getImporte());
    }
}
