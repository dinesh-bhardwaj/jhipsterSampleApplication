package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_CATG_MASTER;
import io.github.jhipster.application.repository.RNS_CATG_MASTERRepository;
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
 * Test class for the RNS_CATG_MASTERResource REST controller.
 *
 * @see RNS_CATG_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_CATG_MASTERResourceIntTest {

    private static final String DEFAULT_C_ATGCODE = "AAAAAAAAAA";
    private static final String UPDATED_C_ATGCODE = "BBBBBBBBBB";

    private static final String DEFAULT_C_ATGCODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_C_ATGCODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_CATG_MASTERRepository rNS_CATG_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_CATG_MASTERMockMvc;

    private RNS_CATG_MASTER rNS_CATG_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_CATG_MASTERResource rNS_CATG_MASTERResource = new RNS_CATG_MASTERResource(rNS_CATG_MASTERRepository);
        this.restRNS_CATG_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_CATG_MASTERResource)
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
    public static RNS_CATG_MASTER createEntity(EntityManager em) {
        RNS_CATG_MASTER rNS_CATG_MASTER = new RNS_CATG_MASTER()
            .cATGCODE(DEFAULT_C_ATGCODE)
            .cATGCODEDESC(DEFAULT_C_ATGCODEDESC);
        return rNS_CATG_MASTER;
    }

    @Before
    public void initTest() {
        rNS_CATG_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_CATG_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_CATG_MASTERRepository.findAll().size();

        // Create the RNS_CATG_MASTER
        restRNS_CATG_MASTERMockMvc.perform(post("/api/rns-catg-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CATG_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_CATG_MASTER in the database
        List<RNS_CATG_MASTER> rNS_CATG_MASTERList = rNS_CATG_MASTERRepository.findAll();
        assertThat(rNS_CATG_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_CATG_MASTER testRNS_CATG_MASTER = rNS_CATG_MASTERList.get(rNS_CATG_MASTERList.size() - 1);
        assertThat(testRNS_CATG_MASTER.getcATGCODE()).isEqualTo(DEFAULT_C_ATGCODE);
        assertThat(testRNS_CATG_MASTER.getcATGCODEDESC()).isEqualTo(DEFAULT_C_ATGCODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_CATG_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_CATG_MASTERRepository.findAll().size();

        // Create the RNS_CATG_MASTER with an existing ID
        rNS_CATG_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_CATG_MASTERMockMvc.perform(post("/api/rns-catg-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CATG_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_CATG_MASTER in the database
        List<RNS_CATG_MASTER> rNS_CATG_MASTERList = rNS_CATG_MASTERRepository.findAll();
        assertThat(rNS_CATG_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_CATG_MASTERS() throws Exception {
        // Initialize the database
        rNS_CATG_MASTERRepository.saveAndFlush(rNS_CATG_MASTER);

        // Get all the rNS_CATG_MASTERList
        restRNS_CATG_MASTERMockMvc.perform(get("/api/rns-catg-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_CATG_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].cATGCODE").value(hasItem(DEFAULT_C_ATGCODE.toString())))
            .andExpect(jsonPath("$.[*].cATGCODEDESC").value(hasItem(DEFAULT_C_ATGCODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_CATG_MASTER() throws Exception {
        // Initialize the database
        rNS_CATG_MASTERRepository.saveAndFlush(rNS_CATG_MASTER);

        // Get the rNS_CATG_MASTER
        restRNS_CATG_MASTERMockMvc.perform(get("/api/rns-catg-masters/{id}", rNS_CATG_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_CATG_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.cATGCODE").value(DEFAULT_C_ATGCODE.toString()))
            .andExpect(jsonPath("$.cATGCODEDESC").value(DEFAULT_C_ATGCODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_CATG_MASTER() throws Exception {
        // Get the rNS_CATG_MASTER
        restRNS_CATG_MASTERMockMvc.perform(get("/api/rns-catg-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_CATG_MASTER() throws Exception {
        // Initialize the database
        rNS_CATG_MASTERRepository.saveAndFlush(rNS_CATG_MASTER);
        int databaseSizeBeforeUpdate = rNS_CATG_MASTERRepository.findAll().size();

        // Update the rNS_CATG_MASTER
        RNS_CATG_MASTER updatedRNS_CATG_MASTER = rNS_CATG_MASTERRepository.findOne(rNS_CATG_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_CATG_MASTER are not directly saved in db
        em.detach(updatedRNS_CATG_MASTER);
        updatedRNS_CATG_MASTER
            .cATGCODE(UPDATED_C_ATGCODE)
            .cATGCODEDESC(UPDATED_C_ATGCODEDESC);

        restRNS_CATG_MASTERMockMvc.perform(put("/api/rns-catg-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_CATG_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_CATG_MASTER in the database
        List<RNS_CATG_MASTER> rNS_CATG_MASTERList = rNS_CATG_MASTERRepository.findAll();
        assertThat(rNS_CATG_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_CATG_MASTER testRNS_CATG_MASTER = rNS_CATG_MASTERList.get(rNS_CATG_MASTERList.size() - 1);
        assertThat(testRNS_CATG_MASTER.getcATGCODE()).isEqualTo(UPDATED_C_ATGCODE);
        assertThat(testRNS_CATG_MASTER.getcATGCODEDESC()).isEqualTo(UPDATED_C_ATGCODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_CATG_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_CATG_MASTERRepository.findAll().size();

        // Create the RNS_CATG_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_CATG_MASTERMockMvc.perform(put("/api/rns-catg-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CATG_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_CATG_MASTER in the database
        List<RNS_CATG_MASTER> rNS_CATG_MASTERList = rNS_CATG_MASTERRepository.findAll();
        assertThat(rNS_CATG_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_CATG_MASTER() throws Exception {
        // Initialize the database
        rNS_CATG_MASTERRepository.saveAndFlush(rNS_CATG_MASTER);
        int databaseSizeBeforeDelete = rNS_CATG_MASTERRepository.findAll().size();

        // Get the rNS_CATG_MASTER
        restRNS_CATG_MASTERMockMvc.perform(delete("/api/rns-catg-masters/{id}", rNS_CATG_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_CATG_MASTER> rNS_CATG_MASTERList = rNS_CATG_MASTERRepository.findAll();
        assertThat(rNS_CATG_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_CATG_MASTER.class);
        RNS_CATG_MASTER rNS_CATG_MASTER1 = new RNS_CATG_MASTER();
        rNS_CATG_MASTER1.setId(1L);
        RNS_CATG_MASTER rNS_CATG_MASTER2 = new RNS_CATG_MASTER();
        rNS_CATG_MASTER2.setId(rNS_CATG_MASTER1.getId());
        assertThat(rNS_CATG_MASTER1).isEqualTo(rNS_CATG_MASTER2);
        rNS_CATG_MASTER2.setId(2L);
        assertThat(rNS_CATG_MASTER1).isNotEqualTo(rNS_CATG_MASTER2);
        rNS_CATG_MASTER1.setId(null);
        assertThat(rNS_CATG_MASTER1).isNotEqualTo(rNS_CATG_MASTER2);
    }
}
