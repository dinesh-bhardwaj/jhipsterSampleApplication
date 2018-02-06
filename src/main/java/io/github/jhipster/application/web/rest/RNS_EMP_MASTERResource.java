package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_EMP_MASTER;

import io.github.jhipster.application.repository.RNS_EMP_MASTERRepository;
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
 * REST controller for managing RNS_EMP_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_EMP_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_EMP_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_EMP_MASTER";

    private final RNS_EMP_MASTERRepository rNS_EMP_MASTERRepository;

    public RNS_EMP_MASTERResource(RNS_EMP_MASTERRepository rNS_EMP_MASTERRepository) {
        this.rNS_EMP_MASTERRepository = rNS_EMP_MASTERRepository;
    }

    /**
     * POST  /rns-emp-masters : Create a new rNS_EMP_MASTER.
     *
     * @param rNS_EMP_MASTER the rNS_EMP_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_EMP_MASTER, or with status 400 (Bad Request) if the rNS_EMP_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-emp-masters")
    @Timed
    public ResponseEntity<RNS_EMP_MASTER> createRNS_EMP_MASTER(@RequestBody RNS_EMP_MASTER rNS_EMP_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_EMP_MASTER : {}", rNS_EMP_MASTER);
        if (rNS_EMP_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_EMP_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_EMP_MASTER result = rNS_EMP_MASTERRepository.save(rNS_EMP_MASTER);
        return ResponseEntity.created(new URI("/api/rns-emp-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-emp-masters : Updates an existing rNS_EMP_MASTER.
     *
     * @param rNS_EMP_MASTER the rNS_EMP_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_EMP_MASTER,
     * or with status 400 (Bad Request) if the rNS_EMP_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_EMP_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-emp-masters")
    @Timed
    public ResponseEntity<RNS_EMP_MASTER> updateRNS_EMP_MASTER(@RequestBody RNS_EMP_MASTER rNS_EMP_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_EMP_MASTER : {}", rNS_EMP_MASTER);
        if (rNS_EMP_MASTER.getId() == null) {
            return createRNS_EMP_MASTER(rNS_EMP_MASTER);
        }
        RNS_EMP_MASTER result = rNS_EMP_MASTERRepository.save(rNS_EMP_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_EMP_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-emp-masters : get all the rNS_EMP_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_EMP_MASTERS in body
     */
    @GetMapping("/rns-emp-masters")
    @Timed
    public List<RNS_EMP_MASTER> getAllRNS_EMP_MASTERS() {
        log.debug("REST request to get all RNS_EMP_MASTERS");
        return rNS_EMP_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-emp-masters/:id : get the "id" rNS_EMP_MASTER.
     *
     * @param id the id of the rNS_EMP_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_EMP_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-emp-masters/{id}")
    @Timed
    public ResponseEntity<RNS_EMP_MASTER> getRNS_EMP_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_EMP_MASTER : {}", id);
        RNS_EMP_MASTER rNS_EMP_MASTER = rNS_EMP_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_EMP_MASTER));
    }

    /**
     * DELETE  /rns-emp-masters/:id : delete the "id" rNS_EMP_MASTER.
     *
     * @param id the id of the rNS_EMP_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-emp-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_EMP_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_EMP_MASTER : {}", id);
        rNS_EMP_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
