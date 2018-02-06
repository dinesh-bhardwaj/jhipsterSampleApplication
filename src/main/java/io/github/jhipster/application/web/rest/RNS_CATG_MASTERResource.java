package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_CATG_MASTER;

import io.github.jhipster.application.repository.RNS_CATG_MASTERRepository;
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
 * REST controller for managing RNS_CATG_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_CATG_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_CATG_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_CATG_MASTER";

    private final RNS_CATG_MASTERRepository rNS_CATG_MASTERRepository;

    public RNS_CATG_MASTERResource(RNS_CATG_MASTERRepository rNS_CATG_MASTERRepository) {
        this.rNS_CATG_MASTERRepository = rNS_CATG_MASTERRepository;
    }

    /**
     * POST  /rns-catg-masters : Create a new rNS_CATG_MASTER.
     *
     * @param rNS_CATG_MASTER the rNS_CATG_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_CATG_MASTER, or with status 400 (Bad Request) if the rNS_CATG_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-catg-masters")
    @Timed
    public ResponseEntity<RNS_CATG_MASTER> createRNS_CATG_MASTER(@RequestBody RNS_CATG_MASTER rNS_CATG_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_CATG_MASTER : {}", rNS_CATG_MASTER);
        if (rNS_CATG_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_CATG_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_CATG_MASTER result = rNS_CATG_MASTERRepository.save(rNS_CATG_MASTER);
        return ResponseEntity.created(new URI("/api/rns-catg-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-catg-masters : Updates an existing rNS_CATG_MASTER.
     *
     * @param rNS_CATG_MASTER the rNS_CATG_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_CATG_MASTER,
     * or with status 400 (Bad Request) if the rNS_CATG_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_CATG_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-catg-masters")
    @Timed
    public ResponseEntity<RNS_CATG_MASTER> updateRNS_CATG_MASTER(@RequestBody RNS_CATG_MASTER rNS_CATG_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_CATG_MASTER : {}", rNS_CATG_MASTER);
        if (rNS_CATG_MASTER.getId() == null) {
            return createRNS_CATG_MASTER(rNS_CATG_MASTER);
        }
        RNS_CATG_MASTER result = rNS_CATG_MASTERRepository.save(rNS_CATG_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_CATG_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-catg-masters : get all the rNS_CATG_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_CATG_MASTERS in body
     */
    @GetMapping("/rns-catg-masters")
    @Timed
    public List<RNS_CATG_MASTER> getAllRNS_CATG_MASTERS() {
        log.debug("REST request to get all RNS_CATG_MASTERS");
        return rNS_CATG_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-catg-masters/:id : get the "id" rNS_CATG_MASTER.
     *
     * @param id the id of the rNS_CATG_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_CATG_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-catg-masters/{id}")
    @Timed
    public ResponseEntity<RNS_CATG_MASTER> getRNS_CATG_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_CATG_MASTER : {}", id);
        RNS_CATG_MASTER rNS_CATG_MASTER = rNS_CATG_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_CATG_MASTER));
    }

    /**
     * DELETE  /rns-catg-masters/:id : delete the "id" rNS_CATG_MASTER.
     *
     * @param id the id of the rNS_CATG_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-catg-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_CATG_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_CATG_MASTER : {}", id);
        rNS_CATG_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
