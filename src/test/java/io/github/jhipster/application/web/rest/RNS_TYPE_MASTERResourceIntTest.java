package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_TYPE_MASTER;
import io.github.jhipster.application.repository.RNS_TYPE_MASTERRepository;
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
 * Test class for the RNS_TYPE_MASTERResource REST controller.
 *
 * @see RNS_TYPE_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_TYPE_MASTERResourceIntTest {

    private static final String DEFAULT_R_NSCATGCODE = "AAAAAAAAAA";
    private static final String UPDATED_R_NSCATGCODE = "BBBBBBBBBB";

    private static final String DEFAULT_T_YPECODE = "AAAAAAAAAA";
    private static final String UPDATED_T_YPECODE = "BBBBBBBBBB";

    private static final String DEFAULT_T_YPECODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_T_YPECODEDESC = "BBBBBBBBBB";

    @Autowired
    private RNS_TYPE_MASTERRepository rNS_TYPE_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_TYPE_MASTERMockMvc;

    private RNS_TYPE_MASTER rNS_TYPE_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_TYPE_MASTERResource rNS_TYPE_MASTERResource = new RNS_TYPE_MASTERResource(rNS_TYPE_MASTERRepository);
        this.restRNS_TYPE_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_TYPE_MASTERResource)
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
    public static RNS_TYPE_MASTER createEntity(EntityManager em) {
        RNS_TYPE_MASTER rNS_TYPE_MASTER = new RNS_TYPE_MASTER()
            .rNSCATGCODE(DEFAULT_R_NSCATGCODE)
            .tYPECODE(DEFAULT_T_YPECODE)
            .tYPECODEDESC(DEFAULT_T_YPECODEDESC);
        return rNS_TYPE_MASTER;
    }

    @Before
    public void initTest() {
        rNS_TYPE_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_TYPE_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_TYPE_MASTERRepository.findAll().size();

        // Create the RNS_TYPE_MASTER
        restRNS_TYPE_MASTERMockMvc.perform(post("/api/rns-type-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_TYPE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_TYPE_MASTER in the database
        List<RNS_TYPE_MASTER> rNS_TYPE_MASTERList = rNS_TYPE_MASTERRepository.findAll();
        assertThat(rNS_TYPE_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_TYPE_MASTER testRNS_TYPE_MASTER = rNS_TYPE_MASTERList.get(rNS_TYPE_MASTERList.size() - 1);
        assertThat(testRNS_TYPE_MASTER.getrNSCATGCODE()).isEqualTo(DEFAULT_R_NSCATGCODE);
        assertThat(testRNS_TYPE_MASTER.gettYPECODE()).isEqualTo(DEFAULT_T_YPECODE);
        assertThat(testRNS_TYPE_MASTER.gettYPECODEDESC()).isEqualTo(DEFAULT_T_YPECODEDESC);
    }

    @Test
    @Transactional
    public void createRNS_TYPE_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_TYPE_MASTERRepository.findAll().size();

        // Create the RNS_TYPE_MASTER with an existing ID
        rNS_TYPE_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_TYPE_MASTERMockMvc.perform(post("/api/rns-type-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_TYPE_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_TYPE_MASTER in the database
        List<RNS_TYPE_MASTER> rNS_TYPE_MASTERList = rNS_TYPE_MASTERRepository.findAll();
        assertThat(rNS_TYPE_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_TYPE_MASTERS() throws Exception {
        // Initialize the database
        rNS_TYPE_MASTERRepository.saveAndFlush(rNS_TYPE_MASTER);

        // Get all the rNS_TYPE_MASTERList
        restRNS_TYPE_MASTERMockMvc.perform(get("/api/rns-type-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_TYPE_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].rNSCATGCODE").value(hasItem(DEFAULT_R_NSCATGCODE.toString())))
            .andExpect(jsonPath("$.[*].tYPECODE").value(hasItem(DEFAULT_T_YPECODE.toString())))
            .andExpect(jsonPath("$.[*].tYPECODEDESC").value(hasItem(DEFAULT_T_YPECODEDESC.toString())));
    }

    @Test
    @Transactional
    public void getRNS_TYPE_MASTER() throws Exception {
        // Initialize the database
        rNS_TYPE_MASTERRepository.saveAndFlush(rNS_TYPE_MASTER);

        // Get the rNS_TYPE_MASTER
        restRNS_TYPE_MASTERMockMvc.perform(get("/api/rns-type-masters/{id}", rNS_TYPE_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_TYPE_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.rNSCATGCODE").value(DEFAULT_R_NSCATGCODE.toString()))
            .andExpect(jsonPath("$.tYPECODE").value(DEFAULT_T_YPECODE.toString()))
            .andExpect(jsonPath("$.tYPECODEDESC").value(DEFAULT_T_YPECODEDESC.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_TYPE_MASTER() throws Exception {
        // Get the rNS_TYPE_MASTER
        restRNS_TYPE_MASTERMockMvc.perform(get("/api/rns-type-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_TYPE_MASTER() throws Exception {
        // Initialize the database
        rNS_TYPE_MASTERRepository.saveAndFlush(rNS_TYPE_MASTER);
        int databaseSizeBeforeUpdate = rNS_TYPE_MASTERRepository.findAll().size();

        // Update the rNS_TYPE_MASTER
        RNS_TYPE_MASTER updatedRNS_TYPE_MASTER = rNS_TYPE_MASTERRepository.findOne(rNS_TYPE_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_TYPE_MASTER are not directly saved in db
        em.detach(updatedRNS_TYPE_MASTER);
        updatedRNS_TYPE_MASTER
            .rNSCATGCODE(UPDATED_R_NSCATGCODE)
            .tYPECODE(UPDATED_T_YPECODE)
            .tYPECODEDESC(UPDATED_T_YPECODEDESC);

        restRNS_TYPE_MASTERMockMvc.perform(put("/api/rns-type-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_TYPE_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_TYPE_MASTER in the database
        List<RNS_TYPE_MASTER> rNS_TYPE_MASTERList = rNS_TYPE_MASTERRepository.findAll();
        assertThat(rNS_TYPE_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_TYPE_MASTER testRNS_TYPE_MASTER = rNS_TYPE_MASTERList.get(rNS_TYPE_MASTERList.size() - 1);
        assertThat(testRNS_TYPE_MASTER.getrNSCATGCODE()).isEqualTo(UPDATED_R_NSCATGCODE);
        assertThat(testRNS_TYPE_MASTER.gettYPECODE()).isEqualTo(UPDATED_T_YPECODE);
        assertThat(testRNS_TYPE_MASTER.gettYPECODEDESC()).isEqualTo(UPDATED_T_YPECODEDESC);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_TYPE_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_TYPE_MASTERRepository.findAll().size();

        // Create the RNS_TYPE_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_TYPE_MASTERMockMvc.perform(put("/api/rns-type-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_TYPE_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_TYPE_MASTER in the database
        List<RNS_TYPE_MASTER> rNS_TYPE_MASTERList = rNS_TYPE_MASTERRepository.findAll();
        assertThat(rNS_TYPE_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_TYPE_MASTER() throws Exception {
        // Initialize the database
        rNS_TYPE_MASTERRepository.saveAndFlush(rNS_TYPE_MASTER);
        int databaseSizeBeforeDelete = rNS_TYPE_MASTERRepository.findAll().size();

        // Get the rNS_TYPE_MASTER
        restRNS_TYPE_MASTERMockMvc.perform(delete("/api/rns-type-masters/{id}", rNS_TYPE_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_TYPE_MASTER> rNS_TYPE_MASTERList = rNS_TYPE_MASTERRepository.findAll();
        assertThat(rNS_TYPE_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_TYPE_MASTER.class);
        RNS_TYPE_MASTER rNS_TYPE_MASTER1 = new RNS_TYPE_MASTER();
        rNS_TYPE_MASTER1.setId(1L);
        RNS_TYPE_MASTER rNS_TYPE_MASTER2 = new RNS_TYPE_MASTER();
        rNS_TYPE_MASTER2.setId(rNS_TYPE_MASTER1.getId());
        assertThat(rNS_TYPE_MASTER1).isEqualTo(rNS_TYPE_MASTER2);
        rNS_TYPE_MASTER2.setId(2L);
        assertThat(rNS_TYPE_MASTER1).isNotEqualTo(rNS_TYPE_MASTER2);
        rNS_TYPE_MASTER1.setId(null);
        assertThat(rNS_TYPE_MASTER1).isNotEqualTo(rNS_TYPE_MASTER2);
    }
}
