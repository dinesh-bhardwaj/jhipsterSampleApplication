import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_BUYER_MASTERService,
    RNS_BUYER_MASTERPopupService,
    RNS_BUYER_MASTERComponent,
    RNS_BUYER_MASTERDetailComponent,
    RNS_BUYER_MASTERDialogComponent,
    RNS_BUYER_MASTERPopupComponent,
    RNS_BUYER_MASTERDeletePopupComponent,
    RNS_BUYER_MASTERDeleteDialogComponent,
    rNS_BUYER_MASTERRoute,
    rNS_BUYER_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_BUYER_MASTERRoute,
    ...rNS_BUYER_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_BUYER_MASTERComponent,
        RNS_BUYER_MASTERDetailComponent,
        RNS_BUYER_MASTERDialogComponent,
        RNS_BUYER_MASTERDeleteDialogComponent,
        RNS_BUYER_MASTERPopupComponent,
        RNS_BUYER_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_BUYER_MASTERComponent,
        RNS_BUYER_MASTERDialogComponent,
        RNS_BUYER_MASTERPopupComponent,
        RNS_BUYER_MASTERDeleteDialogComponent,
        RNS_BUYER_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_BUYER_MASTERService,
        RNS_BUYER_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_BUYER_MASTERModule {}
