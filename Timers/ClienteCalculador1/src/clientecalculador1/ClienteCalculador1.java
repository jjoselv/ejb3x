/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecalculador1;

/**
 *
 * @author usuario
 */
public class ClienteCalculador1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("La suma es " + suma(3,4));
    }

    private static int suma(int i, int j) {
        ws.CalculadorWSService service = new ws.CalculadorWSService();
        ws.CalculadorWS port = service.getCalculadorWSPort();
        return port.suma(i, j);
    }
    
}
