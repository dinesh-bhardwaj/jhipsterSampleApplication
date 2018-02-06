package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_REFR_MASTER;

import io.github.jhipster.application.repository.RNS_REFR_MASTERRepository;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing RNS_REFR_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_REFR_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_REFR_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_REFR_MASTER";

    private final RNS_REFR_MASTERRepository rNS_REFR_MASTERRepository;

    public RNS_REFR_MASTERResource(RNS_REFR_MASTERRepository rNS_REFR_MASTERRepository) {
        this.rNS_REFR_MASTERRepository = rNS_REFR_MASTERRepository;
    }

    /**
     * POST  /rns-refr-masters : Create a new rNS_REFR_MASTER.
     *
     * @param rNS_REFR_MASTER the rNS_REFR_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_REFR_MASTER, or with status 400 (Bad Request) if the rNS_REFR_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-refr-masters")
    @Timed
    public ResponseEntity<RNS_REFR_MASTER> createRNS_REFR_MASTER(@RequestBody RNS_REFR_MASTER rNS_REFR_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_REFR_MASTER : {}", rNS_REFR_MASTER);
        if (rNS_REFR_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_REFR_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_REFR_MASTER result = rNS_REFR_MASTERRepository.save(rNS_REFR_MASTER);
        return ResponseEntity.created(new URI("/api/rns-refr-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-refr-masters : Updates an existing rNS_REFR_MASTER.
     *
     * @param rNS_REFR_MASTER the rNS_REFR_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_REFR_MASTER,
     * or with status 400 (Bad Request) if the rNS_REFR_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_REFR_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-refr-masters")
    @Timed
    public ResponseEntity<RNS_REFR_MASTER> updateRNS_REFR_MASTER(@RequestBody RNS_REFR_MASTER rNS_REFR_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_REFR_MASTER : {}", rNS_REFR_MASTER);
        if (rNS_REFR_MASTER.getId() == null) {
            return createRNS_REFR_MASTER(rNS_REFR_MASTER);
        }
        RNS_REFR_MASTER result = rNS_REFR_MASTERRepository.save(rNS_REFR_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_REFR_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-refr-masters : get all the rNS_REFR_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_REFR_MASTERS in body
     */
    @GetMapping("/rns-refr-masters")
    @Timed
    public List<RNS_REFR_MASTER> getAllRNS_REFR_MASTERS() {
        log.debug("REST request to get all RNS_REFR_MASTERS");
        return rNS_REFR_MASTERRepository.findAllWithEagerRelationships();
        }

    /**
     * GET  /rns-refr-masters/:id : get the "id" rNS_REFR_MASTER.
     *
     * @param id the id of the rNS_REFR_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_REFR_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-refr-masters/{id}")
    @Timed
    public ResponseEntity<RNS_REFR_MASTER> getRNS_REFR_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_REFR_MASTER : {}", id);
        RNS_REFR_MASTER rNS_REFR_MASTER = rNS_REFR_MASTERRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_REFR_MASTER));
    }

    /**
     * DELETE  /rns-refr-masters/:id : delete the "id" rNS_REFR_MASTER.
     *
     * @param id the id of the rNS_REFR_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-refr-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_REFR_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_REFR_MASTER : {}", id);
        rNS_REFR_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
