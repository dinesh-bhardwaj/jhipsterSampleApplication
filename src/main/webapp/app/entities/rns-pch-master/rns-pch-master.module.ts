import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_PCH_MASTERService,
    RNS_PCH_MASTERPopupService,
    RNS_PCH_MASTERComponent,
    RNS_PCH_MASTERDetailComponent,
    RNS_PCH_MASTERDialogComponent,
    RNS_PCH_MASTERPopupComponent,
    RNS_PCH_MASTERDeletePopupComponent,
    RNS_PCH_MASTERDeleteDialogComponent,
    rNS_PCH_MASTERRoute,
    rNS_PCH_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_PCH_MASTERRoute,
    ...rNS_PCH_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_PCH_MASTERComponent,
        RNS_PCH_MASTERDetailComponent,
        RNS_PCH_MASTERDialogComponent,
        RNS_PCH_MASTERDeleteDialogComponent,
        RNS_PCH_MASTERPopupComponent,
        RNS_PCH_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_PCH_MASTERComponent,
        RNS_PCH_MASTERDialogComponent,
        RNS_PCH_MASTERPopupComponent,
        RNS_PCH_MASTERDeleteDialogComponent,
        RNS_PCH_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_PCH_MASTERService,
        RNS_PCH_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_PCH_MASTERModule {}
