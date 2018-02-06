package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A RNS_CATG_MASTER.
 */
@Entity
@Table(name = "rns_catg_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_CATG_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "c_atgcode")
    private String cATGCODE;

    @Column(name = "c_atgcodedesc")
    private String cATGCODEDESC;

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @OneToMany(mappedBy = "rNS_CATG_MASTER")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RNSREFRMASTER> cATGCODES = new HashSet<>();

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @OneToMany(mappedBy = "rNS_CATG_MASTER")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RNSSECTORMASTER> cATGCODES = new HashSet<>();

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @OneToMany(mappedBy = "rNS_CATG_MASTER")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RNSTYPEMASTER> cATGCODES = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcATGCODE() {
        return cATGCODE;
    }

    public RNS_CATG_MASTER cATGCODE(String cATGCODE) {
        this.cATGCODE = cATGCODE;
        return this;
    }

    public void setcATGCODE(String cATGCODE) {
        this.cATGCODE = cATGCODE;
    }

    public String getcATGCODEDESC() {
        return cATGCODEDESC;
    }

    public RNS_CATG_MASTER cATGCODEDESC(String cATGCODEDESC) {
        this.cATGCODEDESC = cATGCODEDESC;
        return this;
    }

    public void setcATGCODEDESC(String cATGCODEDESC) {
        this.cATGCODEDESC = cATGCODEDESC;
    }

    public Set<RNSREFRMASTER> getCATGCODES() {
        return cATGCODES;
    }

    public RNS_CATG_MASTER cATGCODES(Set<RNSREFRMASTER> rNSREFRMASTERS) {
        this.cATGCODES = rNSREFRMASTERS;
        return this;
    }

    public RNS_CATG_MASTER addCATGCODE(RNSREFRMASTER rNSREFRMASTER) {
        this.cATGCODES.add(rNSREFRMASTER);
        rNSREFRMASTER.setRNS_CATG_MASTER(this);
        return this;
    }

    public RNS_CATG_MASTER removeCATGCODE(RNSREFRMASTER rNSREFRMASTER) {
        this.cATGCODES.remove(rNSREFRMASTER);
        rNSREFRMASTER.setRNS_CATG_MASTER(null);
        return this;
    }

    public void setCATGCODES(Set<RNSREFRMASTER> rNSREFRMASTERS) {
        this.cATGCODES = rNSREFRMASTERS;
    }

    public Set<RNSSECTORMASTER> getCATGCODES() {
        return cATGCODES;
    }

    public RNS_CATG_MASTER cATGCODES(Set<RNSSECTORMASTER> rNSSECTORMASTERS) {
        this.cATGCODES = rNSSECTORMASTERS;
        return this;
    }

    public RNS_CATG_MASTER addCATGCODE(RNSSECTORMASTER rNSSECTORMASTER) {
        this.cATGCODES.add(rNSSECTORMASTER);
        rNSSECTORMASTER.setRNS_CATG_MASTER(this);
        return this;
    }

    public RNS_CATG_MASTER removeCATGCODE(RNSSECTORMASTER rNSSECTORMASTER) {
        this.cATGCODES.remove(rNSSECTORMASTER);
        rNSSECTORMASTER.setRNS_CATG_MASTER(null);
        return this;
    }

    public void setCATGCODES(Set<RNSSECTORMASTER> rNSSECTORMASTERS) {
        this.cATGCODES = rNSSECTORMASTERS;
    }

    public Set<RNSTYPEMASTER> getCATGCODES() {
        return cATGCODES;
    }

    public RNS_CATG_MASTER cATGCODES(Set<RNSTYPEMASTER> rNSTYPEMASTERS) {
        this.cATGCODES = rNSTYPEMASTERS;
        return this;
    }

    public RNS_CATG_MASTER addCATGCODE(RNSTYPEMASTER rNSTYPEMASTER) {
        this.cATGCODES.add(rNSTYPEMASTER);
        rNSTYPEMASTER.setRNS_CATG_MASTER(this);
        return this;
    }

    public RNS_CATG_MASTER removeCATGCODE(RNSTYPEMASTER rNSTYPEMASTER) {
        this.cATGCODES.remove(rNSTYPEMASTER);
        rNSTYPEMASTER.setRNS_CATG_MASTER(null);
        return this;
    }

    public void setCATGCODES(Set<RNSTYPEMASTER> rNSTYPEMASTERS) {
        this.cATGCODES = rNSTYPEMASTERS;
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
        RNS_CATG_MASTER rNS_CATG_MASTER = (RNS_CATG_MASTER) o;
        if (rNS_CATG_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_CATG_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_CATG_MASTER{" +
            "id=" + getId() +
            ", cATGCODE='" + getcATGCODE() + "'" +
            ", cATGCODEDESC='" + getcATGCODEDESC() + "'" +
            "}";
    }
}
