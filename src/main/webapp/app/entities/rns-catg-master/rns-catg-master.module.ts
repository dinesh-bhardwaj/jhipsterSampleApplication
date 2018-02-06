import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_CATG_MASTERService,
    RNS_CATG_MASTERPopupService,
    RNS_CATG_MASTERComponent,
    RNS_CATG_MASTERDetailComponent,
    RNS_CATG_MASTERDialogComponent,
    RNS_CATG_MASTERPopupComponent,
    RNS_CATG_MASTERDeletePopupComponent,
    RNS_CATG_MASTERDeleteDialogComponent,
    rNS_CATG_MASTERRoute,
    rNS_CATG_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_CATG_MASTERRoute,
    ...rNS_CATG_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_CATG_MASTERComponent,
        RNS_CATG_MASTERDetailComponent,
        RNS_CATG_MASTERDialogComponent,
        RNS_CATG_MASTERDeleteDialogComponent,
        RNS_CATG_MASTERPopupComponent,
        RNS_CATG_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_CATG_MASTERComponent,
        RNS_CATG_MASTERDialogComponent,
        RNS_CATG_MASTERPopupComponent,
        RNS_CATG_MASTERDeleteDialogComponent,
        RNS_CATG_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_CATG_MASTERService,
        RNS_CATG_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_CATG_MASTERModule {}
