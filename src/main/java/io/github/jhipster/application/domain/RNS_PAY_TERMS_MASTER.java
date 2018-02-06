package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_PAY_TERMS_MASTER.
 */
@Entity
@Table(name = "rns_pay_terms_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_PAY_TERMS_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "p_aytermscode")
    private String pAYTERMSCODE;

    @Column(name = "p_aytermscodedesc")
    private String pAYTERMSCODEDESC;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpAYTERMSCODE() {
        return pAYTERMSCODE;
    }

    public RNS_PAY_TERMS_MASTER pAYTERMSCODE(String pAYTERMSCODE) {
        this.pAYTERMSCODE = pAYTERMSCODE;
        return this;
    }

    public void setpAYTERMSCODE(String pAYTERMSCODE) {
        this.pAYTERMSCODE = pAYTERMSCODE;
    }

    public String getpAYTERMSCODEDESC() {
        return pAYTERMSCODEDESC;
    }

    public RNS_PAY_TERMS_MASTER pAYTERMSCODEDESC(String pAYTERMSCODEDESC) {
        this.pAYTERMSCODEDESC = pAYTERMSCODEDESC;
        return this;
    }

    public void setpAYTERMSCODEDESC(String pAYTERMSCODEDESC) {
        this.pAYTERMSCODEDESC = pAYTERMSCODEDESC;
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
        RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER = (RNS_PAY_TERMS_MASTER) o;
        if (rNS_PAY_TERMS_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_PAY_TERMS_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_PAY_TERMS_MASTER{" +
            "id=" + getId() +
            ", pAYTERMSCODE='" + getpAYTERMSCODE() + "'" +
            ", pAYTERMSCODEDESC='" + getpAYTERMSCODEDESC() + "'" +
            "}";
    }
}
