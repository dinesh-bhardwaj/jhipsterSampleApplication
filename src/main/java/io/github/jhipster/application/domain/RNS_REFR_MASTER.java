package io.github.jhipster.application.domain;

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
 * A RNS_REFR_MASTER.
 */
@Entity
@Table(name = "rns_refr_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_REFR_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "r_nscatgcode")
    private String rNSCATGCODE;

    @Column(name = "s_ubcode_1")
    private String sUBCODE1;

    @Column(name = "s_ubcodedesc_1")
    private String sUBCODEDESC1;

    @Column(name = "s_ubcode_2")
    private String sUBCODE2;

    @Column(name = "s_ubcodedesc_2")
    private String sUBCODEDESC2;

    @Column(name = "s_ubcode_3")
    private String sUBCODE3;

    @Column(name = "s_ubcodedesc_3")
    private String sUBCODEDESC3;

    @Column(name = "s_ubcode_4")
    private String sUBCODE4;

    @Column(name = "s_ubcodedesc_4")
    private String sUBCODEDESC4;

    @Column(name = "s_ubcode_5")
    private String sUBCODE5;

    @Column(name = "s_ubcodedesc_5")
    private String sUBCODEDESC5;

    @Column(name = "s_ubcode_6")
    private String sUBCODE6;

    @Column(name = "s_ubcodedesc_6")
    private String sUBCODEDESC6;

    @Column(name = "s_ubcode_7")
    private String sUBCODE7;

    @Column(name = "s_ubcodedesc_7")
    private String sUBCODEDESC7;

    @Column(name = "s_ubcode_8")
    private String sUBCODE8;

    @Column(name = "s_ubcodedesc_8")
    private String sUBCODEDESC8;

    @Column(name = "s_ubcode_9")
    private String sUBCODE9;

    @Column(name = "s_ubcodedesc_9")
    private String sUBCODEDESC9;

    @Column(name = "s_ubcode_10")
    private String sUBCODE10;

    @Column(name = "s_ubcodedesc_10")
    private String sUBCODEDESC10;

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
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "rns_refr_master_id",
               joinColumns = @JoinColumn(name="rns_refr_masters_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="ids_id", referencedColumnName="id"))
    private Set<RNSREFRDETAILS> iDS = new HashSet<>();

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

    public RNS_REFR_MASTER rNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
        return this;
    }

    public void setrNSCATGCODE(String rNSCATGCODE) {
        this.rNSCATGCODE = rNSCATGCODE;
    }

    public String getsUBCODE1() {
        return sUBCODE1;
    }

    public RNS_REFR_MASTER sUBCODE1(String sUBCODE1) {
        this.sUBCODE1 = sUBCODE1;
        return this;
    }

    public void setsUBCODE1(String sUBCODE1) {
        this.sUBCODE1 = sUBCODE1;
    }

    public String getsUBCODEDESC1() {
        return sUBCODEDESC1;
    }

    public RNS_REFR_MASTER sUBCODEDESC1(String sUBCODEDESC1) {
        this.sUBCODEDESC1 = sUBCODEDESC1;
        return this;
    }

    public void setsUBCODEDESC1(String sUBCODEDESC1) {
        this.sUBCODEDESC1 = sUBCODEDESC1;
    }

    public String getsUBCODE2() {
        return sUBCODE2;
    }

    public RNS_REFR_MASTER sUBCODE2(String sUBCODE2) {
        this.sUBCODE2 = sUBCODE2;
        return this;
    }

    public void setsUBCODE2(String sUBCODE2) {
        this.sUBCODE2 = sUBCODE2;
    }

    public String getsUBCODEDESC2() {
        return sUBCODEDESC2;
    }

    public RNS_REFR_MASTER sUBCODEDESC2(String sUBCODEDESC2) {
        this.sUBCODEDESC2 = sUBCODEDESC2;
        return this;
    }

    public void setsUBCODEDESC2(String sUBCODEDESC2) {
        this.sUBCODEDESC2 = sUBCODEDESC2;
    }

    public String getsUBCODE3() {
        return sUBCODE3;
    }

    public RNS_REFR_MASTER sUBCODE3(String sUBCODE3) {
        this.sUBCODE3 = sUBCODE3;
        return this;
    }

    public void setsUBCODE3(String sUBCODE3) {
        this.sUBCODE3 = sUBCODE3;
    }

    public String getsUBCODEDESC3() {
        return sUBCODEDESC3;
    }

    public RNS_REFR_MASTER sUBCODEDESC3(String sUBCODEDESC3) {
        this.sUBCODEDESC3 = sUBCODEDESC3;
        return this;
    }

    public void setsUBCODEDESC3(String sUBCODEDESC3) {
        this.sUBCODEDESC3 = sUBCODEDESC3;
    }

    public String getsUBCODE4() {
        return sUBCODE4;
    }

    public RNS_REFR_MASTER sUBCODE4(String sUBCODE4) {
        this.sUBCODE4 = sUBCODE4;
        return this;
    }

    public void setsUBCODE4(String sUBCODE4) {
        this.sUBCODE4 = sUBCODE4;
    }

    public String getsUBCODEDESC4() {
        return sUBCODEDESC4;
    }

    public RNS_REFR_MASTER sUBCODEDESC4(String sUBCODEDESC4) {
        this.sUBCODEDESC4 = sUBCODEDESC4;
        return this;
    }

    public void setsUBCODEDESC4(String sUBCODEDESC4) {
        this.sUBCODEDESC4 = sUBCODEDESC4;
    }

    public String getsUBCODE5() {
        return sUBCODE5;
    }

    public RNS_REFR_MASTER sUBCODE5(String sUBCODE5) {
        this.sUBCODE5 = sUBCODE5;
        return this;
    }

    public void setsUBCODE5(String sUBCODE5) {
        this.sUBCODE5 = sUBCODE5;
    }

    public String getsUBCODEDESC5() {
        return sUBCODEDESC5;
    }

    public RNS_REFR_MASTER sUBCODEDESC5(String sUBCODEDESC5) {
        this.sUBCODEDESC5 = sUBCODEDESC5;
        return this;
    }

    public void setsUBCODEDESC5(String sUBCODEDESC5) {
        this.sUBCODEDESC5 = sUBCODEDESC5;
    }

    public String getsUBCODE6() {
        return sUBCODE6;
    }

    public RNS_REFR_MASTER sUBCODE6(String sUBCODE6) {
        this.sUBCODE6 = sUBCODE6;
        return this;
    }

    public void setsUBCODE6(String sUBCODE6) {
        this.sUBCODE6 = sUBCODE6;
    }

    public String getsUBCODEDESC6() {
        return sUBCODEDESC6;
    }

    public RNS_REFR_MASTER sUBCODEDESC6(String sUBCODEDESC6) {
        this.sUBCODEDESC6 = sUBCODEDESC6;
        return this;
    }

    public void setsUBCODEDESC6(String sUBCODEDESC6) {
        this.sUBCODEDESC6 = sUBCODEDESC6;
    }

    public String getsUBCODE7() {
        return sUBCODE7;
    }

    public RNS_REFR_MASTER sUBCODE7(String sUBCODE7) {
        this.sUBCODE7 = sUBCODE7;
        return this;
    }

    public void setsUBCODE7(String sUBCODE7) {
        this.sUBCODE7 = sUBCODE7;
    }

    public String getsUBCODEDESC7() {
        return sUBCODEDESC7;
    }

    public RNS_REFR_MASTER sUBCODEDESC7(String sUBCODEDESC7) {
        this.sUBCODEDESC7 = sUBCODEDESC7;
        return this;
    }

    public void setsUBCODEDESC7(String sUBCODEDESC7) {
        this.sUBCODEDESC7 = sUBCODEDESC7;
    }

    public String getsUBCODE8() {
        return sUBCODE8;
    }

    public RNS_REFR_MASTER sUBCODE8(String sUBCODE8) {
        this.sUBCODE8 = sUBCODE8;
        return this;
    }

    public void setsUBCODE8(String sUBCODE8) {
        this.sUBCODE8 = sUBCODE8;
    }

    public String getsUBCODEDESC8() {
        return sUBCODEDESC8;
    }

    public RNS_REFR_MASTER sUBCODEDESC8(String sUBCODEDESC8) {
        this.sUBCODEDESC8 = sUBCODEDESC8;
        return this;
    }

    public void setsUBCODEDESC8(String sUBCODEDESC8) {
        this.sUBCODEDESC8 = sUBCODEDESC8;
    }

    public String getsUBCODE9() {
        return sUBCODE9;
    }

    public RNS_REFR_MASTER sUBCODE9(String sUBCODE9) {
        this.sUBCODE9 = sUBCODE9;
        return this;
    }

    public void setsUBCODE9(String sUBCODE9) {
        this.sUBCODE9 = sUBCODE9;
    }

    public String getsUBCODEDESC9() {
        return sUBCODEDESC9;
    }

    public RNS_REFR_MASTER sUBCODEDESC9(String sUBCODEDESC9) {
        this.sUBCODEDESC9 = sUBCODEDESC9;
        return this;
    }

    public void setsUBCODEDESC9(String sUBCODEDESC9) {
        this.sUBCODEDESC9 = sUBCODEDESC9;
    }

    public String getsUBCODE10() {
        return sUBCODE10;
    }

    public RNS_REFR_MASTER sUBCODE10(String sUBCODE10) {
        this.sUBCODE10 = sUBCODE10;
        return this;
    }

    public void setsUBCODE10(String sUBCODE10) {
        this.sUBCODE10 = sUBCODE10;
    }

    public String getsUBCODEDESC10() {
        return sUBCODEDESC10;
    }

    public RNS_REFR_MASTER sUBCODEDESC10(String sUBCODEDESC10) {
        this.sUBCODEDESC10 = sUBCODEDESC10;
        return this;
    }

    public void setsUBCODEDESC10(String sUBCODEDESC10) {
        this.sUBCODEDESC10 = sUBCODEDESC10;
    }

    public String getsTATUS() {
        return sTATUS;
    }

    public RNS_REFR_MASTER sTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
        return this;
    }

    public void setsTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getcREATEDBY() {
        return cREATEDBY;
    }

    public RNS_REFR_MASTER cREATEDBY(String cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
        return this;
    }

    public void setcREATEDBY(String cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public Instant getcREATEDDATE() {
        return cREATEDDATE;
    }

    public RNS_REFR_MASTER cREATEDDATE(Instant cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
        return this;
    }

    public void setcREATEDDATE(Instant cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
    }

    public String getlASTMODIFIEDBY() {
        return lASTMODIFIEDBY;
    }

    public RNS_REFR_MASTER lASTMODIFIEDBY(String lASTMODIFIEDBY) {
        this.lASTMODIFIEDBY = lASTMODIFIEDBY;
        return this;
    }

    public void setlASTMODIFIEDBY(String lASTMODIFIEDBY) {
        this.lASTMODIFIEDBY = lASTMODIFIEDBY;
    }

    public Instant getlASTMODIFIEDDATE() {
        return lASTMODIFIEDDATE;
    }

    public RNS_REFR_MASTER lASTMODIFIEDDATE(Instant lASTMODIFIEDDATE) {
        this.lASTMODIFIEDDATE = lASTMODIFIEDDATE;
        return this;
    }

    public void setlASTMODIFIEDDATE(Instant lASTMODIFIEDDATE) {
        this.lASTMODIFIEDDATE = lASTMODIFIEDDATE;
    }

    public Set<RNSREFRDETAILS> getIDS() {
        return iDS;
    }

    public RNS_REFR_MASTER iDS(Set<RNSREFRDETAILS> rNSREFRDETAILS) {
        this.iDS = rNSREFRDETAILS;
        return this;
    }

    public RNS_REFR_MASTER addID(RNSREFRDETAILS rNSREFRDETAILS) {
        this.iDS.add(rNSREFRDETAILS);
        rNSREFRDETAILS.getMasterIds().add(this);
        return this;
    }

    public RNS_REFR_MASTER removeID(RNSREFRDETAILS rNSREFRDETAILS) {
        this.iDS.remove(rNSREFRDETAILS);
        rNSREFRDETAILS.getMasterIds().remove(this);
        return this;
    }

    public void setIDS(Set<RNSREFRDETAILS> rNSREFRDETAILS) {
        this.iDS = rNSREFRDETAILS;
    }

    public RNSCATGMASTER getRNSCATGMASTER() {
        return rNSCATGMASTER;
    }

    public RNS_REFR_MASTER rNSCATGMASTER(RNSCATGMASTER rNSCATGMASTER) {
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
        RNS_REFR_MASTER rNS_REFR_MASTER = (RNS_REFR_MASTER) o;
        if (rNS_REFR_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_REFR_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_REFR_MASTER{" +
            "id=" + getId() +
            ", rNSCATGCODE='" + getrNSCATGCODE() + "'" +
            ", sUBCODE1='" + getsUBCODE1() + "'" +
            ", sUBCODEDESC1='" + getsUBCODEDESC1() + "'" +
            ", sUBCODE2='" + getsUBCODE2() + "'" +
            ", sUBCODEDESC2='" + getsUBCODEDESC2() + "'" +
            ", sUBCODE3='" + getsUBCODE3() + "'" +
            ", sUBCODEDESC3='" + getsUBCODEDESC3() + "'" +
            ", sUBCODE4='" + getsUBCODE4() + "'" +
            ", sUBCODEDESC4='" + getsUBCODEDESC4() + "'" +
            ", sUBCODE5='" + getsUBCODE5() + "'" +
            ", sUBCODEDESC5='" + getsUBCODEDESC5() + "'" +
            ", sUBCODE6='" + getsUBCODE6() + "'" +
            ", sUBCODEDESC6='" + getsUBCODEDESC6() + "'" +
            ", sUBCODE7='" + getsUBCODE7() + "'" +
            ", sUBCODEDESC7='" + getsUBCODEDESC7() + "'" +
            ", sUBCODE8='" + getsUBCODE8() + "'" +
            ", sUBCODEDESC8='" + getsUBCODEDESC8() + "'" +
            ", sUBCODE9='" + getsUBCODE9() + "'" +
            ", sUBCODEDESC9='" + getsUBCODEDESC9() + "'" +
            ", sUBCODE10='" + getsUBCODE10() + "'" +
            ", sUBCODEDESC10='" + getsUBCODEDESC10() + "'" +
            ", sTATUS='" + getsTATUS() + "'" +
            ", cREATEDBY='" + getcREATEDBY() + "'" +
            ", cREATEDDATE='" + getcREATEDDATE() + "'" +
            ", lASTMODIFIEDBY='" + getlASTMODIFIEDBY() + "'" +
            ", lASTMODIFIEDDATE='" + getlASTMODIFIEDDATE() + "'" +
            "}";
    }
}
