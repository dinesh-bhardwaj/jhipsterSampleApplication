import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_PAY_TERMS_MASTERService,
    RNS_PAY_TERMS_MASTERPopupService,
    RNS_PAY_TERMS_MASTERComponent,
    RNS_PAY_TERMS_MASTERDetailComponent,
    RNS_PAY_TERMS_MASTERDialogComponent,
    RNS_PAY_TERMS_MASTERPopupComponent,
    RNS_PAY_TERMS_MASTERDeletePopupComponent,
    RNS_PAY_TERMS_MASTERDeleteDialogComponent,
    rNS_PAY_TERMS_MASTERRoute,
    rNS_PAY_TERMS_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_PAY_TERMS_MASTERRoute,
    ...rNS_PAY_TERMS_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_PAY_TERMS_MASTERComponent,
        RNS_PAY_TERMS_MASTERDetailComponent,
        RNS_PAY_TERMS_MASTERDialogComponent,
        RNS_PAY_TERMS_MASTERDeleteDialogComponent,
        RNS_PAY_TERMS_MASTERPopupComponent,
        RNS_PAY_TERMS_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_PAY_TERMS_MASTERComponent,
        RNS_PAY_TERMS_MASTERDialogComponent,
        RNS_PAY_TERMS_MASTERPopupComponent,
        RNS_PAY_TERMS_MASTERDeleteDialogComponent,
        RNS_PAY_TERMS_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_PAY_TERMS_MASTERService,
        RNS_PAY_TERMS_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_PAY_TERMS_MASTERModule {}
