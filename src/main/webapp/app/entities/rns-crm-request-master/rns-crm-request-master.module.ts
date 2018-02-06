import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_CRM_REQUEST_MASTERService,
    RNS_CRM_REQUEST_MASTERPopupService,
    RNS_CRM_REQUEST_MASTERComponent,
    RNS_CRM_REQUEST_MASTERDetailComponent,
    RNS_CRM_REQUEST_MASTERDialogComponent,
    RNS_CRM_REQUEST_MASTERPopupComponent,
    RNS_CRM_REQUEST_MASTERDeletePopupComponent,
    RNS_CRM_REQUEST_MASTERDeleteDialogComponent,
    rNS_CRM_REQUEST_MASTERRoute,
    rNS_CRM_REQUEST_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_CRM_REQUEST_MASTERRoute,
    ...rNS_CRM_REQUEST_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_CRM_REQUEST_MASTERComponent,
        RNS_CRM_REQUEST_MASTERDetailComponent,
        RNS_CRM_REQUEST_MASTERDialogComponent,
        RNS_CRM_REQUEST_MASTERDeleteDialogComponent,
        RNS_CRM_REQUEST_MASTERPopupComponent,
        RNS_CRM_REQUEST_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_CRM_REQUEST_MASTERComponent,
        RNS_CRM_REQUEST_MASTERDialogComponent,
        RNS_CRM_REQUEST_MASTERPopupComponent,
        RNS_CRM_REQUEST_MASTERDeleteDialogComponent,
        RNS_CRM_REQUEST_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_CRM_REQUEST_MASTERService,
        RNS_CRM_REQUEST_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_CRM_REQUEST_MASTERModule {}
