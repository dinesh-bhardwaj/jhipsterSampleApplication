package io.github.jhipster.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A RNS_REFR_DETAILS.
 */
@Entity
@Table(name = "rns_refr_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_REFR_DETAILS implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "r_efrid")
    private String rEFRID;

    @Column(name = "s_ubcode")
    private String sUBCODE;

    @Column(name = "s_ubcodedesc")
    private String sUBCODEDESC;

    @Column(name = "s_tatus")
    private String sTATUS;

    @Column(name = "c_reatedby")
    private String cREATEDBY;

    @Column(name = "c_reateddate")
    private Instant cREATEDDATE;

    @Column(name = "l_astmodifiedby")
    private String lASTMODIFIEDBY;

    @Column(name = "l_astmodifieddate")
    private Instant lASTMODIFIEDDATE;

    /**
     * Another side of the same relationship
     */
    @ApiModelProperty(value = "Another side of the same relationship")
    @ManyToMany(mappedBy = "iDS")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RNSREFRMASTER> masterIds = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getrEFRID() {
        return rEFRID;
    }

    public RNS_REFR_DETAILS rEFRID(String rEFRID) {
        this.rEFRID = rEFRID;
        return this;
    }

    public void setrEFRID(String rEFRID) {
        this.rEFRID = rEFRID;
    }

    public String getsUBCODE() {
        return sUBCODE;
    }

    public RNS_REFR_DETAILS sUBCODE(String sUBCODE) {
        this.sUBCODE = sUBCODE;
        return this;
    }

    public void setsUBCODE(String sUBCODE) {
        this.sUBCODE = sUBCODE;
    }

    public String getsUBCODEDESC() {
        return sUBCODEDESC;
    }

    public RNS_REFR_DETAILS sUBCODEDESC(String sUBCODEDESC) {
        this.sUBCODEDESC = sUBCODEDESC;
        return this;
    }

    public void setsUBCODEDESC(String sUBCODEDESC) {
        this.sUBCODEDESC = sUBCODEDESC;
    }

    public String getsTATUS() {
        return sTATUS;
    }

    public RNS_REFR_DETAILS sTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
        return this;
    }

    public void setsTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getcREATEDBY() {
        return cREATEDBY;
    }

    public RNS_REFR_DETAILS cREATEDBY(String cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
        return this;
    }

    public void setcREATEDBY(String cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public Instant getcREATEDDATE() {
        return cREATEDDATE;
    }

    public RNS_REFR_DETAILS cREATEDDATE(Instant cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
        return this;
    }

    public void setcREATEDDATE(Instant cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
    }

    public String getlASTMODIFIEDBY() {
        return lASTMODIFIEDBY;
    }

    public RNS_REFR_DETAILS lASTMODIFIEDBY(String lASTMODIFIEDBY) {
        this.lASTMODIFIEDBY = lASTMODIFIEDBY;
        return this;
    }

    public void setlASTMODIFIEDBY(String lASTMODIFIEDBY) {
        this.lASTMODIFIEDBY = lASTMODIFIEDBY;
    }

    public Instant getlASTMODIFIEDDATE() {
        return lASTMODIFIEDDATE;
    }

    public RNS_REFR_DETAILS lASTMODIFIEDDATE(Instant lASTMODIFIEDDATE) {
        this.lASTMODIFIEDDATE = lASTMODIFIEDDATE;
        return this;
    }

    public void setlASTMODIFIEDDATE(Instant lASTMODIFIEDDATE) {
        this.lASTMODIFIEDDATE = lASTMODIFIEDDATE;
    }

    public Set<RNSREFRMASTER> getMasterIds() {
        return masterIds;
    }

    public RNS_REFR_DETAILS masterIds(Set<RNSREFRMASTER> rNSREFRMASTERS) {
        this.masterIds = rNSREFRMASTERS;
        return this;
    }

    public RNS_REFR_DETAILS addMasterId(RNSREFRMASTER rNSREFRMASTER) {
        this.masterIds.add(rNSREFRMASTER);
        rNSREFRMASTER.getIDS().add(this);
        return this;
    }

    public RNS_REFR_DETAILS removeMasterId(RNSREFRMASTER rNSREFRMASTER) {
        this.masterIds.remove(rNSREFRMASTER);
        rNSREFRMASTER.getIDS().remove(this);
        return this;
    }

    public void setMasterIds(Set<RNSREFRMASTER> rNSREFRMASTERS) {
        this.masterIds = rNSREFRMASTERS;
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
        RNS_REFR_DETAILS rNS_REFR_DETAILS = (RNS_REFR_DETAILS) o;
        if (rNS_REFR_DETAILS.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_REFR_DETAILS.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_REFR_DETAILS{" +
            "id=" + getId() +
            ", rEFRID='" + getrEFRID() + "'" +
            ", sUBCODE='" + getsUBCODE() + "'" +
            ", sUBCODEDESC='" + getsUBCODEDESC() + "'" +
            ", sTATUS='" + getsTATUS() + "'" +
            ", cREATEDBY='" + getcREATEDBY() + "'" +
            ", cREATEDDATE='" + getcREATEDDATE() + "'" +
            ", lASTMODIFIEDBY='" + getlASTMODIFIEDBY() + "'" +
            ", lASTMODIFIEDDATE='" + getlASTMODIFIEDDATE() + "'" +
            "}";
    }
}
