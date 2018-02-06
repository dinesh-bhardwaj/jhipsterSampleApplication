package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_DEL_PLACE_MASTER;
import io.github.jhipster.application.repository.RNS_DEL_PLACE_MASTERRepository;
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
 * Test class for the RNS_DEL_PLACE_MASTERResource REST controller.
 *
 * @see RNS_DEL_PLACE_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_DEL_PLACE_MASTERResourceIntTest {

    private static final String DEFAULT_C_ODE = "AAAAAAAAAA";
    private static final String UPDATED_C_ODE = "BBBBBBBBBB";

    private static final String DEFAULT_C_ODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_C_ODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_DEL_PLACE_MASTERRepository rNS_DEL_PLACE_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_DEL_PLACE_MASTERMockMvc;

    private RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_DEL_PLACE_MASTERResource rNS_DEL_PLACE_MASTERResource = new RNS_DEL_PLACE_MASTERResource(rNS_DEL_PLACE_MASTERRepository);
        this.restRNS_DEL_PLACE_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_DEL_PLACE_MASTERResource)
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
    public static RNS_DEL_PLACE_MASTER createEntity(EntityManager em) {
        RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER = new RNS_DEL_PLACE_MASTER()
            .cODE(DEFAULT_C_ODE)
            .cODEDESC(DEFAULT_C_ODEDESC);
        return rNS_DEL_PLACE_MASTER;
    }

    @Before
    public void initTest() {
        rNS_DEL_PLACE_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_DEL_PLACE_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_DEL_PLACE_MASTERRepository.findAll().size();

        // Create the RNS_DEL_PLACE_MASTER
        restRNS_DEL_PLACE_MASTERMockMvc.perform(post("/api/rns-del-place-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_DEL_PLACE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_DEL_PLACE_MASTER in the database
        List<RNS_DEL_PLACE_MASTER> rNS_DEL_PLACE_MASTERList = rNS_DEL_PLACE_MASTERRepository.findAll();
        assertThat(rNS_DEL_PLACE_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_DEL_PLACE_MASTER testRNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERList.get(rNS_DEL_PLACE_MASTERList.size() - 1);
        assertThat(testRNS_DEL_PLACE_MASTER.getcODE()).isEqualTo(DEFAULT_C_ODE);
        assertThat(testRNS_DEL_PLACE_MASTER.getcODEDESC()).isEqualTo(DEFAULT_C_ODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_DEL_PLACE_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_DEL_PLACE_MASTERRepository.findAll().size();

        // Create the RNS_DEL_PLACE_MASTER with an existing ID
        rNS_DEL_PLACE_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_DEL_PLACE_MASTERMockMvc.perform(post("/api/rns-del-place-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_DEL_PLACE_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_DEL_PLACE_MASTER in the database
        List<RNS_DEL_PLACE_MASTER> rNS_DEL_PLACE_MASTERList = rNS_DEL_PLACE_MASTERRepository.findAll();
        assertThat(rNS_DEL_PLACE_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_DEL_PLACE_MASTERS() throws Exception {
        // Initialize the database
        rNS_DEL_PLACE_MASTERRepository.saveAndFlush(rNS_DEL_PLACE_MASTER);

        // Get all the rNS_DEL_PLACE_MASTERList
        restRNS_DEL_PLACE_MASTERMockMvc.perform(get("/api/rns-del-place-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_DEL_PLACE_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].cODE").value(hasItem(DEFAULT_C_ODE.toString())))
            .andExpect(jsonPath("$.[*].cODEDESC").value(hasItem(DEFAULT_C_ODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_DEL_PLACE_MASTER() throws Exception {
        // Initialize the database
        rNS_DEL_PLACE_MASTERRepository.saveAndFlush(rNS_DEL_PLACE_MASTER);

        // Get the rNS_DEL_PLACE_MASTER
        restRNS_DEL_PLACE_MASTERMockMvc.perform(get("/api/rns-del-place-masters/{id}", rNS_DEL_PLACE_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_DEL_PLACE_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.cODE").value(DEFAULT_C_ODE.toString()))
            .andExpect(jsonPath("$.cODEDESC").value(DEFAULT_C_ODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_DEL_PLACE_MASTER() throws Exception {
        // Get the rNS_DEL_PLACE_MASTER
        restRNS_DEL_PLACE_MASTERMockMvc.perform(get("/api/rns-del-place-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_DEL_PLACE_MASTER() throws Exception {
        // Initialize the database
        rNS_DEL_PLACE_MASTERRepository.saveAndFlush(rNS_DEL_PLACE_MASTER);
        int databaseSizeBeforeUpdate = rNS_DEL_PLACE_MASTERRepository.findAll().size();

        // Update the rNS_DEL_PLACE_MASTER
        RNS_DEL_PLACE_MASTER updatedRNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERRepository.findOne(rNS_DEL_PLACE_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_DEL_PLACE_MASTER are not directly saved in db
        em.detach(updatedRNS_DEL_PLACE_MASTER);
        updatedRNS_DEL_PLACE_MASTER
            .cODE(UPDATED_C_ODE)
            .cODEDESC(UPDATED_C_ODEDESC);

        restRNS_DEL_PLACE_MASTERMockMvc.perform(put("/api/rns-del-place-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_DEL_PLACE_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_DEL_PLACE_MASTER in the database
        List<RNS_DEL_PLACE_MASTER> rNS_DEL_PLACE_MASTERList = rNS_DEL_PLACE_MASTERRepository.findAll();
        assertThat(rNS_DEL_PLACE_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_DEL_PLACE_MASTER testRNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERList.get(rNS_DEL_PLACE_MASTERList.size() - 1);
        assertThat(testRNS_DEL_PLACE_MASTER.getcODE()).isEqualTo(UPDATED_C_ODE);
        assertThat(testRNS_DEL_PLACE_MASTER.getcODEDESC()).isEqualTo(UPDATED_C_ODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_DEL_PLACE_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_DEL_PLACE_MASTERRepository.findAll().size();

        // Create the RNS_DEL_PLACE_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_DEL_PLACE_MASTERMockMvc.perform(put("/api/rns-del-place-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_DEL_PLACE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_DEL_PLACE_MASTER in the database
        List<RNS_DEL_PLACE_MASTER> rNS_DEL_PLACE_MASTERList = rNS_DEL_PLACE_MASTERRepository.findAll();
        assertThat(rNS_DEL_PLACE_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_DEL_PLACE_MASTER() throws Exception {
        // Initialize the database
        rNS_DEL_PLACE_MASTERRepository.saveAndFlush(rNS_DEL_PLACE_MASTER);
        int databaseSizeBeforeDelete = rNS_DEL_PLACE_MASTERRepository.findAll().size();

        // Get the rNS_DEL_PLACE_MASTER
        restRNS_DEL_PLACE_MASTERMockMvc.perform(delete("/api/rns-del-place-masters/{id}", rNS_DEL_PLACE_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_DEL_PLACE_MASTER> rNS_DEL_PLACE_MASTERList = rNS_DEL_PLACE_MASTERRepository.findAll();
        assertThat(rNS_DEL_PLACE_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_DEL_PLACE_MASTER.class);
        RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER1 = new RNS_DEL_PLACE_MASTER();
        rNS_DEL_PLACE_MASTER1.setId(1L);
        RNS_DEL_PLACE_MASTER rNS_DEL_PLACE_MASTER2 = new RNS_DEL_PLACE_MASTER();
        rNS_DEL_PLACE_MASTER2.setId(rNS_DEL_PLACE_MASTER1.getId());
        assertThat(rNS_DEL_PLACE_MASTER1).isEqualTo(rNS_DEL_PLACE_MASTER2);
        rNS_DEL_PLACE_MASTER2.setId(2L);
        assertThat(rNS_DEL_PLACE_MASTER1).isNotEqualTo(rNS_DEL_PLACE_MASTER2);
        rNS_DEL_PLACE_MASTER1.setId(null);
        assertThat(rNS_DEL_PLACE_MASTER1).isNotEqualTo(rNS_DEL_PLACE_MASTER2);
    }
}
