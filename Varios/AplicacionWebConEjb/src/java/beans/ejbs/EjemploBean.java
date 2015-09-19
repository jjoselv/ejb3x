/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.ejbs;

import beans.constantes.Constantes;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jose maria
 */
@Stateless
@LocalBean
public class EjemploBean {

    @Inject
    private Constantes constantes;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String nombreDeLaEmpresa() {
        return "El nombre de la empresa es " + constantes.getNombreDeLaEmpresa();
    }
}
