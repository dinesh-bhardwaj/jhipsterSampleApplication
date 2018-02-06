import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_VENDOR_MASTERService,
    RNS_VENDOR_MASTERPopupService,
    RNS_VENDOR_MASTERComponent,
    RNS_VENDOR_MASTERDetailComponent,
    RNS_VENDOR_MASTERDialogComponent,
    RNS_VENDOR_MASTERPopupComponent,
    RNS_VENDOR_MASTERDeletePopupComponent,
    RNS_VENDOR_MASTERDeleteDialogComponent,
    rNS_VENDOR_MASTERRoute,
    rNS_VENDOR_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_VENDOR_MASTERRoute,
    ...rNS_VENDOR_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_VENDOR_MASTERComponent,
        RNS_VENDOR_MASTERDetailComponent,
        RNS_VENDOR_MASTERDialogComponent,
        RNS_VENDOR_MASTERDeleteDialogComponent,
        RNS_VENDOR_MASTERPopupComponent,
        RNS_VENDOR_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_VENDOR_MASTERComponent,
        RNS_VENDOR_MASTERDialogComponent,
        RNS_VENDOR_MASTERPopupComponent,
        RNS_VENDOR_MASTERDeleteDialogComponent,
        RNS_VENDOR_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_VENDOR_MASTERService,
        RNS_VENDOR_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_VENDOR_MASTERModule {}
