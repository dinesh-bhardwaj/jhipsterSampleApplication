package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_CRM_REQUEST_MASTER;
import io.github.jhipster.application.repository.RNS_CRM_REQUEST_MASTERRepository;
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
 * Test class for the RNS_CRM_REQUEST_MASTERResource REST controller.
 *
 * @see RNS_CRM_REQUEST_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_CRM_REQUEST_MASTERResourceIntTest {

    private static final Integer DEFAULT_C_RMCODE = 1;
    private static final Integer UPDATED_C_RMCODE = 2;

    private static final String DEFAULT_B_UYERCODE = "AAAAAAAAAA";
    private static final String UPDATED_B_UYERCODE = "BBBBBBBBBB";

    private static final String DEFAULT_B_UYERNAME = "AAAAAAAAAA";
    private static final String UPDATED_B_UYERNAME = "BBBBBBBBBB";

    @Autowired
    private RNS_CRM_REQUEST_MASTERRepository rNS_CRM_REQUEST_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_CRM_REQUEST_MASTERMockMvc;

    private RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_CRM_REQUEST_MASTERResource rNS_CRM_REQUEST_MASTERResource = new RNS_CRM_REQUEST_MASTERResource(rNS_CRM_REQUEST_MASTERRepository);
        this.restRNS_CRM_REQUEST_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_CRM_REQUEST_MASTERResource)
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
    public static RNS_CRM_REQUEST_MASTER createEntity(EntityManager em) {
        RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER = new RNS_CRM_REQUEST_MASTER()
            .cRMCODE(DEFAULT_C_RMCODE)
            .bUYERCODE(DEFAULT_B_UYERCODE)
            .bUYERNAME(DEFAULT_B_UYERNAME);
        return rNS_CRM_REQUEST_MASTER;
    }

    @Before
    public void initTest() {
        rNS_CRM_REQUEST_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_CRM_REQUEST_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_CRM_REQUEST_MASTERRepository.findAll().size();

        // Create the RNS_CRM_REQUEST_MASTER
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(post("/api/rns-crm-request-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CRM_REQUEST_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_CRM_REQUEST_MASTER in the database
        List<RNS_CRM_REQUEST_MASTER> rNS_CRM_REQUEST_MASTERList = rNS_CRM_REQUEST_MASTERRepository.findAll();
        assertThat(rNS_CRM_REQUEST_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_CRM_REQUEST_MASTER testRNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERList.get(rNS_CRM_REQUEST_MASTERList.size() - 1);
        assertThat(testRNS_CRM_REQUEST_MASTER.getcRMCODE()).isEqualTo(DEFAULT_C_RMCODE);
        assertThat(testRNS_CRM_REQUEST_MASTER.getbUYERCODE()).isEqualTo(DEFAULT_B_UYERCODE);
        assertThat(testRNS_CRM_REQUEST_MASTER.getbUYERNAME()).isEqualTo(DEFAULT_B_UYERNAME);
    }

    @Test
    @Transactional
    public void createRNS_CRM_REQUEST_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_CRM_REQUEST_MASTERRepository.findAll().size();

        // Create the RNS_CRM_REQUEST_MASTER with an existing ID
        rNS_CRM_REQUEST_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(post("/api/rns-crm-request-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CRM_REQUEST_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_CRM_REQUEST_MASTER in the database
        List<RNS_CRM_REQUEST_MASTER> rNS_CRM_REQUEST_MASTERList = rNS_CRM_REQUEST_MASTERRepository.findAll();
        assertThat(rNS_CRM_REQUEST_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_CRM_REQUEST_MASTERS() throws Exception {
        // Initialize the database
        rNS_CRM_REQUEST_MASTERRepository.saveAndFlush(rNS_CRM_REQUEST_MASTER);

        // Get all the rNS_CRM_REQUEST_MASTERList
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(get("/api/rns-crm-request-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_CRM_REQUEST_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].cRMCODE").value(hasItem(DEFAULT_C_RMCODE)))
            .andExpect(jsonPath("$.[*].bUYERCODE").value(hasItem(DEFAULT_B_UYERCODE.toString())))
            .andExpect(jsonPath("$.[*].bUYERNAME").value(hasItem(DEFAULT_B_UYERNAME.toString())));
    }

    @Test
    @Transactional
    public void getRNS_CRM_REQUEST_MASTER() throws Exception {
        // Initialize the database
        rNS_CRM_REQUEST_MASTERRepository.saveAndFlush(rNS_CRM_REQUEST_MASTER);

        // Get the rNS_CRM_REQUEST_MASTER
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(get("/api/rns-crm-request-masters/{id}", rNS_CRM_REQUEST_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_CRM_REQUEST_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.cRMCODE").value(DEFAULT_C_RMCODE))
            .andExpect(jsonPath("$.bUYERCODE").value(DEFAULT_B_UYERCODE.toString()))
            .andExpect(jsonPath("$.bUYERNAME").value(DEFAULT_B_UYERNAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_CRM_REQUEST_MASTER() throws Exception {
        // Get the rNS_CRM_REQUEST_MASTER
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(get("/api/rns-crm-request-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_CRM_REQUEST_MASTER() throws Exception {
        // Initialize the database
        rNS_CRM_REQUEST_MASTERRepository.saveAndFlush(rNS_CRM_REQUEST_MASTER);
        int databaseSizeBeforeUpdate = rNS_CRM_REQUEST_MASTERRepository.findAll().size();

        // Update the rNS_CRM_REQUEST_MASTER
        RNS_CRM_REQUEST_MASTER updatedRNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERRepository.findOne(rNS_CRM_REQUEST_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_CRM_REQUEST_MASTER are not directly saved in db
        em.detach(updatedRNS_CRM_REQUEST_MASTER);
        updatedRNS_CRM_REQUEST_MASTER
            .cRMCODE(UPDATED_C_RMCODE)
            .bUYERCODE(UPDATED_B_UYERCODE)
            .bUYERNAME(UPDATED_B_UYERNAME);

        restRNS_CRM_REQUEST_MASTERMockMvc.perform(put("/api/rns-crm-request-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_CRM_REQUEST_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_CRM_REQUEST_MASTER in the database
        List<RNS_CRM_REQUEST_MASTER> rNS_CRM_REQUEST_MASTERList = rNS_CRM_REQUEST_MASTERRepository.findAll();
        assertThat(rNS_CRM_REQUEST_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_CRM_REQUEST_MASTER testRNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERList.get(rNS_CRM_REQUEST_MASTERList.size() - 1);
        assertThat(testRNS_CRM_REQUEST_MASTER.getcRMCODE()).isEqualTo(UPDATED_C_RMCODE);
        assertThat(testRNS_CRM_REQUEST_MASTER.getbUYERCODE()).isEqualTo(UPDATED_B_UYERCODE);
        assertThat(testRNS_CRM_REQUEST_MASTER.getbUYERNAME()).isEqualTo(UPDATED_B_UYERNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_CRM_REQUEST_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_CRM_REQUEST_MASTERRepository.findAll().size();

        // Create the RNS_CRM_REQUEST_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(put("/api/rns-crm-request-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_CRM_REQUEST_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_CRM_REQUEST_MASTER in the database
        List<RNS_CRM_REQUEST_MASTER> rNS_CRM_REQUEST_MASTERList = rNS_CRM_REQUEST_MASTERRepository.findAll();
        assertThat(rNS_CRM_REQUEST_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_CRM_REQUEST_MASTER() throws Exception {
        // Initialize the database
        rNS_CRM_REQUEST_MASTERRepository.saveAndFlush(rNS_CRM_REQUEST_MASTER);
        int databaseSizeBeforeDelete = rNS_CRM_REQUEST_MASTERRepository.findAll().size();

        // Get the rNS_CRM_REQUEST_MASTER
        restRNS_CRM_REQUEST_MASTERMockMvc.perform(delete("/api/rns-crm-request-masters/{id}", rNS_CRM_REQUEST_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_CRM_REQUEST_MASTER> rNS_CRM_REQUEST_MASTERList = rNS_CRM_REQUEST_MASTERRepository.findAll();
        assertThat(rNS_CRM_REQUEST_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_CRM_REQUEST_MASTER.class);
        RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER1 = new RNS_CRM_REQUEST_MASTER();
        rNS_CRM_REQUEST_MASTER1.setId(1L);
        RNS_CRM_REQUEST_MASTER rNS_CRM_REQUEST_MASTER2 = new RNS_CRM_REQUEST_MASTER();
        rNS_CRM_REQUEST_MASTER2.setId(rNS_CRM_REQUEST_MASTER1.getId());
        assertThat(rNS_CRM_REQUEST_MASTER1).isEqualTo(rNS_CRM_REQUEST_MASTER2);
        rNS_CRM_REQUEST_MASTER2.setId(2L);
        assertThat(rNS_CRM_REQUEST_MASTER1).isNotEqualTo(rNS_CRM_REQUEST_MASTER2);
        rNS_CRM_REQUEST_MASTER1.setId(null);
        assertThat(rNS_CRM_REQUEST_MASTER1).isNotEqualTo(rNS_CRM_REQUEST_MASTER2);
    }
}
