import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_EMP_MASTERService,
    RNS_EMP_MASTERPopupService,
    RNS_EMP_MASTERComponent,
    RNS_EMP_MASTERDetailComponent,
    RNS_EMP_MASTERDialogComponent,
    RNS_EMP_MASTERPopupComponent,
    RNS_EMP_MASTERDeletePopupComponent,
    RNS_EMP_MASTERDeleteDialogComponent,
    rNS_EMP_MASTERRoute,
    rNS_EMP_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_EMP_MASTERRoute,
    ...rNS_EMP_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_EMP_MASTERComponent,
        RNS_EMP_MASTERDetailComponent,
        RNS_EMP_MASTERDialogComponent,
        RNS_EMP_MASTERDeleteDialogComponent,
        RNS_EMP_MASTERPopupComponent,
        RNS_EMP_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_EMP_MASTERComponent,
        RNS_EMP_MASTERDialogComponent,
        RNS_EMP_MASTERPopupComponent,
        RNS_EMP_MASTERDeleteDialogComponent,
        RNS_EMP_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_EMP_MASTERService,
        RNS_EMP_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_EMP_MASTERModule {}
