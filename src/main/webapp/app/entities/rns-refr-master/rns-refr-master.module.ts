import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_REFR_MASTERService,
    RNS_REFR_MASTERPopupService,
    RNS_REFR_MASTERComponent,
    RNS_REFR_MASTERDetailComponent,
    RNS_REFR_MASTERDialogComponent,
    RNS_REFR_MASTERPopupComponent,
    RNS_REFR_MASTERDeletePopupComponent,
    RNS_REFR_MASTERDeleteDialogComponent,
    rNS_REFR_MASTERRoute,
    rNS_REFR_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_REFR_MASTERRoute,
    ...rNS_REFR_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_REFR_MASTERComponent,
        RNS_REFR_MASTERDetailComponent,
        RNS_REFR_MASTERDialogComponent,
        RNS_REFR_MASTERDeleteDialogComponent,
        RNS_REFR_MASTERPopupComponent,
        RNS_REFR_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_REFR_MASTERComponent,
        RNS_REFR_MASTERDialogComponent,
        RNS_REFR_MASTERPopupComponent,
        RNS_REFR_MASTERDeleteDialogComponent,
        RNS_REFR_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_REFR_MASTERService,
        RNS_REFR_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_REFR_MASTERModule {}
