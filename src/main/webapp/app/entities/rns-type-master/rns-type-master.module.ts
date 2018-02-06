import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_TYPE_MASTERService,
    RNS_TYPE_MASTERPopupService,
    RNS_TYPE_MASTERComponent,
    RNS_TYPE_MASTERDetailComponent,
    RNS_TYPE_MASTERDialogComponent,
    RNS_TYPE_MASTERPopupComponent,
    RNS_TYPE_MASTERDeletePopupComponent,
    RNS_TYPE_MASTERDeleteDialogComponent,
    rNS_TYPE_MASTERRoute,
    rNS_TYPE_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_TYPE_MASTERRoute,
    ...rNS_TYPE_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_TYPE_MASTERComponent,
        RNS_TYPE_MASTERDetailComponent,
        RNS_TYPE_MASTERDialogComponent,
        RNS_TYPE_MASTERDeleteDialogComponent,
        RNS_TYPE_MASTERPopupComponent,
        RNS_TYPE_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_TYPE_MASTERComponent,
        RNS_TYPE_MASTERDialogComponent,
        RNS_TYPE_MASTERPopupComponent,
        RNS_TYPE_MASTERDeleteDialogComponent,
        RNS_TYPE_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_TYPE_MASTERService,
        RNS_TYPE_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_TYPE_MASTERModule {}
