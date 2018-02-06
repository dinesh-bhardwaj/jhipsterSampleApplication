package io.github.jhipster.application.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RNS_ARTICLE_MASTER.
 */
@Entity
@Table(name = "rns_article_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RNS_ARTICLE_MASTER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "a_rticlecode")
    private String aRTICLECODE;

    @Column(name = "a_rticlecodedesc")
    private String aRTICLECODEDESC;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaRTICLECODE() {
        return aRTICLECODE;
    }

    public RNS_ARTICLE_MASTER aRTICLECODE(String aRTICLECODE) {
        this.aRTICLECODE = aRTICLECODE;
        return this;
    }

    public void setaRTICLECODE(String aRTICLECODE) {
        this.aRTICLECODE = aRTICLECODE;
    }

    public String getaRTICLECODEDESC() {
        return aRTICLECODEDESC;
    }

    public RNS_ARTICLE_MASTER aRTICLECODEDESC(String aRTICLECODEDESC) {
        this.aRTICLECODEDESC = aRTICLECODEDESC;
        return this;
    }

    public void setaRTICLECODEDESC(String aRTICLECODEDESC) {
        this.aRTICLECODEDESC = aRTICLECODEDESC;
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
        RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER = (RNS_ARTICLE_MASTER) o;
        if (rNS_ARTICLE_MASTER.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rNS_ARTICLE_MASTER.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RNS_ARTICLE_MASTER{" +
            "id=" + getId() +
            ", aRTICLECODE='" + getaRTICLECODE() + "'" +
            ", aRTICLECODEDESC='" + getaRTICLECODEDESC() + "'" +
            "}";
    }
}
