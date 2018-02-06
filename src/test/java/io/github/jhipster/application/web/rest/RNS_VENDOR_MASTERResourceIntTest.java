package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_VENDOR_MASTER;
import io.github.jhipster.application.repository.RNS_VENDOR_MASTERRepository;
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
 * Test class for the RNS_VENDOR_MASTERResource REST controller.
 *
 * @see RNS_VENDOR_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_VENDOR_MASTERResourceIntTest {

    private static final String DEFAULT_V_ENDORCODE = "AAAAAAAAAA";
    private static final String UPDATED_V_ENDORCODE = "BBBBBBBBBB";

    private static final String DEFAULT_V_ENDORMASTERCODE = "AAAAAAAAAA";
    private static final String UPDATED_V_ENDORMASTERCODE = "BBBBBBBBBB";

    private static final String DEFAULT_V_ENDORNAME = "AAAAAAAAAA";
    private static final String UPDATED_V_ENDORNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_V_ENDORUSERID = 1;
    private static final Integer UPDATED_V_ENDORUSERID = 2;

    private static final String DEFAULT_U_SERNAME = "AAAAAAAAAA";
    private static final String UPDATED_U_SERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_E_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_E_MAIL = "BBBBBBBBBB";

    private static final String DEFAULT_M_OBILENUMBER = "AAAAAAAAAA";
    private static final String UPDATED_M_OBILENUMBER = "BBBBBBBBBB";

    @Autowired
    private RNS_VENDOR_MASTERRepository rNS_VENDOR_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_VENDOR_MASTERMockMvc;

    private RNS_VENDOR_MASTER rNS_VENDOR_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_VENDOR_MASTERResource rNS_VENDOR_MASTERResource = new RNS_VENDOR_MASTERResource(rNS_VENDOR_MASTERRepository);
        this.restRNS_VENDOR_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_VENDOR_MASTERResource)
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
    public static RNS_VENDOR_MASTER createEntity(EntityManager em) {
        RNS_VENDOR_MASTER rNS_VENDOR_MASTER = new RNS_VENDOR_MASTER()
            .vENDORCODE(DEFAULT_V_ENDORCODE)
            .vENDORMASTERCODE(DEFAULT_V_ENDORMASTERCODE)
            .vENDORNAME(DEFAULT_V_ENDORNAME)
            .vENDORUSERID(DEFAULT_V_ENDORUSERID)
            .uSERNAME(DEFAULT_U_SERNAME)
            .eMAIL(DEFAULT_E_MAIL)
            .mOBILENUMBER(DEFAULT_M_OBILENUMBER);
        return rNS_VENDOR_MASTER;
    }

    @Before
    public void initTest() {
        rNS_VENDOR_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_VENDOR_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_VENDOR_MASTERRepository.findAll().size();

        // Create the RNS_VENDOR_MASTER
        restRNS_VENDOR_MASTERMockMvc.perform(post("/api/rns-vendor-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_VENDOR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_VENDOR_MASTER in the database
        List<RNS_VENDOR_MASTER> rNS_VENDOR_MASTERList = rNS_VENDOR_MASTERRepository.findAll();
        assertThat(rNS_VENDOR_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_VENDOR_MASTER testRNS_VENDOR_MASTER = rNS_VENDOR_MASTERList.get(rNS_VENDOR_MASTERList.size() - 1);
        assertThat(testRNS_VENDOR_MASTER.getvENDORCODE()).isEqualTo(DEFAULT_V_ENDORCODE);
        assertThat(testRNS_VENDOR_MASTER.getvENDORMASTERCODE()).isEqualTo(DEFAULT_V_ENDORMASTERCODE);
        assertThat(testRNS_VENDOR_MASTER.getvENDORNAME()).isEqualTo(DEFAULT_V_ENDORNAME);
        assertThat(testRNS_VENDOR_MASTER.getvENDORUSERID()).isEqualTo(DEFAULT_V_ENDORUSERID);
        assertThat(testRNS_VENDOR_MASTER.getuSERNAME()).isEqualTo(DEFAULT_U_SERNAME);
        assertThat(testRNS_VENDOR_MASTER.geteMAIL()).isEqualTo(DEFAULT_E_MAIL);
        assertThat(testRNS_VENDOR_MASTER.getmOBILENUMBER()).isEqualTo(DEFAULT_M_OBILENUMBER);
    }

    @Test
    @Transactional
    public void createRNS_VENDOR_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_VENDOR_MASTERRepository.findAll().size();

        // Create the RNS_VENDOR_MASTER with an existing ID
        rNS_VENDOR_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_VENDOR_MASTERMockMvc.perform(post("/api/rns-vendor-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_VENDOR_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_VENDOR_MASTER in the database
        List<RNS_VENDOR_MASTER> rNS_VENDOR_MASTERList = rNS_VENDOR_MASTERRepository.findAll();
        assertThat(rNS_VENDOR_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_VENDOR_MASTERS() throws Exception {
        // Initialize the database
        rNS_VENDOR_MASTERRepository.saveAndFlush(rNS_VENDOR_MASTER);

        // Get all the rNS_VENDOR_MASTERList
        restRNS_VENDOR_MASTERMockMvc.perform(get("/api/rns-vendor-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_VENDOR_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].vENDORCODE").value(hasItem(DEFAULT_V_ENDORCODE.toString())))
            .andExpect(jsonPath("$.[*].vENDORMASTERCODE").value(hasItem(DEFAULT_V_ENDORMASTERCODE.toString())))
            .andExpect(jsonPath("$.[*].vENDORNAME").value(hasItem(DEFAULT_V_ENDORNAME.toString())))
            .andExpect(jsonPath("$.[*].vENDORUSERID").value(hasItem(DEFAULT_V_ENDORUSERID)))
            .andExpect(jsonPath("$.[*].uSERNAME").value(hasItem(DEFAULT_U_SERNAME.toString())))
            .andExpect(jsonPath("$.[*].eMAIL").value(hasItem(DEFAULT_E_MAIL.toString())))
            .andExpect(jsonPath("$.[*].mOBILENUMBER").value(hasItem(DEFAULT_M_OBILENUMBER.toString())));
    }

    @Test
    @Transactional
    public void getRNS_VENDOR_MASTER() throws Exception {
        // Initialize the database
        rNS_VENDOR_MASTERRepository.saveAndFlush(rNS_VENDOR_MASTER);

        // Get the rNS_VENDOR_MASTER
        restRNS_VENDOR_MASTERMockMvc.perform(get("/api/rns-vendor-masters/{id}", rNS_VENDOR_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_VENDOR_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.vENDORCODE").value(DEFAULT_V_ENDORCODE.toString()))
            .andExpect(jsonPath("$.vENDORMASTERCODE").value(DEFAULT_V_ENDORMASTERCODE.toString()))
            .andExpect(jsonPath("$.vENDORNAME").value(DEFAULT_V_ENDORNAME.toString()))
            .andExpect(jsonPath("$.vENDORUSERID").value(DEFAULT_V_ENDORUSERID))
            .andExpect(jsonPath("$.uSERNAME").value(DEFAULT_U_SERNAME.toString()))
            .andExpect(jsonPath("$.eMAIL").value(DEFAULT_E_MAIL.toString()))
            .andExpect(jsonPath("$.mOBILENUMBER").value(DEFAULT_M_OBILENUMBER.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_VENDOR_MASTER() throws Exception {
        // Get the rNS_VENDOR_MASTER
        restRNS_VENDOR_MASTERMockMvc.perform(get("/api/rns-vendor-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_VENDOR_MASTER() throws Exception {
        // Initialize the database
        rNS_VENDOR_MASTERRepository.saveAndFlush(rNS_VENDOR_MASTER);
        int databaseSizeBeforeUpdate = rNS_VENDOR_MASTERRepository.findAll().size();

        // Update the rNS_VENDOR_MASTER
        RNS_VENDOR_MASTER updatedRNS_VENDOR_MASTER = rNS_VENDOR_MASTERRepository.findOne(rNS_VENDOR_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_VENDOR_MASTER are not directly saved in db
        em.detach(updatedRNS_VENDOR_MASTER);
        updatedRNS_VENDOR_MASTER
            .vENDORCODE(UPDATED_V_ENDORCODE)
            .vENDORMASTERCODE(UPDATED_V_ENDORMASTERCODE)
            .vENDORNAME(UPDATED_V_ENDORNAME)
            .vENDORUSERID(UPDATED_V_ENDORUSERID)
            .uSERNAME(UPDATED_U_SERNAME)
            .eMAIL(UPDATED_E_MAIL)
            .mOBILENUMBER(UPDATED_M_OBILENUMBER);

        restRNS_VENDOR_MASTERMockMvc.perform(put("/api/rns-vendor-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_VENDOR_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_VENDOR_MASTER in the database
        List<RNS_VENDOR_MASTER> rNS_VENDOR_MASTERList = rNS_VENDOR_MASTERRepository.findAll();
        assertThat(rNS_VENDOR_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_VENDOR_MASTER testRNS_VENDOR_MASTER = rNS_VENDOR_MASTERList.get(rNS_VENDOR_MASTERList.size() - 1);
        assertThat(testRNS_VENDOR_MASTER.getvENDORCODE()).isEqualTo(UPDATED_V_ENDORCODE);
        assertThat(testRNS_VENDOR_MASTER.getvENDORMASTERCODE()).isEqualTo(UPDATED_V_ENDORMASTERCODE);
        assertThat(testRNS_VENDOR_MASTER.getvENDORNAME()).isEqualTo(UPDATED_V_ENDORNAME);
        assertThat(testRNS_VENDOR_MASTER.getvENDORUSERID()).isEqualTo(UPDATED_V_ENDORUSERID);
        assertThat(testRNS_VENDOR_MASTER.getuSERNAME()).isEqualTo(UPDATED_U_SERNAME);
        assertThat(testRNS_VENDOR_MASTER.geteMAIL()).isEqualTo(UPDATED_E_MAIL);
        assertThat(testRNS_VENDOR_MASTER.getmOBILENUMBER()).isEqualTo(UPDATED_M_OBILENUMBER);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_VENDOR_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_VENDOR_MASTERRepository.findAll().size();

        // Create the RNS_VENDOR_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_VENDOR_MASTERMockMvc.perform(put("/api/rns-vendor-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_VENDOR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_VENDOR_MASTER in the database
        List<RNS_VENDOR_MASTER> rNS_VENDOR_MASTERList = rNS_VENDOR_MASTERRepository.findAll();
        assertThat(rNS_VENDOR_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_VENDOR_MASTER() throws Exception {
        // Initialize the database
        rNS_VENDOR_MASTERRepository.saveAndFlush(rNS_VENDOR_MASTER);
        int databaseSizeBeforeDelete = rNS_VENDOR_MASTERRepository.findAll().size();

        // Get the rNS_VENDOR_MASTER
        restRNS_VENDOR_MASTERMockMvc.perform(delete("/api/rns-vendor-masters/{id}", rNS_VENDOR_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_VENDOR_MASTER> rNS_VENDOR_MASTERList = rNS_VENDOR_MASTERRepository.findAll();
        assertThat(rNS_VENDOR_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_VENDOR_MASTER.class);
        RNS_VENDOR_MASTER rNS_VENDOR_MASTER1 = new RNS_VENDOR_MASTER();
        rNS_VENDOR_MASTER1.setId(1L);
        RNS_VENDOR_MASTER rNS_VENDOR_MASTER2 = new RNS_VENDOR_MASTER();
        rNS_VENDOR_MASTER2.setId(rNS_VENDOR_MASTER1.getId());
        assertThat(rNS_VENDOR_MASTER1).isEqualTo(rNS_VENDOR_MASTER2);
        rNS_VENDOR_MASTER2.setId(2L);
        assertThat(rNS_VENDOR_MASTER1).isNotEqualTo(rNS_VENDOR_MASTER2);
        rNS_VENDOR_MASTER1.setId(null);
        assertThat(rNS_VENDOR_MASTER1).isNotEqualTo(rNS_VENDOR_MASTER2);
    }
}
