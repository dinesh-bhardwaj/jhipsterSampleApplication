package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_PCH_MASTER;
import io.github.jhipster.application.repository.RNS_PCH_MASTERRepository;
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
 * Test class for the RNS_PCH_MASTERResource REST controller.
 *
 * @see RNS_PCH_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_PCH_MASTERResourceIntTest {

    private static final String DEFAULT_P_CHCODE = "AAAAAAAAAA";
    private static final String UPDATED_P_CHCODE = "BBBBBBBBBB";

    private static final String DEFAULT_P_CHNAME = "AAAAAAAAAA";
    private static final String UPDATED_P_CHNAME = "BBBBBBBBBB";

    @Autowired
    private RNS_PCH_MASTERRepository rNS_PCH_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_PCH_MASTERMockMvc;

    private RNS_PCH_MASTER rNS_PCH_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_PCH_MASTERResource rNS_PCH_MASTERResource = new RNS_PCH_MASTERResource(rNS_PCH_MASTERRepository);
        this.restRNS_PCH_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_PCH_MASTERResource)
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
    public static RNS_PCH_MASTER createEntity(EntityManager em) {
        RNS_PCH_MASTER rNS_PCH_MASTER = new RNS_PCH_MASTER()
            .pCHCODE(DEFAULT_P_CHCODE)
            .pCHNAME(DEFAULT_P_CHNAME);
        return rNS_PCH_MASTER;
    }

    @Before
    public void initTest() {
        rNS_PCH_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_PCH_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_PCH_MASTERRepository.findAll().size();

        // Create the RNS_PCH_MASTER
        restRNS_PCH_MASTERMockMvc.perform(post("/api/rns-pch-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PCH_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_PCH_MASTER in the database
        List<RNS_PCH_MASTER> rNS_PCH_MASTERList = rNS_PCH_MASTERRepository.findAll();
        assertThat(rNS_PCH_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_PCH_MASTER testRNS_PCH_MASTER = rNS_PCH_MASTERList.get(rNS_PCH_MASTERList.size() - 1);
        assertThat(testRNS_PCH_MASTER.getpCHCODE()).isEqualTo(DEFAULT_P_CHCODE);
        assertThat(testRNS_PCH_MASTER.getpCHNAME()).isEqualTo(DEFAULT_P_CHNAME);
    }

    @Test
    @Transactional
    public void createRNS_PCH_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_PCH_MASTERRepository.findAll().size();

        // Create the RNS_PCH_MASTER with an existing ID
        rNS_PCH_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_PCH_MASTERMockMvc.perform(post("/api/rns-pch-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PCH_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_PCH_MASTER in the database
        List<RNS_PCH_MASTER> rNS_PCH_MASTERList = rNS_PCH_MASTERRepository.findAll();
        assertThat(rNS_PCH_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_PCH_MASTERS() throws Exception {
        // Initialize the database
        rNS_PCH_MASTERRepository.saveAndFlush(rNS_PCH_MASTER);

        // Get all the rNS_PCH_MASTERList
        restRNS_PCH_MASTERMockMvc.perform(get("/api/rns-pch-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_PCH_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].pCHCODE").value(hasItem(DEFAULT_P_CHCODE.toString())))
            .andExpect(jsonPath("$.[*].pCHNAME").value(hasItem(DEFAULT_P_CHNAME.toString())));
    }

    @Test
    @Transactional
    public void getRNS_PCH_MASTER() throws Exception {
        // Initialize the database
        rNS_PCH_MASTERRepository.saveAndFlush(rNS_PCH_MASTER);

        // Get the rNS_PCH_MASTER
        restRNS_PCH_MASTERMockMvc.perform(get("/api/rns-pch-masters/{id}", rNS_PCH_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_PCH_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.pCHCODE").value(DEFAULT_P_CHCODE.toString()))
            .andExpect(jsonPath("$.pCHNAME").value(DEFAULT_P_CHNAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_PCH_MASTER() throws Exception {
        // Get the rNS_PCH_MASTER
        restRNS_PCH_MASTERMockMvc.perform(get("/api/rns-pch-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_PCH_MASTER() throws Exception {
        // Initialize the database
        rNS_PCH_MASTERRepository.saveAndFlush(rNS_PCH_MASTER);
        int databaseSizeBeforeUpdate = rNS_PCH_MASTERRepository.findAll().size();

        // Update the rNS_PCH_MASTER
        RNS_PCH_MASTER updatedRNS_PCH_MASTER = rNS_PCH_MASTERRepository.findOne(rNS_PCH_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_PCH_MASTER are not directly saved in db
        em.detach(updatedRNS_PCH_MASTER);
        updatedRNS_PCH_MASTER
            .pCHCODE(UPDATED_P_CHCODE)
            .pCHNAME(UPDATED_P_CHNAME);

        restRNS_PCH_MASTERMockMvc.perform(put("/api/rns-pch-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_PCH_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_PCH_MASTER in the database
        List<RNS_PCH_MASTER> rNS_PCH_MASTERList = rNS_PCH_MASTERRepository.findAll();
        assertThat(rNS_PCH_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_PCH_MASTER testRNS_PCH_MASTER = rNS_PCH_MASTERList.get(rNS_PCH_MASTERList.size() - 1);
        assertThat(testRNS_PCH_MASTER.getpCHCODE()).isEqualTo(UPDATED_P_CHCODE);
        assertThat(testRNS_PCH_MASTER.getpCHNAME()).isEqualTo(UPDATED_P_CHNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_PCH_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_PCH_MASTERRepository.findAll().size();

        // Create the RNS_PCH_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_PCH_MASTERMockMvc.perform(put("/api/rns-pch-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PCH_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_PCH_MASTER in the database
        List<RNS_PCH_MASTER> rNS_PCH_MASTERList = rNS_PCH_MASTERRepository.findAll();
        assertThat(rNS_PCH_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_PCH_MASTER() throws Exception {
        // Initialize the database
        rNS_PCH_MASTERRepository.saveAndFlush(rNS_PCH_MASTER);
        int databaseSizeBeforeDelete = rNS_PCH_MASTERRepository.findAll().size();

        // Get the rNS_PCH_MASTER
        restRNS_PCH_MASTERMockMvc.perform(delete("/api/rns-pch-masters/{id}", rNS_PCH_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_PCH_MASTER> rNS_PCH_MASTERList = rNS_PCH_MASTERRepository.findAll();
        assertThat(rNS_PCH_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_PCH_MASTER.class);
        RNS_PCH_MASTER rNS_PCH_MASTER1 = new RNS_PCH_MASTER();
        rNS_PCH_MASTER1.setId(1L);
        RNS_PCH_MASTER rNS_PCH_MASTER2 = new RNS_PCH_MASTER();
        rNS_PCH_MASTER2.setId(rNS_PCH_MASTER1.getId());
        assertThat(rNS_PCH_MASTER1).isEqualTo(rNS_PCH_MASTER2);
        rNS_PCH_MASTER2.setId(2L);
        assertThat(rNS_PCH_MASTER1).isNotEqualTo(rNS_PCH_MASTER2);
        rNS_PCH_MASTER1.setId(null);
        assertThat(rNS_PCH_MASTER1).isNotEqualTo(rNS_PCH_MASTER2);
    }
}
