package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_ARTICLE_MASTER;
import io.github.jhipster.application.repository.RNS_ARTICLE_MASTERRepository;
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
 * Test class for the RNS_ARTICLE_MASTERResource REST controller.
 *
 * @see RNS_ARTICLE_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_ARTICLE_MASTERResourceIntTest {

    private static final String DEFAULT_A_RTICLECODE = "AAAAAAAAAA";
    private static final String UPDATED_A_RTICLECODE = "BBBBBBBBBB";

    private static final String DEFAULT_A_RTICLECODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_A_RTICLECODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_ARTICLE_MASTERRepository rNS_ARTICLE_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_ARTICLE_MASTERMockMvc;

    private RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_ARTICLE_MASTERResource rNS_ARTICLE_MASTERResource = new RNS_ARTICLE_MASTERResource(rNS_ARTICLE_MASTERRepository);
        this.restRNS_ARTICLE_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_ARTICLE_MASTERResource)
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
    public static RNS_ARTICLE_MASTER createEntity(EntityManager em) {
        RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER = new RNS_ARTICLE_MASTER()
            .aRTICLECODE(DEFAULT_A_RTICLECODE)
            .aRTICLECODEDESC(DEFAULT_A_RTICLECODEDESC);
        return rNS_ARTICLE_MASTER;
    }

    @Before
    public void initTest() {
        rNS_ARTICLE_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_ARTICLE_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_ARTICLE_MASTERRepository.findAll().size();

        // Create the RNS_ARTICLE_MASTER
        restRNS_ARTICLE_MASTERMockMvc.perform(post("/api/rns-article-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_ARTICLE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_ARTICLE_MASTER in the database
        List<RNS_ARTICLE_MASTER> rNS_ARTICLE_MASTERList = rNS_ARTICLE_MASTERRepository.findAll();
        assertThat(rNS_ARTICLE_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_ARTICLE_MASTER testRNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERList.get(rNS_ARTICLE_MASTERList.size() - 1);
        assertThat(testRNS_ARTICLE_MASTER.getaRTICLECODE()).isEqualTo(DEFAULT_A_RTICLECODE);
        assertThat(testRNS_ARTICLE_MASTER.getaRTICLECODEDESC()).isEqualTo(DEFAULT_A_RTICLECODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_ARTICLE_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_ARTICLE_MASTERRepository.findAll().size();

        // Create the RNS_ARTICLE_MASTER with an existing ID
        rNS_ARTICLE_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_ARTICLE_MASTERMockMvc.perform(post("/api/rns-article-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_ARTICLE_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_ARTICLE_MASTER in the database
        List<RNS_ARTICLE_MASTER> rNS_ARTICLE_MASTERList = rNS_ARTICLE_MASTERRepository.findAll();
        assertThat(rNS_ARTICLE_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_ARTICLE_MASTERS() throws Exception {
        // Initialize the database
        rNS_ARTICLE_MASTERRepository.saveAndFlush(rNS_ARTICLE_MASTER);

        // Get all the rNS_ARTICLE_MASTERList
        restRNS_ARTICLE_MASTERMockMvc.perform(get("/api/rns-article-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_ARTICLE_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].aRTICLECODE").value(hasItem(DEFAULT_A_RTICLECODE.toString())))
            .andExpect(jsonPath("$.[*].aRTICLECODEDESC").value(hasItem(DEFAULT_A_RTICLECODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_ARTICLE_MASTER() throws Exception {
        // Initialize the database
        rNS_ARTICLE_MASTERRepository.saveAndFlush(rNS_ARTICLE_MASTER);

        // Get the rNS_ARTICLE_MASTER
        restRNS_ARTICLE_MASTERMockMvc.perform(get("/api/rns-article-masters/{id}", rNS_ARTICLE_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_ARTICLE_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.aRTICLECODE").value(DEFAULT_A_RTICLECODE.toString()))
            .andExpect(jsonPath("$.aRTICLECODEDESC").value(DEFAULT_A_RTICLECODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_ARTICLE_MASTER() throws Exception {
        // Get the rNS_ARTICLE_MASTER
        restRNS_ARTICLE_MASTERMockMvc.perform(get("/api/rns-article-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_ARTICLE_MASTER() throws Exception {
        // Initialize the database
        rNS_ARTICLE_MASTERRepository.saveAndFlush(rNS_ARTICLE_MASTER);
        int databaseSizeBeforeUpdate = rNS_ARTICLE_MASTERRepository.findAll().size();

        // Update the rNS_ARTICLE_MASTER
        RNS_ARTICLE_MASTER updatedRNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERRepository.findOne(rNS_ARTICLE_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_ARTICLE_MASTER are not directly saved in db
        em.detach(updatedRNS_ARTICLE_MASTER);
        updatedRNS_ARTICLE_MASTER
            .aRTICLECODE(UPDATED_A_RTICLECODE)
            .aRTICLECODEDESC(UPDATED_A_RTICLECODEDESC);

        restRNS_ARTICLE_MASTERMockMvc.perform(put("/api/rns-article-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_ARTICLE_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_ARTICLE_MASTER in the database
        List<RNS_ARTICLE_MASTER> rNS_ARTICLE_MASTERList = rNS_ARTICLE_MASTERRepository.findAll();
        assertThat(rNS_ARTICLE_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_ARTICLE_MASTER testRNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERList.get(rNS_ARTICLE_MASTERList.size() - 1);
        assertThat(testRNS_ARTICLE_MASTER.getaRTICLECODE()).isEqualTo(UPDATED_A_RTICLECODE);
        assertThat(testRNS_ARTICLE_MASTER.getaRTICLECODEDESC()).isEqualTo(UPDATED_A_RTICLECODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_ARTICLE_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_ARTICLE_MASTERRepository.findAll().size();

        // Create the RNS_ARTICLE_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_ARTICLE_MASTERMockMvc.perform(put("/api/rns-article-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_ARTICLE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_ARTICLE_MASTER in the database
        List<RNS_ARTICLE_MASTER> rNS_ARTICLE_MASTERList = rNS_ARTICLE_MASTERRepository.findAll();
        assertThat(rNS_ARTICLE_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_ARTICLE_MASTER() throws Exception {
        // Initialize the database
        rNS_ARTICLE_MASTERRepository.saveAndFlush(rNS_ARTICLE_MASTER);
        int databaseSizeBeforeDelete = rNS_ARTICLE_MASTERRepository.findAll().size();

        // Get the rNS_ARTICLE_MASTER
        restRNS_ARTICLE_MASTERMockMvc.perform(delete("/api/rns-article-masters/{id}", rNS_ARTICLE_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_ARTICLE_MASTER> rNS_ARTICLE_MASTERList = rNS_ARTICLE_MASTERRepository.findAll();
        assertThat(rNS_ARTICLE_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_ARTICLE_MASTER.class);
        RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER1 = new RNS_ARTICLE_MASTER();
        rNS_ARTICLE_MASTER1.setId(1L);
        RNS_ARTICLE_MASTER rNS_ARTICLE_MASTER2 = new RNS_ARTICLE_MASTER();
        rNS_ARTICLE_MASTER2.setId(rNS_ARTICLE_MASTER1.getId());
        assertThat(rNS_ARTICLE_MASTER1).isEqualTo(rNS_ARTICLE_MASTER2);
        rNS_ARTICLE_MASTER2.setId(2L);
        assertThat(rNS_ARTICLE_MASTER1).isNotEqualTo(rNS_ARTICLE_MASTER2);
        rNS_ARTICLE_MASTER1.setId(null);
        assertThat(rNS_ARTICLE_MASTER1).isNotEqualTo(rNS_ARTICLE_MASTER2);
    }
}
