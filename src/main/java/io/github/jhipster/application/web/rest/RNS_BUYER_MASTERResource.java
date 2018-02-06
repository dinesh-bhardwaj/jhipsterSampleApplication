package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_BUYER_MASTER;

import io.github.jhipster.application.repository.RNS_BUYER_MASTERRepository;
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
 * REST controller for managing RNS_BUYER_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_BUYER_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_BUYER_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_BUYER_MASTER";

    private final RNS_BUYER_MASTERRepository rNS_BUYER_MASTERRepository;

    public RNS_BUYER_MASTERResource(RNS_BUYER_MASTERRepository rNS_BUYER_MASTERRepository) {
        this.rNS_BUYER_MASTERRepository = rNS_BUYER_MASTERRepository;
    }

    /**
     * POST  /rns-buyer-masters : Create a new rNS_BUYER_MASTER.
     *
     * @param rNS_BUYER_MASTER the rNS_BUYER_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_BUYER_MASTER, or with status 400 (Bad Request) if the rNS_BUYER_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-buyer-masters")
    @Timed
    public ResponseEntity<RNS_BUYER_MASTER> createRNS_BUYER_MASTER(@RequestBody RNS_BUYER_MASTER rNS_BUYER_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_BUYER_MASTER : {}", rNS_BUYER_MASTER);
        if (rNS_BUYER_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_BUYER_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_BUYER_MASTER result = rNS_BUYER_MASTERRepository.save(rNS_BUYER_MASTER);
        return ResponseEntity.created(new URI("/api/rns-buyer-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-buyer-masters : Updates an existing rNS_BUYER_MASTER.
     *
     * @param rNS_BUYER_MASTER the rNS_BUYER_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_BUYER_MASTER,
     * or with status 400 (Bad Request) if the rNS_BUYER_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_BUYER_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-buyer-masters")
    @Timed
    public ResponseEntity<RNS_BUYER_MASTER> updateRNS_BUYER_MASTER(@RequestBody RNS_BUYER_MASTER rNS_BUYER_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_BUYER_MASTER : {}", rNS_BUYER_MASTER);
        if (rNS_BUYER_MASTER.getId() == null) {
            return createRNS_BUYER_MASTER(rNS_BUYER_MASTER);
        }
        RNS_BUYER_MASTER result = rNS_BUYER_MASTERRepository.save(rNS_BUYER_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_BUYER_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-buyer-masters : get all the rNS_BUYER_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_BUYER_MASTERS in body
     */
    @GetMapping("/rns-buyer-masters")
    @Timed
    public List<RNS_BUYER_MASTER> getAllRNS_BUYER_MASTERS() {
        log.debug("REST request to get all RNS_BUYER_MASTERS");
        return rNS_BUYER_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-buyer-masters/:id : get the "id" rNS_BUYER_MASTER.
     *
     * @param id the id of the rNS_BUYER_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_BUYER_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-buyer-masters/{id}")
    @Timed
    public ResponseEntity<RNS_BUYER_MASTER> getRNS_BUYER_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_BUYER_MASTER : {}", id);
        RNS_BUYER_MASTER rNS_BUYER_MASTER = rNS_BUYER_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_BUYER_MASTER));
    }

    /**
     * DELETE  /rns-buyer-masters/:id : delete the "id" rNS_BUYER_MASTER.
     *
     * @param id the id of the rNS_BUYER_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-buyer-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_BUYER_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_BUYER_MASTER : {}", id);
        rNS_BUYER_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
