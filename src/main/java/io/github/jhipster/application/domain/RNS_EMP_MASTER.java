package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_EMP_MASTER.
 */
@Entity
@Table(name = "rns_emp_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_EMP_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "e_mpcode")
    private String eMPCODE;

    @Column(name = "e_mpname")
    private String eMPNAME;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteMPCODE() {
        return eMPCODE;
    }

    public RNS_EMP_MASTER eMPCODE(String eMPCODE) {
        this.eMPCODE = eMPCODE;
        return this;
    }

    public void seteMPCODE(String eMPCODE) {
        this.eMPCODE = eMPCODE;
    }

    public String geteMPNAME() {
        return eMPNAME;
    }

    public RNS_EMP_MASTER eMPNAME(String eMPNAME) {
        this.eMPNAME = eMPNAME;
        return this;
    }

    public void seteMPNAME(String eMPNAME) {
        this.eMPNAME = eMPNAME;
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
        RNS_EMP_MASTER rNS_EMP_MASTER = (RNS_EMP_MASTER) o;
        if (rNS_EMP_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_EMP_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_EMP_MASTER{" +
            "id=" + getId() +
            ", eMPCODE='" + geteMPCODE() + "'" +
            ", eMPNAME='" + geteMPNAME() + "'" +
            "}";
    }
}
