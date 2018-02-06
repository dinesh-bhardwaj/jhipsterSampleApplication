package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.RNS_REFR_MASTER;
import io.github.jhipster.application.repository.RNS_REFR_MASTERRepository;
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
 * Test class for the RNS_REFR_MASTERResource REST controller.
 *
 * @see RNS_REFR_MASTERResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class RNS_REFR_MASTERResourceIntTest {

    private static final String DEFAULT_R_NSCATGCODE = "AAAAAAAAAA";
    private static final String UPDATED_R_NSCATGCODE = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_1 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_1 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_1 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_2 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_2 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_2 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_3 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_3 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_3 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_4 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_4 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_4 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_5 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_5 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_5 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_6 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_6 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_6 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_6 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_7 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_7 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_7 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_7 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_8 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_8 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_8 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_8 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_9 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_9 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_9 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_9 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODE_10 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODE_10 = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBCODEDESC_10 = "AAAAAAAAAA";
    private static final String UPDATED_S_UBCODEDESC_10 = "BBBBBBBBBB";

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
    private RNS_REFR_MASTERRepository rNS_REFR_MASTERRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRNS_REFR_MASTERMockMvc;

    private RNS_REFR_MASTER rNS_REFR_MASTER;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RNS_REFR_MASTERResource rNS_REFR_MASTERResource = new RNS_REFR_MASTERResource(rNS_REFR_MASTERRepository);
        this.restRNS_REFR_MASTERMockMvc = MockMvcBuilders.standaloneSetup(rNS_REFR_MASTERResource)
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
    public static RNS_REFR_MASTER createEntity(EntityManager em) {
        RNS_REFR_MASTER rNS_REFR_MASTER = new RNS_REFR_MASTER()
            .rNSCATGCODE(DEFAULT_R_NSCATGCODE)
            .sUBCODE1(DEFAULT_S_UBCODE_1)
            .sUBCODEDESC1(DEFAULT_S_UBCODEDESC_1)
            .sUBCODE2(DEFAULT_S_UBCODE_2)
            .sUBCODEDESC2(DEFAULT_S_UBCODEDESC_2)
            .sUBCODE3(DEFAULT_S_UBCODE_3)
            .sUBCODEDESC3(DEFAULT_S_UBCODEDESC_3)
            .sUBCODE4(DEFAULT_S_UBCODE_4)
            .sUBCODEDESC4(DEFAULT_S_UBCODEDESC_4)
            .sUBCODE5(DEFAULT_S_UBCODE_5)
            .sUBCODEDESC5(DEFAULT_S_UBCODEDESC_5)
            .sUBCODE6(DEFAULT_S_UBCODE_6)
            .sUBCODEDESC6(DEFAULT_S_UBCODEDESC_6)
            .sUBCODE7(DEFAULT_S_UBCODE_7)
            .sUBCODEDESC7(DEFAULT_S_UBCODEDESC_7)
            .sUBCODE8(DEFAULT_S_UBCODE_8)
            .sUBCODEDESC8(DEFAULT_S_UBCODEDESC_8)
            .sUBCODE9(DEFAULT_S_UBCODE_9)
            .sUBCODEDESC9(DEFAULT_S_UBCODEDESC_9)
            .sUBCODE10(DEFAULT_S_UBCODE_10)
            .sUBCODEDESC10(DEFAULT_S_UBCODEDESC_10)
            .sTATUS(DEFAULT_S_TATUS)
            .cREATEDBY(DEFAULT_C_REATEDBY)
            .cREATEDDATE(DEFAULT_C_REATEDDATE)
            .lASTMODIFIEDBY(DEFAULT_L_ASTMODIFIEDBY)
            .lASTMODIFIEDDATE(DEFAULT_L_ASTMODIFIEDDATE);
        return rNS_REFR_MASTER;
    }

    @Before
    public void initTest() {
        rNS_REFR_MASTER = createEntity(em);
    }

    @Test
    @Transactional
    public void createRNS_REFR_MASTER() throws Exception {
        int databaseSizeBeforeCreate = rNS_REFR_MASTERRepository.findAll().size();

        // Create the RNS_REFR_MASTER
        restRNS_REFR_MASTERMockMvc.perform(post("/api/rns-refr-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_REFR_MASTER in the database
        List<RNS_REFR_MASTER> rNS_REFR_MASTERList = rNS_REFR_MASTERRepository.findAll();
        assertThat(rNS_REFR_MASTERList).hasSize(databaseSizeBeforeCreate + 1);
        RNS_REFR_MASTER testRNS_REFR_MASTER = rNS_REFR_MASTERList.get(rNS_REFR_MASTERList.size() - 1);
        assertThat(testRNS_REFR_MASTER.getrNSCATGCODE()).isEqualTo(DEFAULT_R_NSCATGCODE);
        assertThat(testRNS_REFR_MASTER.getsUBCODE1()).isEqualTo(DEFAULT_S_UBCODE_1);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC1()).isEqualTo(DEFAULT_S_UBCODEDESC_1);
        assertThat(testRNS_REFR_MASTER.getsUBCODE2()).isEqualTo(DEFAULT_S_UBCODE_2);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC2()).isEqualTo(DEFAULT_S_UBCODEDESC_2);
        assertThat(testRNS_REFR_MASTER.getsUBCODE3()).isEqualTo(DEFAULT_S_UBCODE_3);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC3()).isEqualTo(DEFAULT_S_UBCODEDESC_3);
        assertThat(testRNS_REFR_MASTER.getsUBCODE4()).isEqualTo(DEFAULT_S_UBCODE_4);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC4()).isEqualTo(DEFAULT_S_UBCODEDESC_4);
        assertThat(testRNS_REFR_MASTER.getsUBCODE5()).isEqualTo(DEFAULT_S_UBCODE_5);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC5()).isEqualTo(DEFAULT_S_UBCODEDESC_5);
        assertThat(testRNS_REFR_MASTER.getsUBCODE6()).isEqualTo(DEFAULT_S_UBCODE_6);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC6()).isEqualTo(DEFAULT_S_UBCODEDESC_6);
        assertThat(testRNS_REFR_MASTER.getsUBCODE7()).isEqualTo(DEFAULT_S_UBCODE_7);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC7()).isEqualTo(DEFAULT_S_UBCODEDESC_7);
        assertThat(testRNS_REFR_MASTER.getsUBCODE8()).isEqualTo(DEFAULT_S_UBCODE_8);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC8()).isEqualTo(DEFAULT_S_UBCODEDESC_8);
        assertThat(testRNS_REFR_MASTER.getsUBCODE9()).isEqualTo(DEFAULT_S_UBCODE_9);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC9()).isEqualTo(DEFAULT_S_UBCODEDESC_9);
        assertThat(testRNS_REFR_MASTER.getsUBCODE10()).isEqualTo(DEFAULT_S_UBCODE_10);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC10()).isEqualTo(DEFAULT_S_UBCODEDESC_10);
        assertThat(testRNS_REFR_MASTER.getsTATUS()).isEqualTo(DEFAULT_S_TATUS);
        assertThat(testRNS_REFR_MASTER.getcREATEDBY()).isEqualTo(DEFAULT_C_REATEDBY);
        assertThat(testRNS_REFR_MASTER.getcREATEDDATE()).isEqualTo(DEFAULT_C_REATEDDATE);
        assertThat(testRNS_REFR_MASTER.getlASTMODIFIEDBY()).isEqualTo(DEFAULT_L_ASTMODIFIEDBY);
        assertThat(testRNS_REFR_MASTER.getlASTMODIFIEDDATE()).isEqualTo(DEFAULT_L_ASTMODIFIEDDATE);
    }

    @Test
    @Transactional
    public void createRNS_REFR_MASTERWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rNS_REFR_MASTERRepository.findAll().size();

        // Create the RNS_REFR_MASTER with an existing ID
        rNS_REFR_MASTER.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRNS_REFR_MASTERMockMvc.perform(post("/api/rns-refr-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_MASTER)))
            .andExpect(status().isBadRequest());

        // Validate the RNS_REFR_MASTER in the database
        List<RNS_REFR_MASTER> rNS_REFR_MASTERList = rNS_REFR_MASTERRepository.findAll();
        assertThat(rNS_REFR_MASTERList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRNS_REFR_MASTERS() throws Exception {
        // Initialize the database
        rNS_REFR_MASTERRepository.saveAndFlush(rNS_REFR_MASTER);

        // Get all the rNS_REFR_MASTERList
        restRNS_REFR_MASTERMockMvc.perform(get("/api/rns-refr-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rNS_REFR_MASTER.getId().intValue())))
            .andExpect(jsonPath("$.[*].rNSCATGCODE").value(hasItem(DEFAULT_R_NSCATGCODE.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE1").value(hasItem(DEFAULT_S_UBCODE_1.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC1").value(hasItem(DEFAULT_S_UBCODEDESC_1.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE2").value(hasItem(DEFAULT_S_UBCODE_2.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC2").value(hasItem(DEFAULT_S_UBCODEDESC_2.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE3").value(hasItem(DEFAULT_S_UBCODE_3.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC3").value(hasItem(DEFAULT_S_UBCODEDESC_3.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE4").value(hasItem(DEFAULT_S_UBCODE_4.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC4").value(hasItem(DEFAULT_S_UBCODEDESC_4.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE5").value(hasItem(DEFAULT_S_UBCODE_5.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC5").value(hasItem(DEFAULT_S_UBCODEDESC_5.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE6").value(hasItem(DEFAULT_S_UBCODE_6.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC6").value(hasItem(DEFAULT_S_UBCODEDESC_6.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE7").value(hasItem(DEFAULT_S_UBCODE_7.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC7").value(hasItem(DEFAULT_S_UBCODEDESC_7.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE8").value(hasItem(DEFAULT_S_UBCODE_8.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC8").value(hasItem(DEFAULT_S_UBCODEDESC_8.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE9").value(hasItem(DEFAULT_S_UBCODE_9.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC9").value(hasItem(DEFAULT_S_UBCODEDESC_9.toString())))
            .andExpect(jsonPath("$.[*].sUBCODE10").value(hasItem(DEFAULT_S_UBCODE_10.toString())))
            .andExpect(jsonPath("$.[*].sUBCODEDESC10").value(hasItem(DEFAULT_S_UBCODEDESC_10.toString())))
            .andExpect(jsonPath("$.[*].sTATUS").value(hasItem(DEFAULT_S_TATUS.toString())))
            .andExpect(jsonPath("$.[*].cREATEDBY").value(hasItem(DEFAULT_C_REATEDBY.toString())))
            .andExpect(jsonPath("$.[*].cREATEDDATE").value(hasItem(DEFAULT_C_REATEDDATE.toString())))
            .andExpect(jsonPath("$.[*].lASTMODIFIEDBY").value(hasItem(DEFAULT_L_ASTMODIFIEDBY.toString())))
            .andExpect(jsonPath("$.[*].lASTMODIFIEDDATE").value(hasItem(DEFAULT_L_ASTMODIFIEDDATE.toString())));
    }

    @Test
    @Transactional
    public void getRNS_REFR_MASTER() throws Exception {
        // Initialize the database
        rNS_REFR_MASTERRepository.saveAndFlush(rNS_REFR_MASTER);

        // Get the rNS_REFR_MASTER
        restRNS_REFR_MASTERMockMvc.perform(get("/api/rns-refr-masters/{id}", rNS_REFR_MASTER.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rNS_REFR_MASTER.getId().intValue()))
            .andExpect(jsonPath("$.rNSCATGCODE").value(DEFAULT_R_NSCATGCODE.toString()))
            .andExpect(jsonPath("$.sUBCODE1").value(DEFAULT_S_UBCODE_1.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC1").value(DEFAULT_S_UBCODEDESC_1.toString()))
            .andExpect(jsonPath("$.sUBCODE2").value(DEFAULT_S_UBCODE_2.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC2").value(DEFAULT_S_UBCODEDESC_2.toString()))
            .andExpect(jsonPath("$.sUBCODE3").value(DEFAULT_S_UBCODE_3.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC3").value(DEFAULT_S_UBCODEDESC_3.toString()))
            .andExpect(jsonPath("$.sUBCODE4").value(DEFAULT_S_UBCODE_4.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC4").value(DEFAULT_S_UBCODEDESC_4.toString()))
            .andExpect(jsonPath("$.sUBCODE5").value(DEFAULT_S_UBCODE_5.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC5").value(DEFAULT_S_UBCODEDESC_5.toString()))
            .andExpect(jsonPath("$.sUBCODE6").value(DEFAULT_S_UBCODE_6.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC6").value(DEFAULT_S_UBCODEDESC_6.toString()))
            .andExpect(jsonPath("$.sUBCODE7").value(DEFAULT_S_UBCODE_7.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC7").value(DEFAULT_S_UBCODEDESC_7.toString()))
            .andExpect(jsonPath("$.sUBCODE8").value(DEFAULT_S_UBCODE_8.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC8").value(DEFAULT_S_UBCODEDESC_8.toString()))
            .andExpect(jsonPath("$.sUBCODE9").value(DEFAULT_S_UBCODE_9.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC9").value(DEFAULT_S_UBCODEDESC_9.toString()))
            .andExpect(jsonPath("$.sUBCODE10").value(DEFAULT_S_UBCODE_10.toString()))
            .andExpect(jsonPath("$.sUBCODEDESC10").value(DEFAULT_S_UBCODEDESC_10.toString()))
            .andExpect(jsonPath("$.sTATUS").value(DEFAULT_S_TATUS.toString()))
            .andExpect(jsonPath("$.cREATEDBY").value(DEFAULT_C_REATEDBY.toString()))
            .andExpect(jsonPath("$.cREATEDDATE").value(DEFAULT_C_REATEDDATE.toString()))
            .andExpect(jsonPath("$.lASTMODIFIEDBY").value(DEFAULT_L_ASTMODIFIEDBY.toString()))
            .andExpect(jsonPath("$.lASTMODIFIEDDATE").value(DEFAULT_L_ASTMODIFIEDDATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRNS_REFR_MASTER() throws Exception {
        // Get the rNS_REFR_MASTER
        restRNS_REFR_MASTERMockMvc.perform(get("/api/rns-refr-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRNS_REFR_MASTER() throws Exception {
        // Initialize the database
        rNS_REFR_MASTERRepository.saveAndFlush(rNS_REFR_MASTER);
        int databaseSizeBeforeUpdate = rNS_REFR_MASTERRepository.findAll().size();

        // Update the rNS_REFR_MASTER
        RNS_REFR_MASTER updatedRNS_REFR_MASTER = rNS_REFR_MASTERRepository.findOne(rNS_REFR_MASTER.getId());
        // Disconnect from session so that the updates on updatedRNS_REFR_MASTER are not directly saved in db
        em.detach(updatedRNS_REFR_MASTER);
        updatedRNS_REFR_MASTER
            .rNSCATGCODE(UPDATED_R_NSCATGCODE)
            .sUBCODE1(UPDATED_S_UBCODE_1)
            .sUBCODEDESC1(UPDATED_S_UBCODEDESC_1)
            .sUBCODE2(UPDATED_S_UBCODE_2)
            .sUBCODEDESC2(UPDATED_S_UBCODEDESC_2)
            .sUBCODE3(UPDATED_S_UBCODE_3)
            .sUBCODEDESC3(UPDATED_S_UBCODEDESC_3)
            .sUBCODE4(UPDATED_S_UBCODE_4)
            .sUBCODEDESC4(UPDATED_S_UBCODEDESC_4)
            .sUBCODE5(UPDATED_S_UBCODE_5)
            .sUBCODEDESC5(UPDATED_S_UBCODEDESC_5)
            .sUBCODE6(UPDATED_S_UBCODE_6)
            .sUBCODEDESC6(UPDATED_S_UBCODEDESC_6)
            .sUBCODE7(UPDATED_S_UBCODE_7)
            .sUBCODEDESC7(UPDATED_S_UBCODEDESC_7)
            .sUBCODE8(UPDATED_S_UBCODE_8)
            .sUBCODEDESC8(UPDATED_S_UBCODEDESC_8)
            .sUBCODE9(UPDATED_S_UBCODE_9)
            .sUBCODEDESC9(UPDATED_S_UBCODEDESC_9)
            .sUBCODE10(UPDATED_S_UBCODE_10)
            .sUBCODEDESC10(UPDATED_S_UBCODEDESC_10)
            .sTATUS(UPDATED_S_TATUS)
            .cREATEDBY(UPDATED_C_REATEDBY)
            .cREATEDDATE(UPDATED_C_REATEDDATE)
            .lASTMODIFIEDBY(UPDATED_L_ASTMODIFIEDBY)
            .lASTMODIFIEDDATE(UPDATED_L_ASTMODIFIEDDATE);

        restRNS_REFR_MASTERMockMvc.perform(put("/api/rns-refr-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRNS_REFR_MASTER)))
            .andExpect(status().isOk());

        // Validate the RNS_REFR_MASTER in the database
        List<RNS_REFR_MASTER> rNS_REFR_MASTERList = rNS_REFR_MASTERRepository.findAll();
        assertThat(rNS_REFR_MASTERList).hasSize(databaseSizeBeforeUpdate);
        RNS_REFR_MASTER testRNS_REFR_MASTER = rNS_REFR_MASTERList.get(rNS_REFR_MASTERList.size() - 1);
        assertThat(testRNS_REFR_MASTER.getrNSCATGCODE()).isEqualTo(UPDATED_R_NSCATGCODE);
        assertThat(testRNS_REFR_MASTER.getsUBCODE1()).isEqualTo(UPDATED_S_UBCODE_1);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC1()).isEqualTo(UPDATED_S_UBCODEDESC_1);
        assertThat(testRNS_REFR_MASTER.getsUBCODE2()).isEqualTo(UPDATED_S_UBCODE_2);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC2()).isEqualTo(UPDATED_S_UBCODEDESC_2);
        assertThat(testRNS_REFR_MASTER.getsUBCODE3()).isEqualTo(UPDATED_S_UBCODE_3);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC3()).isEqualTo(UPDATED_S_UBCODEDESC_3);
        assertThat(testRNS_REFR_MASTER.getsUBCODE4()).isEqualTo(UPDATED_S_UBCODE_4);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC4()).isEqualTo(UPDATED_S_UBCODEDESC_4);
        assertThat(testRNS_REFR_MASTER.getsUBCODE5()).isEqualTo(UPDATED_S_UBCODE_5);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC5()).isEqualTo(UPDATED_S_UBCODEDESC_5);
        assertThat(testRNS_REFR_MASTER.getsUBCODE6()).isEqualTo(UPDATED_S_UBCODE_6);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC6()).isEqualTo(UPDATED_S_UBCODEDESC_6);
        assertThat(testRNS_REFR_MASTER.getsUBCODE7()).isEqualTo(UPDATED_S_UBCODE_7);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC7()).isEqualTo(UPDATED_S_UBCODEDESC_7);
        assertThat(testRNS_REFR_MASTER.getsUBCODE8()).isEqualTo(UPDATED_S_UBCODE_8);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC8()).isEqualTo(UPDATED_S_UBCODEDESC_8);
        assertThat(testRNS_REFR_MASTER.getsUBCODE9()).isEqualTo(UPDATED_S_UBCODE_9);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC9()).isEqualTo(UPDATED_S_UBCODEDESC_9);
        assertThat(testRNS_REFR_MASTER.getsUBCODE10()).isEqualTo(UPDATED_S_UBCODE_10);
        assertThat(testRNS_REFR_MASTER.getsUBCODEDESC10()).isEqualTo(UPDATED_S_UBCODEDESC_10);
        assertThat(testRNS_REFR_MASTER.getsTATUS()).isEqualTo(UPDATED_S_TATUS);
        assertThat(testRNS_REFR_MASTER.getcREATEDBY()).isEqualTo(UPDATED_C_REATEDBY);
        assertThat(testRNS_REFR_MASTER.getcREATEDDATE()).isEqualTo(UPDATED_C_REATEDDATE);
        assertThat(testRNS_REFR_MASTER.getlASTMODIFIEDBY()).isEqualTo(UPDATED_L_ASTMODIFIEDBY);
        assertThat(testRNS_REFR_MASTER.getlASTMODIFIEDDATE()).isEqualTo(UPDATED_L_ASTMODIFIEDDATE);
    }

    @Test
    @Transactional
    public void updateNonExistingRNS_REFR_MASTER() throws Exception {
        int databaseSizeBeforeUpdate = rNS_REFR_MASTERRepository.findAll().size();

        // Create the RNS_REFR_MASTER

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRNS_REFR_MASTERMockMvc.perform(put("/api/rns-refr-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rNS_REFR_MASTER)))
            .andExpect(status().isCreated());

        // Validate the RNS_REFR_MASTER in the database
        List<RNS_REFR_MASTER> rNS_REFR_MASTERList = rNS_REFR_MASTERRepository.findAll();
        assertThat(rNS_REFR_MASTERList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRNS_REFR_MASTER() throws Exception {
        // Initialize the database
        rNS_REFR_MASTERRepository.saveAndFlush(rNS_REFR_MASTER);
        int databaseSizeBeforeDelete = rNS_REFR_MASTERRepository.findAll().size();

        // Get the rNS_REFR_MASTER
        restRNS_REFR_MASTERMockMvc.perform(delete("/api/rns-refr-masters/{id}", rNS_REFR_MASTER.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RNS_REFR_MASTER> rNS_REFR_MASTERList = rNS_REFR_MASTERRepository.findAll();
        assertThat(rNS_REFR_MASTERList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RNS_REFR_MASTER.class);
        RNS_REFR_MASTER rNS_REFR_MASTER1 = new RNS_REFR_MASTER();
        rNS_REFR_MASTER1.setId(1L);
        RNS_REFR_MASTER rNS_REFR_MASTER2 = new RNS_REFR_MASTER();
        rNS_REFR_MASTER2.setId(rNS_REFR_MASTER1.getId());
        assertThat(rNS_REFR_MASTER1).isEqualTo(rNS_REFR_MASTER2);
        rNS_REFR_MASTER2.setId(2L);
        assertThat(rNS_REFR_MASTER1).isNotEqualTo(rNS_REFR_MASTER2);
        rNS_REFR_MASTER1.setId(null);
        assertThat(rNS_REFR_MASTER1).isNotEqualTo(rNS_REFR_MASTER2);
    }
}
