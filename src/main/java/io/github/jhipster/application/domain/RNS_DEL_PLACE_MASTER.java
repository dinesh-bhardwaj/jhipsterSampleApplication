package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_DEL_PLACE_MASTER.
 */
@Entity
@Table(name = "rns_del_place_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_DEL_PLACE_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "c_ode")
    private String cODE;

    @Column(name = "c_odedesc")
    private String cODEDESC;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcODE() {
        return cODE;
    }

    public RNS_DEL_PLACE_MASTER cODE(String cODE) {
        this.cODE = cODE;
        return this;
    }

    public void setcODE(String cODE) {
        this.cODE = cODE;
    }

    public String getcODEDESC() {
        return cODEDESC;
    }

    public RNS_DEL_PLACE_MASTER cODEDESC(String cODEDESC) {
        this.cODEDESC = cODEDESC;
        return this;
    }

    public void setcODEDESC(String cODEDESC) {
        this.cODEDESC = cODEDESC;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER = (RNS_DEL_PLACE_MASTER) o;
        if (rNS_DEL_PLACE_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_DEL_PLACE_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_DEL_PLACE_MASTER{" +
            "id=" + getId() +
            ", cODE='" + getcODE() + "'" +
            ", cODEDESC='" + getcODEDESC() + "'" +
            "}";
    }
}
