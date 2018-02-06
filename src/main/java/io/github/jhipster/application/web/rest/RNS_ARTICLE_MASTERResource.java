package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_ARTICLE_MASTER;

import io.github.jhipster.application.repository.RNS_ARTICLE_MASTERRepository;
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
 * REST controller for managing RNS_ARTICLE_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_ARTICLE_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_ARTICLE_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_ARTICLE_MASTER";

    private final RNS_ARTICLE_MASTERRepository rNS_ARTICLE_MASTERRepository;

    public RNS_ARTICLE_MASTERResource(RNS_ARTICLE_MASTERRepository rNS_ARTICLE_MASTERRepository) {
        this.rNS_ARTICLE_MASTERRepository = rNS_ARTICLE_MASTERRepository;
    }

    /**
     * POST  /rns-article-masters : Create a new rNS_ARTICLE_MASTER.
     *
     * @param rNS_ARTICLE_MASTER the rNS_ARTICLE_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_ARTICLE_MASTER, or with status 400 (Bad Request) if the rNS_ARTICLE_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-article-masters")
    @Timed
    public ResponseEntity<RNS_ARTICLE_MASTER> createRNS_ARTICLE_MASTER(@RequestBody RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_ARTICLE_MASTER : {}", rNS_ARTICLE_MASTER);
        if (rNS_ARTICLE_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_ARTICLE_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_ARTICLE_MASTER result = rNS_ARTICLE_MASTERRepository.save(rNS_ARTICLE_MASTER);
        return ResponseEntity.created(new URI("/api/rns-article-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-article-masters : Updates an existing rNS_ARTICLE_MASTER.
     *
     * @param rNS_ARTICLE_MASTER the rNS_ARTICLE_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_ARTICLE_MASTER,
     * or with status 400 (Bad Request) if the rNS_ARTICLE_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_ARTICLE_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-article-masters")
    @Timed
    public ResponseEntity<RNS_ARTICLE_MASTER> updateRNS_ARTICLE_MASTER(@RequestBody RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_ARTICLE_MASTER : {}", rNS_ARTICLE_MASTER);
        if (rNS_ARTICLE_MASTER.getId() == null) {
            return createRNS_ARTICLE_MASTER(rNS_ARTICLE_MASTER);
        }
        RNS_ARTICLE_MASTER result = rNS_ARTICLE_MASTERRepository.save(rNS_ARTICLE_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_ARTICLE_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-article-masters : get all the rNS_ARTICLE_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_ARTICLE_MASTERS in body
     */
    @GetMapping("/rns-article-masters")
    @Timed
    public List<RNS_ARTICLE_MASTER> getAllRNS_ARTICLE_MASTERS() {
        log.debug("REST request to get all RNS_ARTICLE_MASTERS");
        return rNS_ARTICLE_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-article-masters/:id : get the "id" rNS_ARTICLE_MASTER.
     *
     * @param id the id of the rNS_ARTICLE_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_ARTICLE_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-article-masters/{id}")
    @Timed
    public ResponseEntity<RNS_ARTICLE_MASTER> getRNS_ARTICLE_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_ARTICLE_MASTER : {}", id);
        RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_ARTICLE_MASTER));
    }

    /**
     * DELETE  /rns-article-masters/:id : delete the "id" rNS_ARTICLE_MASTER.
     *
     * @param id the id of the rNS_ARTICLE_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-article-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_ARTICLE_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_ARTICLE_MASTER : {}", id);
        rNS_ARTICLE_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
