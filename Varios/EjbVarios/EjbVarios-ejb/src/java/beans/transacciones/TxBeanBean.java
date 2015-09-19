/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transacciones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author jose maria
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TxBeanBean implements TxBeanBeanLocal {

    @Resource
    private UserTransaction transaction;

    @Override
    public String mensaje(String texto) {
        try {
            transaction.begin();
            if (texto.equals("rollback")) {
                transaction.rollback();
                //transaction.setRollbackOnly();
            } else {
                transaction.commit();
            }
        } catch (NotSupportedException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (SystemException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (IllegalStateException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (SecurityException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (RollbackException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (HeuristicMixedException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        } catch (HeuristicRollbackException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, e.toString());
        }
        return "El mensaje es " + texto;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
