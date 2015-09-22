/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author jose maria
 */
@Entity
@Access(AccessType.FIELD)
public class ValorDeBolsa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private Double valorActual;
    @Version
    private Integer version;

    /**
     * Get the value of valorActual
     *
     * @return the value of valorActual
     */
    public Double getValorActual() {
        return valorActual;
    }

    /**
     * Set the value of valorActual
     *
     * @param valorActual new value of valorActual
     */
    public void setValorActual(Double valorActual) {
        this.valorActual = valorActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorDeBolsa)) {
            return false;
        }
        ValorDeBolsa other = (ValorDeBolsa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ValorDeBolsa[ id=" + id + " ]";
    }
}
