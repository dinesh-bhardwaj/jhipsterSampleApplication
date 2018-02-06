package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_REFR_DETAILS;

import io.github.jhipster.application.repository.RNS_REFR_DETAILSRepository;
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
 * REST controller for managing RNS_REFR_DETAILS.
 */
@RestController
@RequestMapping("/api")
public class RNS_REFR_DETAILSResource {

    private final Logger log = LoggerFactory.getLogger(RNS_REFR_DETAILSResource.class);

    private static final String ENTITY_NAME = "rNS_REFR_DETAILS";

    private final RNS_REFR_DETAILSRepository rNS_REFR_DETAILSRepository;

    public RNS_REFR_DETAILSResource(RNS_REFR_DETAILSRepository rNS_REFR_DETAILSRepository) {
        this.rNS_REFR_DETAILSRepository = rNS_REFR_DETAILSRepository;
    }

    /**
     * POST  /rns-refr-details : Create a new rNS_REFR_DETAILS.
     *
     * @param rNS_REFR_DETAILS the rNS_REFR_DETAILS to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_REFR_DETAILS, or with status 400 (Bad Request) if the rNS_REFR_DETAILS has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-refr-details")
    @Timed
    public ResponseEntity<RNS_REFR_DETAILS> createRNS_REFR_DETAILS(@RequestBody RNS_REFR_DETAILS rNS_REFR_DETAILS) throws URISyntaxException {
        log.debug("REST request to save RNS_REFR_DETAILS : {}", rNS_REFR_DETAILS);
        if (rNS_REFR_DETAILS.getId() != null) {
            throw new BadRequestAlertException("A new rNS_REFR_DETAILS cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_REFR_DETAILS result = rNS_REFR_DETAILSRepository.save(rNS_REFR_DETAILS);
        return ResponseEntity.created(new URI("/api/rns-refr-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-refr-details : Updates an existing rNS_REFR_DETAILS.
     *
     * @param rNS_REFR_DETAILS the rNS_REFR_DETAILS to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_REFR_DETAILS,
     * or with status 400 (Bad Request) if the rNS_REFR_DETAILS is not valid,
     * or with status 500 (Internal Server Error) if the rNS_REFR_DETAILS couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-refr-details")
    @Timed
    public ResponseEntity<RNS_REFR_DETAILS> updateRNS_REFR_DETAILS(@RequestBody RNS_REFR_DETAILS rNS_REFR_DETAILS) throws URISyntaxException {
        log.debug("REST request to update RNS_REFR_DETAILS : {}", rNS_REFR_DETAILS);
        if (rNS_REFR_DETAILS.getId() == null) {
            return createRNS_REFR_DETAILS(rNS_REFR_DETAILS);
        }
        RNS_REFR_DETAILS result = rNS_REFR_DETAILSRepository.save(rNS_REFR_DETAILS);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_REFR_DETAILS.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-refr-details : get all the rNS_REFR_DETAILS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_REFR_DETAILS in body
     */
    @GetMapping("/rns-refr-details")
    @Timed
    public List<RNS_REFR_DETAILS> getAllRNS_REFR_DETAILS() {
        log.debug("REST request to get all RNS_REFR_DETAILS");
        return rNS_REFR_DETAILSRepository.findAll();
        }

    /**
     * GET  /rns-refr-details/:id : get the "id" rNS_REFR_DETAILS.
     *
     * @param id the id of the rNS_REFR_DETAILS to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_REFR_DETAILS, or with status 404 (Not Found)
     */
    @GetMapping("/rns-refr-details/{id}")
    @Timed
    public ResponseEntity<RNS_REFR_DETAILS> getRNS_REFR_DETAILS(@PathVariable Long id) {
        log.debug("REST request to get RNS_REFR_DETAILS : {}", id);
        RNS_REFR_DETAILS rNS_REFR_DETAILS = rNS_REFR_DETAILSRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_REFR_DETAILS));
    }

    /**
     * DELETE  /rns-refr-details/:id : delete the "id" rNS_REFR_DETAILS.
     *
     * @param id the id of the rNS_REFR_DETAILS to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-refr-details/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_REFR_DETAILS(@PathVariable Long id) {
        log.debug("REST request to delete RNS_REFR_DETAILS : {}", id);
        rNS_REFR_DETAILSRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
