package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_CRM_REQUEST_MASTER.
 */
@Entity
@Table(name = "rns_crm_request_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_CRM_REQUEST_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "c_rmcode")
    private Integer cRMCODE;

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

    public Integer getcRMCODE() {
        return cRMCODE;
    }

    public RNS_CRM_REQUEST_MASTER cRMCODE(Integer cRMCODE) {
        this.cRMCODE = cRMCODE;
        return this;
    }

    public void setcRMCODE(Integer cRMCODE) {
        this.cRMCODE = cRMCODE;
    }

    public String getbUYERCODE() {
        return bUYERCODE;
    }

    public RNS_CRM_REQUEST_MASTER bUYERCODE(String bUYERCODE) {
        this.bUYERCODE = bUYERCODE;
        return this;
    }

    public void setbUYERCODE(String bUYERCODE) {
        this.bUYERCODE = bUYERCODE;
    }

    public String getbUYERNAME() {
        return bUYERNAME;
    }

    public RNS_CRM_REQUEST_MASTER bUYERNAME(String bUYERNAME) {
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
        RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER = (RNS_CRM_REQUEST_MASTER) o;
        if (rNS_CRM_REQUEST_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_CRM_REQUEST_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_CRM_REQUEST_MASTER{" +
            "id=" + getId() +
            ", cRMCODE=" + getcRMCODE() +
            ", bUYERCODE='" + getbUYERCODE() + "'" +
            ", bUYERNAME='" + getbUYERNAME() + "'" +
            "}";
    }
}
