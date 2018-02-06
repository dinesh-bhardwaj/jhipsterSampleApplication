package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_CRM_REQUEST_MASTER;

import io.github.jhipster.application.repository.RNS_CRM_REQUEST_MASTERRepository;
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
 * REST controller for managing RNS_CRM_REQUEST_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_CRM_REQUEST_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_CRM_REQUEST_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_CRM_REQUEST_MASTER";

    private final RNS_CRM_REQUEST_MASTERRepository rNS_CRM_REQUEST_MASTERRepository;

    public RNS_CRM_REQUEST_MASTERResource(RNS_CRM_REQUEST_MASTERRepository rNS_CRM_REQUEST_MASTERRepository) {
        this.rNS_CRM_REQUEST_MASTERRepository = rNS_CRM_REQUEST_MASTERRepository;
    }

    /**
     * POST  /rns-crm-request-masters : Create a new rNS_CRM_REQUEST_MASTER.
     *
     * @param rNS_CRM_REQUEST_MASTER the rNS_CRM_REQUEST_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_CRM_REQUEST_MASTER, or with status 400 (Bad Request) if the rNS_CRM_REQUEST_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-crm-request-masters")
    @Timed
    public ResponseEntity<RNS_CRM_REQUEST_MASTER> createRNS_CRM_REQUEST_MASTER(@RequestBody RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_CRM_REQUEST_MASTER : {}", rNS_CRM_REQUEST_MASTER);
        if (rNS_CRM_REQUEST_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_CRM_REQUEST_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_CRM_REQUEST_MASTER result = rNS_CRM_REQUEST_MASTERRepository.save(rNS_CRM_REQUEST_MASTER);
        return ResponseEntity.created(new URI("/api/rns-crm-request-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-crm-request-masters : Updates an existing rNS_CRM_REQUEST_MASTER.
     *
     * @param rNS_CRM_REQUEST_MASTER the rNS_CRM_REQUEST_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_CRM_REQUEST_MASTER,
     * or with status 400 (Bad Request) if the rNS_CRM_REQUEST_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_CRM_REQUEST_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-crm-request-masters")
    @Timed
    public ResponseEntity<RNS_CRM_REQUEST_MASTER> updateRNS_CRM_REQUEST_MASTER(@RequestBody RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_CRM_REQUEST_MASTER : {}", rNS_CRM_REQUEST_MASTER);
        if (rNS_CRM_REQUEST_MASTER.getId() == null) {
            return createRNS_CRM_REQUEST_MASTER(rNS_CRM_REQUEST_MASTER);
        }
        RNS_CRM_REQUEST_MASTER result = rNS_CRM_REQUEST_MASTERRepository.save(rNS_CRM_REQUEST_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_CRM_REQUEST_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-crm-request-masters : get all the rNS_CRM_REQUEST_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_CRM_REQUEST_MASTERS in body
     */
    @GetMapping("/rns-crm-request-masters")
    @Timed
    public List<RNS_CRM_REQUEST_MASTER> getAllRNS_CRM_REQUEST_MASTERS() {
        log.debug("REST request to get all RNS_CRM_REQUEST_MASTERS");
        return rNS_CRM_REQUEST_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-crm-request-masters/:id : get the "id" rNS_CRM_REQUEST_MASTER.
     *
     * @param id the id of the rNS_CRM_REQUEST_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_CRM_REQUEST_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-crm-request-masters/{id}")
    @Timed
    public ResponseEntity<RNS_CRM_REQUEST_MASTER> getRNS_CRM_REQUEST_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_CRM_REQUEST_MASTER : {}", id);
        RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_CRM_REQUEST_MASTER));
    }

    /**
     * DELETE  /rns-crm-request-masters/:id : delete the "id" rNS_CRM_REQUEST_MASTER.
     *
     * @param id the id of the rNS_CRM_REQUEST_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-crm-request-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_CRM_REQUEST_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_CRM_REQUEST_MASTER : {}", id);
        rNS_CRM_REQUEST_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
