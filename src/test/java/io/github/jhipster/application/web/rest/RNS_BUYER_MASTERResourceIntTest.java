package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_BUYER_MASTER;
import io.github.jhipster.application.repository.RNS_BUYER_MASTERRepository;
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
 * Test class for the RNS_BUYER_MASTERResource REST controller.
 *
 * @see RNS_BUYER_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_BUYER_MASTERResourceIntTest {

    private static final String DEFAULT_B_UYERCODE = "AAAAAAAAAA";
    private static final String UPDATED_B_UYERCODE = "BBBBBBBBBB";

    private static final String DEFAULT_B_UYERNAME = "AAAAAAAAAA";
    private static final String UPDATED_B_UYERNAME = "BBBBBBBBBB";

    @Autowired
    private RNS_BUYER_MASTERRepository rNS_BUYER_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_BUYER_MASTERMockMvc;

    private RNS_BUYER_MASTER rNS_BUYER_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_BUYER_MASTERResource rNS_BUYER_MASTERResource = new RNS_BUYER_MASTERResource(rNS_BUYER_MASTERRepository);
        this.restRNS_BUYER_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_BUYER_MASTERResource)
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
    public static RNS_BUYER_MASTER createEntity(EntityManager em) {
        RNS_BUYER_MASTER rNS_BUYER_MASTER = new RNS_BUYER_MASTER()
            .bUYERCODE(DEFAULT_B_UYERCODE)
            .bUYERNAME(DEFAULT_B_UYERNAME);
        return rNS_BUYER_MASTER;
    }

    @Before
    public void initTest() {
        rNS_BUYER_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_BUYER_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_BUYER_MASTERRepository.findAll().size();

        // Create the RNS_BUYER_MASTER
        restRNS_BUYER_MASTERMockMvc.perform(post("/api/rns-buyer-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_BUYER_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_BUYER_MASTER in the database
        List<RNS_BUYER_MASTER> rNS_BUYER_MASTERList = rNS_BUYER_MASTERRepository.findAll();
        assertThat(rNS_BUYER_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_BUYER_MASTER testRNS_BUYER_MASTER = rNS_BUYER_MASTERList.get(rNS_BUYER_MASTERList.size() - 1);
        assertThat(testRNS_BUYER_MASTER.getbUYERCODE()).isEqualTo(DEFAULT_B_UYERCODE);
        assertThat(testRNS_BUYER_MASTER.getbUYERNAME()).isEqualTo(DEFAULT_B_UYERNAME);
    }

    @Test
    @Transactional
    public void createRNS_BUYER_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_BUYER_MASTERRepository.findAll().size();

        // Create the RNS_BUYER_MASTER with an existing ID
        rNS_BUYER_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_BUYER_MASTERMockMvc.perform(post("/api/rns-buyer-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_BUYER_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_BUYER_MASTER in the database
        List<RNS_BUYER_MASTER> rNS_BUYER_MASTERList = rNS_BUYER_MASTERRepository.findAll();
        assertThat(rNS_BUYER_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_BUYER_MASTERS() throws Exception {
        // Initialize the database
        rNS_BUYER_MASTERRepository.saveAndFlush(rNS_BUYER_MASTER);

        // Get all the rNS_BUYER_MASTERList
        restRNS_BUYER_MASTERMockMvc.perform(get("/api/rns-buyer-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_BUYER_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].bUYERCODE").value(hasItem(DEFAULT_B_UYERCODE.toString())))
            .andExpect(jsonPath("$.[*].bUYERNAME").value(hasItem(DEFAULT_B_UYERNAME.toString())));
    }

    @Test
    @Transactional
    public void getRNS_BUYER_MASTER() throws Exception {
        // Initialize the database
        rNS_BUYER_MASTERRepository.saveAndFlush(rNS_BUYER_MASTER);

        // Get the rNS_BUYER_MASTER
        restRNS_BUYER_MASTERMockMvc.perform(get("/api/rns-buyer-masters/{id}", rNS_BUYER_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_BUYER_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.bUYERCODE").value(DEFAULT_B_UYERCODE.toString()))
            .andExpect(jsonPath("$.bUYERNAME").value(DEFAULT_B_UYERNAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_BUYER_MASTER() throws Exception {
        // Get the rNS_BUYER_MASTER
        restRNS_BUYER_MASTERMockMvc.perform(get("/api/rns-buyer-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_BUYER_MASTER() throws Exception {
        // Initialize the database
        rNS_BUYER_MASTERRepository.saveAndFlush(rNS_BUYER_MASTER);
        int databaseSizeBeforeUpdate = rNS_BUYER_MASTERRepository.findAll().size();

        // Update the rNS_BUYER_MASTER
        RNS_BUYER_MASTER updatedRNS_BUYER_MASTER = rNS_BUYER_MASTERRepository.findOne(rNS_BUYER_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_BUYER_MASTER are not directly saved in db
        em.detach(updatedRNS_BUYER_MASTER);
        updatedRNS_BUYER_MASTER
            .bUYERCODE(UPDATED_B_UYERCODE)
            .bUYERNAME(UPDATED_B_UYERNAME);

        restRNS_BUYER_MASTERMockMvc.perform(put("/api/rns-buyer-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_BUYER_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_BUYER_MASTER in the database
        List<RNS_BUYER_MASTER> rNS_BUYER_MASTERList = rNS_BUYER_MASTERRepository.findAll();
        assertThat(rNS_BUYER_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_BUYER_MASTER testRNS_BUYER_MASTER = rNS_BUYER_MASTERList.get(rNS_BUYER_MASTERList.size() - 1);
        assertThat(testRNS_BUYER_MASTER.getbUYERCODE()).isEqualTo(UPDATED_B_UYERCODE);
        assertThat(testRNS_BUYER_MASTER.getbUYERNAME()).isEqualTo(UPDATED_B_UYERNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_BUYER_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_BUYER_MASTERRepository.findAll().size();

        // Create the RNS_BUYER_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_BUYER_MASTERMockMvc.perform(put("/api/rns-buyer-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_BUYER_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_BUYER_MASTER in the database
        List<RNS_BUYER_MASTER> rNS_BUYER_MASTERList = rNS_BUYER_MASTERRepository.findAll();
        assertThat(rNS_BUYER_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_BUYER_MASTER() throws Exception {
        // Initialize the database
        rNS_BUYER_MASTERRepository.saveAndFlush(rNS_BUYER_MASTER);
        int databaseSizeBeforeDelete = rNS_BUYER_MASTERRepository.findAll().size();

        // Get the rNS_BUYER_MASTER
        restRNS_BUYER_MASTERMockMvc.perform(delete("/api/rns-buyer-masters/{id}", rNS_BUYER_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_BUYER_MASTER> rNS_BUYER_MASTERList = rNS_BUYER_MASTERRepository.findAll();
        assertThat(rNS_BUYER_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_BUYER_MASTER.class);
        RNS_BUYER_MASTER rNS_BUYER_MASTER1 = new RNS_BUYER_MASTER();
        rNS_BUYER_MASTER1.setId(1L);
        RNS_BUYER_MASTER rNS_BUYER_MASTER2 = new RNS_BUYER_MASTER();
        rNS_BUYER_MASTER2.setId(rNS_BUYER_MASTER1.getId());
        assertThat(rNS_BUYER_MASTER1).isEqualTo(rNS_BUYER_MASTER2);
        rNS_BUYER_MASTER2.setId(2L);
        assertThat(rNS_BUYER_MASTER1).isNotEqualTo(rNS_BUYER_MASTER2);
        rNS_BUYER_MASTER1.setId(null);
        assertThat(rNS_BUYER_MASTER1).isNotEqualTo(rNS_BUYER_MASTER2);
    }
}
