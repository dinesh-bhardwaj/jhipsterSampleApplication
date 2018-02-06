import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_SECTOR_MASTERService,
    RNS_SECTOR_MASTERPopupService,
    RNS_SECTOR_MASTERComponent,
    RNS_SECTOR_MASTERDetailComponent,
    RNS_SECTOR_MASTERDialogComponent,
    RNS_SECTOR_MASTERPopupComponent,
    RNS_SECTOR_MASTERDeletePopupComponent,
    RNS_SECTOR_MASTERDeleteDialogComponent,
    rNS_SECTOR_MASTERRoute,
    rNS_SECTOR_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_SECTOR_MASTERRoute,
    ...rNS_SECTOR_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_SECTOR_MASTERComponent,
        RNS_SECTOR_MASTERDetailComponent,
        RNS_SECTOR_MASTERDialogComponent,
        RNS_SECTOR_MASTERDeleteDialogComponent,
        RNS_SECTOR_MASTERPopupComponent,
        RNS_SECTOR_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_SECTOR_MASTERComponent,
        RNS_SECTOR_MASTERDialogComponent,
        RNS_SECTOR_MASTERPopupComponent,
        RNS_SECTOR_MASTERDeleteDialogComponent,
        RNS_SECTOR_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_SECTOR_MASTERService,
        RNS_SECTOR_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_SECTOR_MASTERModule {}
