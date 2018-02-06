package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_VENDOR_MASTER;

import io.github.jhipster.application.repository.RNS_VENDOR_MASTERRepository;
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
 * REST controller for managing RNS_VENDOR_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_VENDOR_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_VENDOR_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_VENDOR_MASTER";

    private final RNS_VENDOR_MASTERRepository rNS_VENDOR_MASTERRepository;

    public RNS_VENDOR_MASTERResource(RNS_VENDOR_MASTERRepository rNS_VENDOR_MASTERRepository) {
        this.rNS_VENDOR_MASTERRepository = rNS_VENDOR_MASTERRepository;
    }

    /**
     * POST  /rns-vendor-masters : Create a new rNS_VENDOR_MASTER.
     *
     * @param rNS_VENDOR_MASTER the rNS_VENDOR_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_VENDOR_MASTER, or with status 400 (Bad Request) if the rNS_VENDOR_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-vendor-masters")
    @Timed
    public ResponseEntity<RNS_VENDOR_MASTER> createRNS_VENDOR_MASTER(@RequestBody RNS_VENDOR_MASTER rNS_VENDOR_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_VENDOR_MASTER : {}", rNS_VENDOR_MASTER);
        if (rNS_VENDOR_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_VENDOR_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_VENDOR_MASTER result = rNS_VENDOR_MASTERRepository.save(rNS_VENDOR_MASTER);
        return ResponseEntity.created(new URI("/api/rns-vendor-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-vendor-masters : Updates an existing rNS_VENDOR_MASTER.
     *
     * @param rNS_VENDOR_MASTER the rNS_VENDOR_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_VENDOR_MASTER,
     * or with status 400 (Bad Request) if the rNS_VENDOR_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_VENDOR_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-vendor-masters")
    @Timed
    public ResponseEntity<RNS_VENDOR_MASTER> updateRNS_VENDOR_MASTER(@RequestBody RNS_VENDOR_MASTER rNS_VENDOR_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_VENDOR_MASTER : {}", rNS_VENDOR_MASTER);
        if (rNS_VENDOR_MASTER.getId() == null) {
            return createRNS_VENDOR_MASTER(rNS_VENDOR_MASTER);
        }
        RNS_VENDOR_MASTER result = rNS_VENDOR_MASTERRepository.save(rNS_VENDOR_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_VENDOR_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-vendor-masters : get all the rNS_VENDOR_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_VENDOR_MASTERS in body
     */
    @GetMapping("/rns-vendor-masters")
    @Timed
    public List<RNS_VENDOR_MASTER> getAllRNS_VENDOR_MASTERS() {
        log.debug("REST request to get all RNS_VENDOR_MASTERS");
        return rNS_VENDOR_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-vendor-masters/:id : get the "id" rNS_VENDOR_MASTER.
     *
     * @param id the id of the rNS_VENDOR_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_VENDOR_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-vendor-masters/{id}")
    @Timed
    public ResponseEntity<RNS_VENDOR_MASTER> getRNS_VENDOR_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_VENDOR_MASTER : {}", id);
        RNS_VENDOR_MASTER rNS_VENDOR_MASTER = rNS_VENDOR_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_VENDOR_MASTER));
    }

    /**
     * DELETE  /rns-vendor-masters/:id : delete the "id" rNS_VENDOR_MASTER.
     *
     * @param id the id of the rNS_VENDOR_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-vendor-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_VENDOR_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_VENDOR_MASTER : {}", id);
        rNS_VENDOR_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
