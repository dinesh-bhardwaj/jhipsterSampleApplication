import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_REFR_DETAILSService,
    RNS_REFR_DETAILSPopupService,
    RNS_REFR_DETAILSComponent,
    RNS_REFR_DETAILSDetailComponent,
    RNS_REFR_DETAILSDialogComponent,
    RNS_REFR_DETAILSPopupComponent,
    RNS_REFR_DETAILSDeletePopupComponent,
    RNS_REFR_DETAILSDeleteDialogComponent,
    rNS_REFR_DETAILSRoute,
    rNS_REFR_DETAILSPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_REFR_DETAILSRoute,
    ...rNS_REFR_DETAILSPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_REFR_DETAILSComponent,
        RNS_REFR_DETAILSDetailComponent,
        RNS_REFR_DETAILSDialogComponent,
        RNS_REFR_DETAILSDeleteDialogComponent,
        RNS_REFR_DETAILSPopupComponent,
        RNS_REFR_DETAILSDeletePopupComponent,
    ],
    entryComponents: [
        RNS_REFR_DETAILSComponent,
        RNS_REFR_DETAILSDialogComponent,
        RNS_REFR_DETAILSPopupComponent,
        RNS_REFR_DETAILSDeleteDialogComponent,
        RNS_REFR_DETAILSDeletePopupComponent,
    ],
    providers: [
        RNS_REFR_DETAILSService,
        RNS_REFR_DETAILSPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_REFR_DETAILSModule {}
