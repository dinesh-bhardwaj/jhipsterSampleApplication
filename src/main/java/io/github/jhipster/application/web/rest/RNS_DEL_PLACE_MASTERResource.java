package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_DEL_PLACE_MASTER;

import io.github.jhipster.application.repository.RNS_DEL_PLACE_MASTERRepository;
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
 * REST controller for managing RNS_DEL_PLACE_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_DEL_PLACE_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_DEL_PLACE_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_DEL_PLACE_MASTER";

    private final RNS_DEL_PLACE_MASTERRepository rNS_DEL_PLACE_MASTERRepository;

    public RNS_DEL_PLACE_MASTERResource(RNS_DEL_PLACE_MASTERRepository rNS_DEL_PLACE_MASTERRepository) {
        this.rNS_DEL_PLACE_MASTERRepository = rNS_DEL_PLACE_MASTERRepository;
    }

    /**
     * POST  /rns-del-place-masters : Create a new rNS_DEL_PLACE_MASTER.
     *
     * @param rNS_DEL_PLACE_MASTER the rNS_DEL_PLACE_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_DEL_PLACE_MASTER, or with status 400 (Bad Request) if the rNS_DEL_PLACE_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-del-place-masters")
    @Timed
    public ResponseEntity<RNS_DEL_PLACE_MASTER> createRNS_DEL_PLACE_MASTER(@RequestBody RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_DEL_PLACE_MASTER : {}", rNS_DEL_PLACE_MASTER);
        if (rNS_DEL_PLACE_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_DEL_PLACE_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_DEL_PLACE_MASTER result = rNS_DEL_PLACE_MASTERRepository.save(rNS_DEL_PLACE_MASTER);
        return ResponseEntity.created(new URI("/api/rns-del-place-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-del-place-masters : Updates an existing rNS_DEL_PLACE_MASTER.
     *
     * @param rNS_DEL_PLACE_MASTER the rNS_DEL_PLACE_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_DEL_PLACE_MASTER,
     * or with status 400 (Bad Request) if the rNS_DEL_PLACE_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_DEL_PLACE_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-del-place-masters")
    @Timed
    public ResponseEntity<RNS_DEL_PLACE_MASTER> updateRNS_DEL_PLACE_MASTER(@RequestBody RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_DEL_PLACE_MASTER : {}", rNS_DEL_PLACE_MASTER);
        if (rNS_DEL_PLACE_MASTER.getId() == null) {
            return createRNS_DEL_PLACE_MASTER(rNS_DEL_PLACE_MASTER);
        }
        RNS_DEL_PLACE_MASTER result = rNS_DEL_PLACE_MASTERRepository.save(rNS_DEL_PLACE_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_DEL_PLACE_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-del-place-masters : get all the rNS_DEL_PLACE_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_DEL_PLACE_MASTERS in body
     */
    @GetMapping("/rns-del-place-masters")
    @Timed
    public List<RNS_DEL_PLACE_MASTER> getAllRNS_DEL_PLACE_MASTERS() {
        log.debug("REST request to get all RNS_DEL_PLACE_MASTERS");
        return rNS_DEL_PLACE_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-del-place-masters/:id : get the "id" rNS_DEL_PLACE_MASTER.
     *
     * @param id the id of the rNS_DEL_PLACE_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_DEL_PLACE_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-del-place-masters/{id}")
    @Timed
    public ResponseEntity<RNS_DEL_PLACE_MASTER> getRNS_DEL_PLACE_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_DEL_PLACE_MASTER : {}", id);
        RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_DEL_PLACE_MASTER));
    }

    /**
     * DELETE  /rns-del-place-masters/:id : delete the "id" rNS_DEL_PLACE_MASTER.
     *
     * @param id the id of the rNS_DEL_PLACE_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-del-place-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_DEL_PLACE_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_DEL_PLACE_MASTER : {}", id);
        rNS_DEL_PLACE_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
