package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_TYPE_MASTER.
 */
@Entity
@Table(name = "rns_type_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_TYPE_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "r_nscatgcode")
    private String rNSCATGCODE;

    @Column(name = "t_ypecode")
    private String tYPECODE;

    @Column(name = "t_ypecodedesc")
    private String tYPECODEDESC;

    @ManyToOne
    private RNSCATGMASTER rNSCATGMASTER;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getrNSCATGCODE() {
        return rNSCATGCODE;
    }

    public RNS_TYPE_MASTER rNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
        return this;
    }

    public void setrNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
    }

    public String gettYPECODE() {
        return tYPECODE;
    }

    public RNS_TYPE_MASTER tYPECODE(String tYPECODE) {
        this.tYPECODE = tYPECODE;
        return this;
    }

    public void settYPECODE(String tYPECODE) {
        this.tYPECODE = tYPECODE;
    }

    public String gettYPECODEDESC() {
        return tYPECODEDESC;
    }

    public RNS_TYPE_MASTER tYPECODEDESC(String tYPECODEDESC) {
        this.tYPECODEDESC = tYPECODEDESC;
        return this;
    }

    public void settYPECODEDESC(String tYPECODEDESC) {
        this.tYPECODEDESC = tYPECODEDESC;
    }

    public RNSCATGMASTER getRNSCATGMASTER() {
        return rNSCATGMASTER;
    }

    public RNS_TYPE_MASTER rNSCATGMASTER(RNSCATGMASTER rNSCATGMASTER) {
        this.rNSCATGMASTER = rNSCATGMASTER;
        return this;
    }

    public void setRNSCATGMASTER(RNSCATGMASTER rNSCATGMASTER) {
        this.rNSCATGMASTER = rNSCATGMASTER;
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
        RNS_TYPE_MASTER rNS_TYPE_MASTER = (RNS_TYPE_MASTER) o;
        if (rNS_TYPE_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_TYPE_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_TYPE_MASTER{" +
            "id=" + getId() +
            ", rNSCATGCODE='" + getrNSCATGCODE() + "'" +
            ", tYPECODE='" + gettYPECODE() + "'" +
            ", tYPECODEDESC='" + gettYPECODEDESC() + "'" +
            "}";
    }
}
