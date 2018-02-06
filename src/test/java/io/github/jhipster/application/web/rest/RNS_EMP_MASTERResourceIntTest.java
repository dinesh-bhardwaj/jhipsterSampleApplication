package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_EMP_MASTER;
import io.github.jhipster.application.repository.RNS_EMP_MASTERRepository;
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
 * Test class for the RNS_EMP_MASTERResource REST controller.
 *
 * @see RNS_EMP_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_EMP_MASTERResourceIntTest {

    private static final String DEFAULT_E_MPCODE = "AAAAAAAAAA";
    private static final String UPDATED_E_MPCODE = "BBBBBBBBBB";

    private static final String DEFAULT_E_MPNAME = "AAAAAAAAAA";
    private static final String UPDATED_E_MPNAME = "BBBBBBBBBB";

    @Autowired
    private RNS_EMP_MASTERRepository rNS_EMP_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_EMP_MASTERMockMvc;

    private RNS_EMP_MASTER rNS_EMP_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_EMP_MASTERResource rNS_EMP_MASTERResource = new RNS_EMP_MASTERResource(rNS_EMP_MASTERRepository);
        this.restRNS_EMP_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_EMP_MASTERResource)
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
    public static RNS_EMP_MASTER createEntity(EntityManager em) {
        RNS_EMP_MASTER rNS_EMP_MASTER = new RNS_EMP_MASTER()
            .eMPCODE(DEFAULT_E_MPCODE)
            .eMPNAME(DEFAULT_E_MPNAME);
        return rNS_EMP_MASTER;
    }

    @Before
    public void initTest() {
        rNS_EMP_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_EMP_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_EMP_MASTERRepository.findAll().size();

        // Create the RNS_EMP_MASTER
        restRNS_EMP_MASTERMockMvc.perform(post("/api/rns-emp-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_EMP_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_EMP_MASTER in the database
        List<RNS_EMP_MASTER> rNS_EMP_MASTERList = rNS_EMP_MASTERRepository.findAll();
        assertThat(rNS_EMP_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_EMP_MASTER testRNS_EMP_MASTER = rNS_EMP_MASTERList.get(rNS_EMP_MASTERList.size() - 1);
        assertThat(testRNS_EMP_MASTER.geteMPCODE()).isEqualTo(DEFAULT_E_MPCODE);
        assertThat(testRNS_EMP_MASTER.geteMPNAME()).isEqualTo(DEFAULT_E_MPNAME);
    }

    @Test
    @Transactional
    public void createRNS_EMP_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_EMP_MASTERRepository.findAll().size();

        // Create the RNS_EMP_MASTER with an existing ID
        rNS_EMP_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_EMP_MASTERMockMvc.perform(post("/api/rns-emp-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_EMP_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_EMP_MASTER in the database
        List<RNS_EMP_MASTER> rNS_EMP_MASTERList = rNS_EMP_MASTERRepository.findAll();
        assertThat(rNS_EMP_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_EMP_MASTERS() throws Exception {
        // Initialize the database
        rNS_EMP_MASTERRepository.saveAndFlush(rNS_EMP_MASTER);

        // Get all the rNS_EMP_MASTERList
        restRNS_EMP_MASTERMockMvc.perform(get("/api/rns-emp-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_EMP_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].eMPCODE").value(hasItem(DEFAULT_E_MPCODE.toString())))
            .andExpect(jsonPath("$.[*].eMPNAME").value(hasItem(DEFAULT_E_MPNAME.toString())));
    }

    @Test
    @Transactional
    public void getRNS_EMP_MASTER() throws Exception {
        // Initialize the database
        rNS_EMP_MASTERRepository.saveAndFlush(rNS_EMP_MASTER);

        // Get the rNS_EMP_MASTER
        restRNS_EMP_MASTERMockMvc.perform(get("/api/rns-emp-masters/{id}", rNS_EMP_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_EMP_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.eMPCODE").value(DEFAULT_E_MPCODE.toString()))
            .andExpect(jsonPath("$.eMPNAME").value(DEFAULT_E_MPNAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_EMP_MASTER() throws Exception {
        // Get the rNS_EMP_MASTER
        restRNS_EMP_MASTERMockMvc.perform(get("/api/rns-emp-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_EMP_MASTER() throws Exception {
        // Initialize the database
        rNS_EMP_MASTERRepository.saveAndFlush(rNS_EMP_MASTER);
        int databaseSizeBeforeUpdate = rNS_EMP_MASTERRepository.findAll().size();

        // Update the rNS_EMP_MASTER
        RNS_EMP_MASTER updatedRNS_EMP_MASTER = rNS_EMP_MASTERRepository.findOne(rNS_EMP_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_EMP_MASTER are not directly saved in db
        em.detach(updatedRNS_EMP_MASTER);
        updatedRNS_EMP_MASTER
            .eMPCODE(UPDATED_E_MPCODE)
            .eMPNAME(UPDATED_E_MPNAME);

        restRNS_EMP_MASTERMockMvc.perform(put("/api/rns-emp-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_EMP_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_EMP_MASTER in the database
        List<RNS_EMP_MASTER> rNS_EMP_MASTERList = rNS_EMP_MASTERRepository.findAll();
        assertThat(rNS_EMP_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_EMP_MASTER testRNS_EMP_MASTER = rNS_EMP_MASTERList.get(rNS_EMP_MASTERList.size() - 1);
        assertThat(testRNS_EMP_MASTER.geteMPCODE()).isEqualTo(UPDATED_E_MPCODE);
        assertThat(testRNS_EMP_MASTER.geteMPNAME()).isEqualTo(UPDATED_E_MPNAME);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_EMP_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_EMP_MASTERRepository.findAll().size();

        // Create the RNS_EMP_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_EMP_MASTERMockMvc.perform(put("/api/rns-emp-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_EMP_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_EMP_MASTER in the database
        List<RNS_EMP_MASTER> rNS_EMP_MASTERList = rNS_EMP_MASTERRepository.findAll();
        assertThat(rNS_EMP_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_EMP_MASTER() throws Exception {
        // Initialize the database
        rNS_EMP_MASTERRepository.saveAndFlush(rNS_EMP_MASTER);
        int databaseSizeBeforeDelete = rNS_EMP_MASTERRepository.findAll().size();

        // Get the rNS_EMP_MASTER
        restRNS_EMP_MASTERMockMvc.perform(delete("/api/rns-emp-masters/{id}", rNS_EMP_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_EMP_MASTER> rNS_EMP_MASTERList = rNS_EMP_MASTERRepository.findAll();
        assertThat(rNS_EMP_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_EMP_MASTER.class);
        RNS_EMP_MASTER rNS_EMP_MASTER1 = new RNS_EMP_MASTER();
        rNS_EMP_MASTER1.setId(1L);
        RNS_EMP_MASTER rNS_EMP_MASTER2 = new RNS_EMP_MASTER();
        rNS_EMP_MASTER2.setId(rNS_EMP_MASTER1.getId());
        assertThat(rNS_EMP_MASTER1).isEqualTo(rNS_EMP_MASTER2);
        rNS_EMP_MASTER2.setId(2L);
        assertThat(rNS_EMP_MASTER1).isNotEqualTo(rNS_EMP_MASTER2);
        rNS_EMP_MASTER1.setId(null);
        assertThat(rNS_EMP_MASTER1).isNotEqualTo(rNS_EMP_MASTER2);
    }
}
