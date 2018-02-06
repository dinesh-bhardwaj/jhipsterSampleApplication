package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_PAY_TERMS_MASTER;
import io.github.jhipster.application.repository.RNS_PAY_TERMS_MASTERRepository;
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
 * Test class for the RNS_PAY_TERMS_MASTERResource REST controller.
 *
 * @see RNS_PAY_TERMS_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_PAY_TERMS_MASTERResourceIntTest {

    private static final String DEFAULT_P_AYTERMSCODE = "AAAAAAAAAA";
    private static final String UPDATED_P_AYTERMSCODE = "BBBBBBBBBB";

    private static final String DEFAULT_P_AYTERMSCODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_P_AYTERMSCODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_PAY_TERMS_MASTERRepository rNS_PAY_TERMS_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_PAY_TERMS_MASTERMockMvc;

    private RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_PAY_TERMS_MASTERResource rNS_PAY_TERMS_MASTERResource = new RNS_PAY_TERMS_MASTERResource(rNS_PAY_TERMS_MASTERRepository);
        this.restRNS_PAY_TERMS_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_PAY_TERMS_MASTERResource)
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
    public static RNS_PAY_TERMS_MASTER createEntity(EntityManager em) {
        RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER = new RNS_PAY_TERMS_MASTER()
            .pAYTERMSCODE(DEFAULT_P_AYTERMSCODE)
            .pAYTERMSCODEDESC(DEFAULT_P_AYTERMSCODEDESC);
        return rNS_PAY_TERMS_MASTER;
    }

    @Before
    public void initTest() {
        rNS_PAY_TERMS_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_PAY_TERMS_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_PAY_TERMS_MASTERRepository.findAll().size();

        // Create the RNS_PAY_TERMS_MASTER
        restRNS_PAY_TERMS_MASTERMockMvc.perform(post("/api/rns-pay-terms-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PAY_TERMS_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_PAY_TERMS_MASTER in the database
        List<RNS_PAY_TERMS_MASTER> rNS_PAY_TERMS_MASTERList = rNS_PAY_TERMS_MASTERRepository.findAll();
        assertThat(rNS_PAY_TERMS_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_PAY_TERMS_MASTER testRNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERList.get(rNS_PAY_TERMS_MASTERList.size() - 1);
        assertThat(testRNS_PAY_TERMS_MASTER.getpAYTERMSCODE()).isEqualTo(DEFAULT_P_AYTERMSCODE);
        assertThat(testRNS_PAY_TERMS_MASTER.getpAYTERMSCODEDESC()).isEqualTo(DEFAULT_P_AYTERMSCODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_PAY_TERMS_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_PAY_TERMS_MASTERRepository.findAll().size();

        // Create the RNS_PAY_TERMS_MASTER with an existing ID
        rNS_PAY_TERMS_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_PAY_TERMS_MASTERMockMvc.perform(post("/api/rns-pay-terms-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PAY_TERMS_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_PAY_TERMS_MASTER in the database
        List<RNS_PAY_TERMS_MASTER> rNS_PAY_TERMS_MASTERList = rNS_PAY_TERMS_MASTERRepository.findAll();
        assertThat(rNS_PAY_TERMS_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_PAY_TERMS_MASTERS() throws Exception {
        // Initialize the database
        rNS_PAY_TERMS_MASTERRepository.saveAndFlush(rNS_PAY_TERMS_MASTER);

        // Get all the rNS_PAY_TERMS_MASTERList
        restRNS_PAY_TERMS_MASTERMockMvc.perform(get("/api/rns-pay-terms-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_PAY_TERMS_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].pAYTERMSCODE").value(hasItem(DEFAULT_P_AYTERMSCODE.toString())))
            .andExpect(jsonPath("$.[*].pAYTERMSCODEDESC").value(hasItem(DEFAULT_P_AYTERMSCODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_PAY_TERMS_MASTER() throws Exception {
        // Initialize the database
        rNS_PAY_TERMS_MASTERRepository.saveAndFlush(rNS_PAY_TERMS_MASTER);

        // Get the rNS_PAY_TERMS_MASTER
        restRNS_PAY_TERMS_MASTERMockMvc.perform(get("/api/rns-pay-terms-masters/{id}", rNS_PAY_TERMS_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_PAY_TERMS_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.pAYTERMSCODE").value(DEFAULT_P_AYTERMSCODE.toString()))
            .andExpect(jsonPath("$.pAYTERMSCODEDESC").value(DEFAULT_P_AYTERMSCODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_PAY_TERMS_MASTER() throws Exception {
        // Get the rNS_PAY_TERMS_MASTER
        restRNS_PAY_TERMS_MASTERMockMvc.perform(get("/api/rns-pay-terms-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_PAY_TERMS_MASTER() throws Exception {
        // Initialize the database
        rNS_PAY_TERMS_MASTERRepository.saveAndFlush(rNS_PAY_TERMS_MASTER);
        int databaseSizeBeforeUpdate = rNS_PAY_TERMS_MASTERRepository.findAll().size();

        // Update the rNS_PAY_TERMS_MASTER
        RNS_PAY_TERMS_MASTER updatedRNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERRepository.findOne(rNS_PAY_TERMS_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_PAY_TERMS_MASTER are not directly saved in db
        em.detach(updatedRNS_PAY_TERMS_MASTER);
        updatedRNS_PAY_TERMS_MASTER
            .pAYTERMSCODE(UPDATED_P_AYTERMSCODE)
            .pAYTERMSCODEDESC(UPDATED_P_AYTERMSCODEDESC);

        restRNS_PAY_TERMS_MASTERMockMvc.perform(put("/api/rns-pay-terms-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_PAY_TERMS_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_PAY_TERMS_MASTER in the database
        List<RNS_PAY_TERMS_MASTER> rNS_PAY_TERMS_MASTERList = rNS_PAY_TERMS_MASTERRepository.findAll();
        assertThat(rNS_PAY_TERMS_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_PAY_TERMS_MASTER testRNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERList.get(rNS_PAY_TERMS_MASTERList.size() - 1);
        assertThat(testRNS_PAY_TERMS_MASTER.getpAYTERMSCODE()).isEqualTo(UPDATED_P_AYTERMSCODE);
        assertThat(testRNS_PAY_TERMS_MASTER.getpAYTERMSCODEDESC()).isEqualTo(UPDATED_P_AYTERMSCODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_PAY_TERMS_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_PAY_TERMS_MASTERRepository.findAll().size();

        // Create the RNS_PAY_TERMS_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_PAY_TERMS_MASTERMockMvc.perform(put("/api/rns-pay-terms-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_PAY_TERMS_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_PAY_TERMS_MASTER in the database
        List<RNS_PAY_TERMS_MASTER> rNS_PAY_TERMS_MASTERList = rNS_PAY_TERMS_MASTERRepository.findAll();
        assertThat(rNS_PAY_TERMS_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_PAY_TERMS_MASTER() throws Exception {
        // Initialize the database
        rNS_PAY_TERMS_MASTERRepository.saveAndFlush(rNS_PAY_TERMS_MASTER);
        int databaseSizeBeforeDelete = rNS_PAY_TERMS_MASTERRepository.findAll().size();

        // Get the rNS_PAY_TERMS_MASTER
        restRNS_PAY_TERMS_MASTERMockMvc.perform(delete("/api/rns-pay-terms-masters/{id}", rNS_PAY_TERMS_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_PAY_TERMS_MASTER> rNS_PAY_TERMS_MASTERList = rNS_PAY_TERMS_MASTERRepository.findAll();
        assertThat(rNS_PAY_TERMS_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_PAY_TERMS_MASTER.class);
        RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER1 = new RNS_PAY_TERMS_MASTER();
        rNS_PAY_TERMS_MASTER1.setId(1L);
        RNS_PAY_TERMS_MASTER rNS_PAY_TERMS_MASTER2 = new RNS_PAY_TERMS_MASTER();
        rNS_PAY_TERMS_MASTER2.setId(rNS_PAY_TERMS_MASTER1.getId());
        assertThat(rNS_PAY_TERMS_MASTER1).isEqualTo(rNS_PAY_TERMS_MASTER2);
        rNS_PAY_TERMS_MASTER2.setId(2L);
        assertThat(rNS_PAY_TERMS_MASTER1).isNotEqualTo(rNS_PAY_TERMS_MASTER2);
        rNS_PAY_TERMS_MASTER1.setId(null);
        assertThat(rNS_PAY_TERMS_MASTER1).isNotEqualTo(rNS_PAY_TERMS_MASTER2);
    }
}
