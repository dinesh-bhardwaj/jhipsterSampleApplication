package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_PCH_MASTER;

import io.github.jhipster.application.repository.RNS_PCH_MASTERRepository;
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
 * REST controller for managing RNS_PCH_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_PCH_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_PCH_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_PCH_MASTER";

    private final RNS_PCH_MASTERRepository rNS_PCH_MASTERRepository;

    public RNS_PCH_MASTERResource(RNS_PCH_MASTERRepository rNS_PCH_MASTERRepository) {
        this.rNS_PCH_MASTERRepository = rNS_PCH_MASTERRepository;
    }

    /**
     * POST  /rns-pch-masters : Create a new rNS_PCH_MASTER.
     *
     * @param rNS_PCH_MASTER the rNS_PCH_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_PCH_MASTER, or with status 400 (Bad Request) if the rNS_PCH_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-pch-masters")
    @Timed
    public ResponseEntity<RNS_PCH_MASTER> createRNS_PCH_MASTER(@RequestBody RNS_PCH_MASTER rNS_PCH_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_PCH_MASTER : {}", rNS_PCH_MASTER);
        if (rNS_PCH_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_PCH_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_PCH_MASTER result = rNS_PCH_MASTERRepository.save(rNS_PCH_MASTER);
        return ResponseEntity.created(new URI("/api/rns-pch-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-pch-masters : Updates an existing rNS_PCH_MASTER.
     *
     * @param rNS_PCH_MASTER the rNS_PCH_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_PCH_MASTER,
     * or with status 400 (Bad Request) if the rNS_PCH_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_PCH_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-pch-masters")
    @Timed
    public ResponseEntity<RNS_PCH_MASTER> updateRNS_PCH_MASTER(@RequestBody RNS_PCH_MASTER rNS_PCH_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_PCH_MASTER : {}", rNS_PCH_MASTER);
        if (rNS_PCH_MASTER.getId() == null) {
            return createRNS_PCH_MASTER(rNS_PCH_MASTER);
        }
        RNS_PCH_MASTER result = rNS_PCH_MASTERRepository.save(rNS_PCH_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_PCH_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-pch-masters : get all the rNS_PCH_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_PCH_MASTERS in body
     */
    @GetMapping("/rns-pch-masters")
    @Timed
    public List<RNS_PCH_MASTER> getAllRNS_PCH_MASTERS() {
        log.debug("REST request to get all RNS_PCH_MASTERS");
        return rNS_PCH_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-pch-masters/:id : get the "id" rNS_PCH_MASTER.
     *
     * @param id the id of the rNS_PCH_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_PCH_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-pch-masters/{id}")
    @Timed
    public ResponseEntity<RNS_PCH_MASTER> getRNS_PCH_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_PCH_MASTER : {}", id);
        RNS_PCH_MASTER rNS_PCH_MASTER = rNS_PCH_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_PCH_MASTER));
    }

    /**
     * DELETE  /rns-pch-masters/:id : delete the "id" rNS_PCH_MASTER.
     *
     * @param id the id of the rNS_PCH_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-pch-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_PCH_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_PCH_MASTER : {}", id);
        rNS_PCH_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
