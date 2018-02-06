package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_BUYER_MASTER.
 */
@Entity
@Table(name = "rns_buyer_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_BUYER_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "b_uyercode")
    private String bUYERCODE;

    @Column(name = "b_uyername")
    private String bUYERNAME;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getbUYERCODE() {
        return bUYERCODE;
    }

    public RNS_BUYER_MASTER bUYERCODE(String bUYERCODE) {
        this.bUYERCODE = bUYERCODE;
        return this;
    }

    public void setbUYERCODE(String bUYERCODE) {
        this.bUYERCODE = bUYERCODE;
    }

    public String getbUYERNAME() {
        return bUYERNAME;
    }

    public RNS_BUYER_MASTER bUYERNAME(String bUYERNAME) {
        this.bUYERNAME = bUYERNAME;
        return this;
    }

    public void setbUYERNAME(String bUYERNAME) {
        this.bUYERNAME = bUYERNAME;
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
        RNS_BUYER_MASTER rNS_BUYER_MASTER = (RNS_BUYER_MASTER) o;
        if (rNS_BUYER_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_BUYER_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_BUYER_MASTER{" +
            "id=" + getId() +
            ", bUYERCODE='" + getbUYERCODE() + "'" +
            ", bUYERNAME='" + getbUYERNAME() + "'" +
            "}";
    }
}
