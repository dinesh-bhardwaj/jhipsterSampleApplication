package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_TYPE_MASTER;

import io.github.jhipster.application.repository.RNS_TYPE_MASTERRepository;
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
 * REST controller for managing RNS_TYPE_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_TYPE_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_TYPE_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_TYPE_MASTER";

    private final RNS_TYPE_MASTERRepository rNS_TYPE_MASTERRepository;

    public RNS_TYPE_MASTERResource(RNS_TYPE_MASTERRepository rNS_TYPE_MASTERRepository) {
        this.rNS_TYPE_MASTERRepository = rNS_TYPE_MASTERRepository;
    }

    /**
     * POST  /rns-type-masters : Create a new rNS_TYPE_MASTER.
     *
     * @param rNS_TYPE_MASTER the rNS_TYPE_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_TYPE_MASTER, or with status 400 (Bad Request) if the rNS_TYPE_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-type-masters")
    @Timed
    public ResponseEntity<RNS_TYPE_MASTER> createRNS_TYPE_MASTER(@RequestBody RNS_TYPE_MASTER rNS_TYPE_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_TYPE_MASTER : {}", rNS_TYPE_MASTER);
        if (rNS_TYPE_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_TYPE_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_TYPE_MASTER result = rNS_TYPE_MASTERRepository.save(rNS_TYPE_MASTER);
        return ResponseEntity.created(new URI("/api/rns-type-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-type-masters : Updates an existing rNS_TYPE_MASTER.
     *
     * @param rNS_TYPE_MASTER the rNS_TYPE_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_TYPE_MASTER,
     * or with status 400 (Bad Request) if the rNS_TYPE_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_TYPE_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-type-masters")
    @Timed
    public ResponseEntity<RNS_TYPE_MASTER> updateRNS_TYPE_MASTER(@RequestBody RNS_TYPE_MASTER rNS_TYPE_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_TYPE_MASTER : {}", rNS_TYPE_MASTER);
        if (rNS_TYPE_MASTER.getId() == null) {
            return createRNS_TYPE_MASTER(rNS_TYPE_MASTER);
        }
        RNS_TYPE_MASTER result = rNS_TYPE_MASTERRepository.save(rNS_TYPE_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_TYPE_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-type-masters : get all the rNS_TYPE_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_TYPE_MASTERS in body
     */
    @GetMapping("/rns-type-masters")
    @Timed
    public List<RNS_TYPE_MASTER> getAllRNS_TYPE_MASTERS() {
        log.debug("REST request to get all RNS_TYPE_MASTERS");
        return rNS_TYPE_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-type-masters/:id : get the "id" rNS_TYPE_MASTER.
     *
     * @param id the id of the rNS_TYPE_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_TYPE_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-type-masters/{id}")
    @Timed
    public ResponseEntity<RNS_TYPE_MASTER> getRNS_TYPE_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_TYPE_MASTER : {}", id);
        RNS_TYPE_MASTER rNS_TYPE_MASTER = rNS_TYPE_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_TYPE_MASTER));
    }

    /**
     * DELETE  /rns-type-masters/:id : delete the "id" rNS_TYPE_MASTER.
     *
     * @param id the id of the rNS_TYPE_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-type-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_TYPE_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_TYPE_MASTER : {}", id);
        rNS_TYPE_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
