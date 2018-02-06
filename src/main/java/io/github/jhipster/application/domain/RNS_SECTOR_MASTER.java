package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_SECTOR_MASTER.
 */
@Entity
@Table(name = "rns_sector_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_SECTOR_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "r_nscatgcode")
    private String rNSCATGCODE;

    @Column(name = "s_ectorcode")
    private String sECTORCODE;

    @Column(name = "s_ectorcodedesc")
    private String sECTORCODEDESC;

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

    public RNS_SECTOR_MASTER rNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
        return this;
    }

    public void setrNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
    }

    public String getsECTORCODE() {
        return sECTORCODE;
    }

    public RNS_SECTOR_MASTER sECTORCODE(String sECTORCODE) {
        this.sECTORCODE = sECTORCODE;
        return this;
    }

    public void setsECTORCODE(String sECTORCODE) {
        this.sECTORCODE = sECTORCODE;
    }

    public String getsECTORCODEDESC() {
        return sECTORCODEDESC;
    }

    public RNS_SECTOR_MASTER sECTORCODEDESC(String sECTORCODEDESC) {
        this.sECTORCODEDESC = sECTORCODEDESC;
        return this;
    }

    public void setsECTORCODEDESC(String sECTORCODEDESC) {
        this.sECTORCODEDESC = sECTORCODEDESC;
    }

    public RNSCATGMASTER getRNSCATGMASTER() {
        return rNSCATGMASTER;
    }

    public RNS_SECTOR_MASTER rNSCATGMASTER(RNSCATGMASTER rNSCATGMASTER) {
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
        RNS_SECTOR_MASTER rNS_SECTOR_MASTER = (RNS_SECTOR_MASTER) o;
        if (rNS_SECTOR_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_SECTOR_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_SECTOR_MASTER{" +
            "id=" + getId() +
            ", rNSCATGCODE='" + getrNSCATGCODE() + "'" +
            ", sECTORCODE='" + getsECTORCODE() + "'" +
            ", sECTORCODEDESC='" + getsECTORCODEDESC() + "'" +
            "}";
    }
}
