package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_PAY_TERMS_MASTER;

import io.github.jhipster.application.repository.RNS_PAY_TERMS_MASTERRepository;
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
 * REST controller for managing RNS_PAY_TERMS_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_PAY_TERMS_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_PAY_TERMS_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_PAY_TERMS_MASTER";

    private final RNS_PAY_TERMS_MASTERRepository rNS_PAY_TERMS_MASTERRepository;

    public RNS_PAY_TERMS_MASTERResource(RNS_PAY_TERMS_MASTERRepository rNS_PAY_TERMS_MASTERRepository) {
        this.rNS_PAY_TERMS_MASTERRepository = rNS_PAY_TERMS_MASTERRepository;
    }

    /**
     * POST  /rns-pay-terms-masters : Create a new rNS_PAY_TERMS_MASTER.
     *
     * @param rNS_PAY_TERMS_MASTER the rNS_PAY_TERMS_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_PAY_TERMS_MASTER, or with status 400 (Bad Request) if the rNS_PAY_TERMS_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-pay-terms-masters")
    @Timed
    public ResponseEntity<RNS_PAY_TERMS_MASTER> createRNS_PAY_TERMS_MASTER(@RequestBody RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_PAY_TERMS_MASTER : {}", rNS_PAY_TERMS_MASTER);
        if (rNS_PAY_TERMS_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_PAY_TERMS_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_PAY_TERMS_MASTER result = rNS_PAY_TERMS_MASTERRepository.save(rNS_PAY_TERMS_MASTER);
        return ResponseEntity.created(new URI("/api/rns-pay-terms-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-pay-terms-masters : Updates an existing rNS_PAY_TERMS_MASTER.
     *
     * @param rNS_PAY_TERMS_MASTER the rNS_PAY_TERMS_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_PAY_TERMS_MASTER,
     * or with status 400 (Bad Request) if the rNS_PAY_TERMS_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_PAY_TERMS_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-pay-terms-masters")
    @Timed
    public ResponseEntity<RNS_PAY_TERMS_MASTER> updateRNS_PAY_TERMS_MASTER(@RequestBody RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_PAY_TERMS_MASTER : {}", rNS_PAY_TERMS_MASTER);
        if (rNS_PAY_TERMS_MASTER.getId() == null) {
            return createRNS_PAY_TERMS_MASTER(rNS_PAY_TERMS_MASTER);
        }
        RNS_PAY_TERMS_MASTER result = rNS_PAY_TERMS_MASTERRepository.save(rNS_PAY_TERMS_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_PAY_TERMS_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-pay-terms-masters : get all the rNS_PAY_TERMS_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_PAY_TERMS_MASTERS in body
     */
    @GetMapping("/rns-pay-terms-masters")
    @Timed
    public List<RNS_PAY_TERMS_MASTER> getAllRNS_PAY_TERMS_MASTERS() {
        log.debug("REST request to get all RNS_PAY_TERMS_MASTERS");
        return rNS_PAY_TERMS_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-pay-terms-masters/:id : get the "id" rNS_PAY_TERMS_MASTER.
     *
     * @param id the id of the rNS_PAY_TERMS_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_PAY_TERMS_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-pay-terms-masters/{id}")
    @Timed
    public ResponseEntity<RNS_PAY_TERMS_MASTER> getRNS_PAY_TERMS_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_PAY_TERMS_MASTER : {}", id);
        RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_PAY_TERMS_MASTER));
    }

    /**
     * DELETE  /rns-pay-terms-masters/:id : delete the "id" rNS_PAY_TERMS_MASTER.
     *
     * @param id the id of the rNS_PAY_TERMS_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-pay-terms-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_PAY_TERMS_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_PAY_TERMS_MASTER : {}", id);
        rNS_PAY_TERMS_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
