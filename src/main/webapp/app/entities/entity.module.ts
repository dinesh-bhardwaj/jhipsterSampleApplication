import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { JhipsterSampleApplicationRNS_REFR_MASTERModule } from './rns-refr-master/rns-refr-master.module';
import { JhipsterSampleApplicationRNS_REFR_DETAILSModule } from './rns-refr-details/rns-refr-details.module';
import { JhipsterSampleApplicationRNS_ARTICLE_MASTERModule } from './rns-article-master/rns-article-master.module';
import { JhipsterSampleApplicationRNS_EMP_MASTERModule } from './rns-emp-master/rns-emp-master.module';
import { JhipsterSampleApplicationRNS_SECTOR_MASTERModule } from './rns-sector-master/rns-sector-master.module';
import { JhipsterSampleApplicationRNS_TYPE_MASTERModule } from './rns-type-master/rns-type-master.module';
import { JhipsterSampleApplicationRNS_CATG_MASTERModule } from './rns-catg-master/rns-catg-master.module';
import { JhipsterSampleApplicationRNS_PAY_TERMS_MASTERModule } from './rns-pay-terms-master/rns-pay-terms-master.module';
import { JhipsterSampleApplicationRNS_VENDOR_MASTERModule } from './rns-vendor-master/rns-vendor-master.module';
import { JhipsterSampleApplicationRNS_BUYER_MASTERModule } from './rns-buyer-master/rns-buyer-master.module';
import { JhipsterSampleApplicationRNS_DEL_PLACE_MASTERModule } from './rns-del-place-master/rns-del-place-master.module';
import { JhipsterSampleApplicationRNS_PCH_MASTERModule } from './rns-pch-master/rns-pch-master.module';
import { JhipsterSampleApplicationRNS_CRM_REQUEST_MASTERModule } from './rns-crm-request-master/rns-crm-request-master.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        JhipsterSampleApplicationRNS_REFR_MASTERModule,
        JhipsterSampleApplicationRNS_REFR_DETAILSModule,
        JhipsterSampleApplicationRNS_ARTICLE_MASTERModule,
        JhipsterSampleApplicationRNS_EMP_MASTERModule,
        JhipsterSampleApplicationRNS_SECTOR_MASTERModule,
        JhipsterSampleApplicationRNS_TYPE_MASTERModule,
        JhipsterSampleApplicationRNS_CATG_MASTERModule,
        JhipsterSampleApplicationRNS_PAY_TERMS_MASTERModule,
        JhipsterSampleApplicationRNS_VENDOR_MASTERModule,
        JhipsterSampleApplicationRNS_BUYER_MASTERModule,
        JhipsterSampleApplicationRNS_DEL_PLACE_MASTERModule,
        JhipsterSampleApplicationRNS_PCH_MASTERModule,
        JhipsterSampleApplicationRNS_CRM_REQUEST_MASTERModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationEntityModule {}
