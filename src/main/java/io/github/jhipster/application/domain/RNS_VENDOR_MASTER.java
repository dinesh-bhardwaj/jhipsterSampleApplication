package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_VENDOR_MASTER.
 */
@Entity
@Table(name = "rns_vendor_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_VENDOR_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "v_endorcode")
    private String vENDORCODE;

    @Column(name = "v_endormastercode")
    private String vENDORMASTERCODE;

    @Column(name = "v_endorname")
    private String vENDORNAME;

    @Column(name = "v_endoruserid")
    private Integer vENDORUSERID;

    @Column(name = "u_sername")
    private String uSERNAME;

    @Column(name = "e_mail")
    private String eMAIL;

    @Column(name = "m_obilenumber")
    private String mOBILENUMBER;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvENDORCODE() {
        return vENDORCODE;
    }

    public RNS_VENDOR_MASTER vENDORCODE(String vENDORCODE) {
        this.vENDORCODE = vENDORCODE;
        return this;
    }

    public void setvENDORCODE(String vENDORCODE) {
        this.vENDORCODE = vENDORCODE;
    }

    public String getvENDORMASTERCODE() {
        return vENDORMASTERCODE;
    }

    public RNS_VENDOR_MASTER vENDORMASTERCODE(String vENDORMASTERCODE) {
        this.vENDORMASTERCODE = vENDORMASTERCODE;
        return this;
    }

    public void setvENDORMASTERCODE(String vENDORMASTERCODE) {
        this.vENDORMASTERCODE = vENDORMASTERCODE;
    }

    public String getvENDORNAME() {
        return vENDORNAME;
    }

    public RNS_VENDOR_MASTER vENDORNAME(String vENDORNAME) {
        this.vENDORNAME = vENDORNAME;
        return this;
    }

    public void setvENDORNAME(String vENDORNAME) {
        this.vENDORNAME = vENDORNAME;
    }

    public Integer getvENDORUSERID() {
        return vENDORUSERID;
    }

    public RNS_VENDOR_MASTER vENDORUSERID(Integer vENDORUSERID) {
        this.vENDORUSERID = vENDORUSERID;
        return this;
    }

    public void setvENDORUSERID(Integer vENDORUSERID) {
        this.vENDORUSERID = vENDORUSERID;
    }

    public String getuSERNAME() {
        return uSERNAME;
    }

    public RNS_VENDOR_MASTER uSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
        return this;
    }

    public void setuSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
    }

    public String geteMAIL() {
        return eMAIL;
    }

    public RNS_VENDOR_MASTER eMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
        return this;
    }

    public void seteMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getmOBILENUMBER() {
        return mOBILENUMBER;
    }

    public RNS_VENDOR_MASTER mOBILENUMBER(String mOBILENUMBER) {
        this.mOBILENUMBER = mOBILENUMBER;
        return this;
    }

    public void setmOBILENUMBER(String mOBILENUMBER) {
        this.mOBILENUMBER = mOBILENUMBER;
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
        RNS_VENDOR_MASTER rNS_VENDOR_MASTER = (RNS_VENDOR_MASTER) o;
        if (rNS_VENDOR_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_VENDOR_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_VENDOR_MASTER{" +
            "id=" + getId() +
            ", vENDORCODE='" + getvENDORCODE() + "'" +
            ", vENDORMASTERCODE='" + getvENDORMASTERCODE() + "'" +
            ", vENDORNAME='" + getvENDORNAME() + "'" +
            ", vENDORUSERID=" + getvENDORUSERID() +
            ", uSERNAME='" + getuSERNAME() + "'" +
            ", eMAIL='" + geteMAIL() + "'" +
            ", mOBILENUMBER='" + getmOBILENUMBER() + "'" +
            "}";
    }
}
