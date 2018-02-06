package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_SECTOR_MASTER;
import io.github.jhipster.application.repository.RNS_SECTOR_MASTERRepository;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the RNS_SECTOR_MASTERResource REST controller.
 *
 * @see RNS_SECTOR_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_SECTOR_MASTERResourceIntTest {

    private static final String DEFAULT_R_NSCATGCODE = "AAAAAAAAAA";
    private static final String UPDATED_R_NSCATGCODE = "BBBBBBBBBB";

    private static final String DEFAULT_S_ECTORCODE = "AAAAAAAAAA";
    private static final String UPDATED_S_ECTORCODE = "BBBBBBBBBB";

    private static final String DEFAULT_S_ECTORCODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_S_ECTORCODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_SECTOR_MASTERRepository rNS_SECTOR_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_SECTOR_MASTERMockMvc;

    private RNS_SECTOR_MASTER rNS_SECTOR_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_SECTOR_MASTERResource rNS_SECTOR_MASTERResource = new RNS_SECTOR_MASTERResource(rNS_SECTOR_MASTERRepository);
        this.restRNS_SECTOR_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_SECTOR_MASTERResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RNS_SECTOR_MASTER createEntity(EntityManager em) {
        RNS_SECTOR_MASTER rNS_SECTOR_MASTER = new RNS_SECTOR_MASTER()
            .rNSCATGCODE(DEFAULT_R_NSCATGCODE)
            .sECTORCODE(DEFAULT_S_ECTORCODE)
            .sECTORCODEDESC(DEFAULT_S_ECTORCODEDESC);
        return rNS_SECTOR_MASTER;
    }

    @Before
    public void initTest() {
        rNS_SECTOR_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_SECTOR_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_SECTOR_MASTERRepository.findAll().size();

        // Create the RNS_SECTOR_MASTER
        restRNS_SECTOR_MASTERMockMvc.perform(post("/api/rns-sector-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_SECTOR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_SECTOR_MASTER in the database
        List<RNS_SECTOR_MASTER> rNS_SECTOR_MASTERList = rNS_SECTOR_MASTERRepository.findAll();
        assertThat(rNS_SECTOR_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_SECTOR_MASTER testRNS_SECTOR_MASTER = rNS_SECTOR_MASTERList.get(rNS_SECTOR_MASTERList.size() - 1);
        assertThat(testRNS_SECTOR_MASTER.getrNSCATGCODE()).isEqualTo(DEFAULT_R_NSCATGCODE);
        assertThat(testRNS_SECTOR_MASTER.getsECTORCODE()).isEqualTo(DEFAULT_S_ECTORCODE);
        assertThat(testRNS_SECTOR_MASTER.getsECTORCODEDESC()).isEqualTo(DEFAULT_S_ECTORCODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_SECTOR_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_SECTOR_MASTERRepository.findAll().size();

        // Create the RNS_SECTOR_MASTER with an existing ID
        rNS_SECTOR_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_SECTOR_MASTERMockMvc.perform(post("/api/rns-sector-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_SECTOR_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_SECTOR_MASTER in the database
        List<RNS_SECTOR_MASTER> rNS_SECTOR_MASTERList = rNS_SECTOR_MASTERRepository.findAll();
        assertThat(rNS_SECTOR_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_SECTOR_MASTERS() throws Exception {
        // Initialize the database
        rNS_SECTOR_MASTERRepository.saveAndFlush(rNS_SECTOR_MASTER);

        // Get all the rNS_SECTOR_MASTERList
        restRNS_SECTOR_MASTERMockMvc.perform(get("/api/rns-sector-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_SECTOR_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].rNSCATGCODE").value(hasItem(DEFAULT_R_NSCATGCODE.toString())))
            .andExpect(jsonPath("$.[*].sECTORCODE").value(hasItem(DEFAULT_S_ECTORCODE.toString())))
            .andExpect(jsonPath("$.[*].sECTORCODEDESC").value(hasItem(DEFAULT_S_ECTORCODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_SECTOR_MASTER() throws Exception {
        // Initialize the database
        rNS_SECTOR_MASTERRepository.saveAndFlush(rNS_SECTOR_MASTER);

        // Get the rNS_SECTOR_MASTER
        restRNS_SECTOR_MASTERMockMvc.perform(get("/api/rns-sector-masters/{id}", rNS_SECTOR_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_SECTOR_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.rNSCATGCODE").value(DEFAULT_R_NSCATGCODE.toString()))
            .andExpect(jsonPath("$.sECTORCODE").value(DEFAULT_S_ECTORCODE.toString()))
            .andExpect(jsonPath("$.sECTORCODEDESC").value(DEFAULT_S_ECTORCODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_SECTOR_MASTER() throws Exception {
        // Get the rNS_SECTOR_MASTER
        restRNS_SECTOR_MASTERMockMvc.perform(get("/api/rns-sector-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_SECTOR_MASTER() throws Exception {
        // Initialize the database
        rNS_SECTOR_MASTERRepository.saveAndFlush(rNS_SECTOR_MASTER);
        int databaseSizeBeforeUpdate = rNS_SECTOR_MASTERRepository.findAll().size();

        // Update the rNS_SECTOR_MASTER
        RNS_SECTOR_MASTER updatedRNS_SECTOR_MASTER = rNS_SECTOR_MASTERRepository.findOne(rNS_SECTOR_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_SECTOR_MASTER are not directly saved in db
        em.detach(updatedRNS_SECTOR_MASTER);
        updatedRNS_SECTOR_MASTER
            .rNSCATGCODE(UPDATED_R_NSCATGCODE)
            .sECTORCODE(UPDATED_S_ECTORCODE)
            .sECTORCODEDESC(UPDATED_S_ECTORCODEDESC);

        restRNS_SECTOR_MASTERMockMvc.perform(put("/api/rns-sector-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_SECTOR_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_SECTOR_MASTER in the database
        List<RNS_SECTOR_MASTER> rNS_SECTOR_MASTERList = rNS_SECTOR_MASTERRepository.findAll();
        assertThat(rNS_SECTOR_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_SECTOR_MASTER testRNS_SECTOR_MASTER = rNS_SECTOR_MASTERList.get(rNS_SECTOR_MASTERList.size() - 1);
        assertThat(testRNS_SECTOR_MASTER.getrNSCATGCODE()).isEqualTo(UPDATED_R_NSCATGCODE);
        assertThat(testRNS_SECTOR_MASTER.getsECTORCODE()).isEqualTo(UPDATED_S_ECTORCODE);
        assertThat(testRNS_SECTOR_MASTER.getsECTORCODEDESC()).isEqualTo(UPDATED_S_ECTORCODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_SECTOR_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_SECTOR_MASTERRepository.findAll().size();

        // Create the RNS_SECTOR_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_SECTOR_MASTERMockMvc.perform(put("/api/rns-sector-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_SECTOR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_SECTOR_MASTER in the database
        List<RNS_SECTOR_MASTER> rNS_SECTOR_MASTERList = rNS_SECTOR_MASTERRepository.findAll();
        assertThat(rNS_SECTOR_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_SECTOR_MASTER() throws Exception {
        // Initialize the database
        rNS_SECTOR_MASTERRepository.saveAndFlush(rNS_SECTOR_MASTER);
        int databaseSizeBeforeDelete = rNS_SECTOR_MASTERRepository.findAll().size();

        // Get the rNS_SECTOR_MASTER
        restRNS_SECTOR_MASTERMockMvc.perform(delete("/api/rns-sector-masters/{id}", rNS_SECTOR_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_SECTOR_MASTER> rNS_SECTOR_MASTERList = rNS_SECTOR_MASTERRepository.findAll();
        assertThat(rNS_SECTOR_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_SECTOR_MASTER.class);
        RNS_SECTOR_MASTER rNS_SECTOR_MASTER1 = new RNS_SECTOR_MASTER();
        rNS_SECTOR_MASTER1.setId(1L);
        RNS_SECTOR_MASTER rNS_SECTOR_MASTER2 = new RNS_SECTOR_MASTER();
        rNS_SECTOR_MASTER2.setId(rNS_SECTOR_MASTER1.getId());
        assertThat(rNS_SECTOR_MASTER1).isEqualTo(rNS_SECTOR_MASTER2);
        rNS_SECTOR_MASTER2.setId(2L);
        assertThat(rNS_SECTOR_MASTER1).isNotEqualTo(rNS_SECTOR_MASTER2);
        rNS_SECTOR_MASTER1.setId(null);
        assertThat(rNS_SECTOR_MASTER1).isNotEqualTo(rNS_SECTOR_MASTER2);
    }
}
