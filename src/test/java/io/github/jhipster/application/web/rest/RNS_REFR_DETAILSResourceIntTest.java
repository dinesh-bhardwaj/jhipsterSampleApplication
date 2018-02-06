package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_REFR_DETAILS;
import io.github.jhipster.application.repository.RNS_REFR_DETAILSRepository;
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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the RNS_REFR_DETAILSResource REST controller.
 *
 * @see RNS_REFR_DETAILSResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_REFR_DETAILSResourceIntTest {

    private static final String DEFAULT_R_EFRID = "AAAAAAAAAA";
    private static final String UPDATED_R_EFRID = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC = "BBBBBBBBBB";

    private static final String DEFAULT_S_TATUS = "AAAAAAAAAA";
    private static final String UPDATED_S_TATUS = "BBBBBBBBBB";

    private static final String DEFAULT_C_REATEDBY = "AAAAAAAAAA";
    private static final String UPDATED_C_REATEDBY = "BBBBBBBBBB";

    private static final Instant DEFAULT_C_REATEDDATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_C_REATEDDATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_L_ASTMODIFIEDBY = "AAAAAAAAAA";
    private static final String UPDATED_L_ASTMODIFIEDBY = "BBBBBBBBBB";

    private static final Instant DEFAULT_L_ASTMODIFIEDDATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_L_ASTMODIFIEDDATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private RNS_REFR_DETAILSRepository rNS_REFR_DETAILSRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_REFR_DETAILSMockMvc;

    private RNS_REFR_DETAILS rNS_REFR_DETAILS;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_REFR_DETAILSResource rNS_REFR_DETAILSResource = new RNS_REFR_DETAILSResource(rNS_REFR_DETAILSRepository);
        this.restRNS_REFR_DETAILSMockMvc = MockMvcBuilders.standaloneSetup(rNS_REFR_DETAILSResource)
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
    public static RNS_REFR_DETAILS createEntity(EntityManager em) {
        RNS_REFR_DETAILS rNS_REFR_DETAILS = new RNS_REFR_DETAILS()
            .rEFRID(DEFAULT_R_EFRID)
            .sUBCODE(DEFAULT_S_UBCODE)
            .sUBCODEDESC(DEFAULT_S_UBCODEDESC)
            .sTATUS(DEFAULT_S_TATUS)
            .cREATEDBY(DEFAULT_C_REATEDBY)
            .cREATEDDATE(DEFAULT_C_REATEDDATE)
            .lASTMODIFIEDBY(DEFAULT_L_ASTMODIFIEDBY)
            .lASTMODIFIEDDATE(DEFAULT_L_ASTMODIFIEDDATE);
        return rNS_REFR_DETAILS;
    }

    @Before
    public void initTest() {
        rNS_REFR_DETAILS = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_REFR_DETAILS() throws Exception {
        int databaseSizeBeforeCreate = rNS_REFR_DETAILSRepository.findAll().size();

        // Create the RNS_REFR_DETAILS
        restRNS_REFR_DETAILSMockMvc.perform(post("/api/rns-refr-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_DETAILS)))
            .andExpect(status().isCreated());

        // Validate the RNS_REFR_DETAILS in the database
        List<RNS_REFR_DETAILS> rNS_REFR_DETAILSList = rNS_REFR_DETAILSRepository.findAll();
        assertThat(rNS_REFR_DETAILSList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_REFR_DETAILS testRNS_REFR_DETAILS = rNS_REFR_DETAILSList.get(rNS_REFR_DETAILSList.size() - 1);
        assertThat(testRNS_REFR_DETAILS.getrEFRID()).isEqualTo(DEFAULT_R_EFRID);
        assertThat(testRNS_REFR_DETAILS.getsUBCODE()).isEqualTo(DEFAULT_S_UBCODE);
        assertThat(testRNS_REFR_DETAILS.getsUBCODEDESC()).isEqualTo(DEFAULT_S_UBCODEDESC);
        assertThat(testRNS_REFR_DETAILS.getsTATUS()).isEqualTo(DEFAULT_S_TATUS);
        assertThat(testRNS_REFR_DETAILS.getcREATEDBY()).isEqualTo(DEFAULT_C_REATEDBY);
        assertThat(testRNS_REFR_DETAILS.getcREATEDDATE()).isEqualTo(DEFAULT_C_REATEDDATE);
        assertThat(testRNS_REFR_DETAILS.getlASTMODIFIEDBY()).isEqualTo(DEFAULT_L_ASTMODIFIEDBY);
        assertThat(testRNS_REFR_DETAILS.getlASTMODIFIEDDATE()).isEqualTo(DEFAULT_L_ASTMODIFIEDDATE);
    }

    @Test
    @Transactional
    public void createRNS_REFR_DETAILSWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_REFR_DETAILSRepository.findAll().size();

        // Create the RNS_REFR_DETAILS with an existing ID
        rNS_REFR_DETAILS.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_REFR_DETAILSMockMvc.perform(post("/api/rns-refr-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_DETAILS)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_REFR_DETAILS in the database
        List<RNS_REFR_DETAILS> rNS_REFR_DETAILSList = rNS_REFR_DETAILSRepository.findAll();
        assertThat(rNS_REFR_DETAILSList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_REFR_DETAILS() throws Exception {
        // Initialize the database
        rNS_REFR_DETAILSRepository.saveAndFlush(rNS_REFR_DETAILS);

        // Get all the rNS_REFR_DETAILSList
        restRNS_REFR_DETAILSMockMvc.perform(get("/api/rns-refr-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_REFR_DETAILS.getId().intValue())))
            .andExpect(jsonPath("$.[*].rEFRID").value(hasItem(DEFAULT_R_EFRID.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE").value(hasItem(DEFAULT_S_UBCODE.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC").value(hasItem(DEFAULT_S_UBCODEDESC.toString())))
            .andExpect(jsonPath("$.[*].sTATUS").value(hasItem(DEFAULT_S_TATUS.toString())))
            .andExpect(jsonPath("$.[*].cREATEDBY").value(hasItem(DEFAULT_C_REATEDBY.toString())))
            .andExpect(jsonPath("$.[*].cREATEDDATE").value(hasItem(DEFAULT_C_REATEDDATE.toString())))
            .andExpect(jsonPath("$.[*].lASTMODIFIEDBY").value(hasItem(DEFAULT_L_ASTMODIFIEDBY.toString())))
            .andExpect(jsonPath("$.[*].lASTMODIFIEDDATE").value(hasItem(DEFAULT_L_ASTMODIFIEDDATE.toString())));
    }

    @Test
    @Transactional
    public void getRNS_REFR_DETAILS() throws Exception {
        // Initialize the database
        rNS_REFR_DETAILSRepository.saveAndFlush(rNS_REFR_DETAILS);

        // Get the rNS_REFR_DETAILS
        restRNS_REFR_DETAILSMockMvc.perform(get("/api/rns-refr-details/{id}", rNS_REFR_DETAILS.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_REFR_DETAILS.getId().intValue()))
            .andExpect(jsonPath("$.rEFRID").value(DEFAULT_R_EFRID.toString()))
            .andExpect(jsonPath("$.sUBCODE").value(DEFAULT_S_UBCODE.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC").value(DEFAULT_S_UBCODEDESC.toString()))
            .andExpect(jsonPath("$.sTATUS").value(DEFAULT_S_TATUS.toString()))
            .andExpect(jsonPath("$.cREATEDBY").value(DEFAULT_C_REATEDBY.toString()))
            .andExpect(jsonPath("$.cREATEDDATE").value(DEFAULT_C_REATEDDATE.toString()))
            .andExpect(jsonPath("$.lASTMODIFIEDBY").value(DEFAULT_L_ASTMODIFIEDBY.toString()))
            .andExpect(jsonPath("$.lASTMODIFIEDDATE").value(DEFAULT_L_ASTMODIFIEDDATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_REFR_DETAILS() throws Exception {
        // Get the rNS_REFR_DETAILS
        restRNS_REFR_DETAILSMockMvc.perform(get("/api/rns-refr-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_REFR_DETAILS() throws Exception {
        // Initialize the database
        rNS_REFR_DETAILSRepository.saveAndFlush(rNS_REFR_DETAILS);
        int databaseSizeBeforeUpdate = rNS_REFR_DETAILSRepository.findAll().size();

        // Update the rNS_REFR_DETAILS
        RNS_REFR_DETAILS updatedRNS_REFR_DETAILS = rNS_REFR_DETAILSRepository.findOne(rNS_REFR_DETAILS.getId());
        // Disconnect from session so that the updates on updatedRNS_REFR_DETAILS are not directly saved in db
        em.detach(updatedRNS_REFR_DETAILS);
        updatedRNS_REFR_DETAILS
            .rEFRID(UPDATED_R_EFRID)
            .sUBCODE(UPDATED_S_UBCODE)
            .sUBCODEDESC(UPDATED_S_UBCODEDESC)
            .sTATUS(UPDATED_S_TATUS)
            .cREATEDBY(UPDATED_C_REATEDBY)
            .cREATEDDATE(UPDATED_C_REATEDDATE)
            .lASTMODIFIEDBY(UPDATED_L_ASTMODIFIEDBY)
            .lASTMODIFIEDDATE(UPDATED_L_ASTMODIFIEDDATE);

        restRNS_REFR_DETAILSMockMvc.perform(put("/api/rns-refr-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_REFR_DETAILS)))
            .andExpect(status().isOk());

        // Validate the RNS_REFR_DETAILS in the database
        List<RNS_REFR_DETAILS> rNS_REFR_DETAILSList = rNS_REFR_DETAILSRepository.findAll();
        assertThat(rNS_REFR_DETAILSList).hasSize(databaseSizeBeforeUpdate);
        RNS_REFR_DETAILS testRNS_REFR_DETAILS = rNS_REFR_DETAILSList.get(rNS_REFR_DETAILSList.size() - 1);
        assertThat(testRNS_REFR_DETAILS.getrEFRID()).isEqualTo(UPDATED_R_EFRID);
        assertThat(testRNS_REFR_DETAILS.getsUBCODE()).isEqualTo(UPDATED_S_UBCODE);
        assertThat(testRNS_REFR_DETAILS.getsUBCODEDESC()).isEqualTo(UPDATED_S_UBCODEDESC);
        assertThat(testRNS_REFR_DETAILS.getsTATUS()).isEqualTo(UPDATED_S_TATUS);
        assertThat(testRNS_REFR_DETAILS.getcREATEDBY()).isEqualTo(UPDATED_C_REATEDBY);
        assertThat(testRNS_REFR_DETAILS.getcREATEDDATE()).isEqualTo(UPDATED_C_REATEDDATE);
        assertThat(testRNS_REFR_DETAILS.getlASTMODIFIEDBY()).isEqualTo(UPDATED_L_ASTMODIFIEDBY);
        assertThat(testRNS_REFR_DETAILS.getlASTMODIFIEDDATE()).isEqualTo(UPDATED_L_ASTMODIFIEDDATE);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_REFR_DETAILS() throws Exception {
        int databaseSizeBeforeUpdate = rNS_REFR_DETAILSRepository.findAll().size();

        // Create the RNS_REFR_DETAILS

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_REFR_DETAILSMockMvc.perform(put("/api/rns-refr-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_DETAILS)))
            .andExpect(status().isCreated());

        // Validate the RNS_REFR_DETAILS in the database
        List<RNS_REFR_DETAILS> rNS_REFR_DETAILSList = rNS_REFR_DETAILSRepository.findAll();
        assertThat(rNS_REFR_DETAILSList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_REFR_DETAILS() throws Exception {
        // Initialize the database
        rNS_REFR_DETAILSRepository.saveAndFlush(rNS_REFR_DETAILS);
        int databaseSizeBeforeDelete = rNS_REFR_DETAILSRepository.findAll().size();

        // Get the rNS_REFR_DETAILS
        restRNS_REFR_DETAILSMockMvc.perform(delete("/api/rns-refr-details/{id}", rNS_REFR_DETAILS.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_REFR_DETAILS> rNS_REFR_DETAILSList = rNS_REFR_DETAILSRepository.findAll();
        assertThat(rNS_REFR_DETAILSList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_REFR_DETAILS.class);
        RNS_REFR_DETAILS rNS_REFR_DETAILS1 = new RNS_REFR_DETAILS();
        rNS_REFR_DETAILS1.setId(1L);
        RNS_REFR_DETAILS rNS_REFR_DETAILS2 = new RNS_REFR_DETAILS();
        rNS_REFR_DETAILS2.setId(rNS_REFR_DETAILS1.getId());
        assertThat(rNS_REFR_DETAILS1).isEqualTo(rNS_REFR_DETAILS2);
        rNS_REFR_DETAILS2.setId(2L);
        assertThat(rNS_REFR_DETAILS1).isNotEqualTo(rNS_REFR_DETAILS2);
        rNS_REFR_DETAILS1.setId(null);
        assertThat(rNS_REFR_DETAILS1).isNotEqualTo(rNS_REFR_DETAILS2);
    }
}
