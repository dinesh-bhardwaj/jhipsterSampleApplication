package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_PCH_MASTER.
 */
@Entity
@Table(name = "rns_pch_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_PCH_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "p_chcode")
    private String pCHCODE;

    @Column(name = "p_chname")
    private String pCHNAME;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpCHCODE() {
        return pCHCODE;
    }

    public RNS_PCH_MASTER pCHCODE(String pCHCODE) {
        this.pCHCODE = pCHCODE;
        return this;
    }

    public void setpCHCODE(String pCHCODE) {
        this.pCHCODE = pCHCODE;
    }

    public String getpCHNAME() {
        return pCHNAME;
    }

    public RNS_PCH_MASTER pCHNAME(String pCHNAME) {
        this.pCHNAME = pCHNAME;
        return this;
    }

    public void setpCHNAME(String pCHNAME) {
        this.pCHNAME = pCHNAME;
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
        RNS_PCH_MASTER rNS_PCH_MASTER = (RNS_PCH_MASTER) o;
        if (rNS_PCH_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_PCH_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_PCH_MASTER{" +
            "id=" + getId() +
            ", pCHCODE='" + getpCHCODE() + "'" +
            ", pCHNAME='" + getpCHNAME() + "'" +
            "}";
    }
}
