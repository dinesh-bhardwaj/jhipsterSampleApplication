package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.RNS_REFR_MASTER;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the RNS_REFR_MASTER entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RNS_REFR_MASTERRepository extends JpaRepository<RNS_REFR_MASTER, Long> {
    @Query("select distinct rns_refr_master from RNS_REFR_MASTER rns_refr_master left join fetch rns_refr_master.iDS")
    List<RNS_REFR_MASTER> findAllWithEagerRelationships();

    @Query("select rns_refr_master from RNS_REFR_MASTER rns_refr_master left join fetch rns_refr_master.iDS where rns_refr_master.id =:id")
    RNS_REFR_MASTER findOneWithEagerRelationships(@Param("id") Long id);

}
