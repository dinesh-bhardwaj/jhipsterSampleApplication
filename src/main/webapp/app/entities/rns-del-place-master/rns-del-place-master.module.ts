import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_DEL_PLACE_MASTERService,
    RNS_DEL_PLACE_MASTERPopupService,
    RNS_DEL_PLACE_MASTERComponent,
    RNS_DEL_PLACE_MASTERDetailComponent,
    RNS_DEL_PLACE_MASTERDialogComponent,
    RNS_DEL_PLACE_MASTERPopupComponent,
    RNS_DEL_PLACE_MASTERDeletePopupComponent,
    RNS_DEL_PLACE_MASTERDeleteDialogComponent,
    rNS_DEL_PLACE_MASTERRoute,
    rNS_DEL_PLACE_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_DEL_PLACE_MASTERRoute,
    ...rNS_DEL_PLACE_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_DEL_PLACE_MASTERComponent,
        RNS_DEL_PLACE_MASTERDetailComponent,
        RNS_DEL_PLACE_MASTERDialogComponent,
        RNS_DEL_PLACE_MASTERDeleteDialogComponent,
        RNS_DEL_PLACE_MASTERPopupComponent,
        RNS_DEL_PLACE_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_DEL_PLACE_MASTERComponent,
        RNS_DEL_PLACE_MASTERDialogComponent,
        RNS_DEL_PLACE_MASTERPopupComponent,
        RNS_DEL_PLACE_MASTERDeleteDialogComponent,
        RNS_DEL_PLACE_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_DEL_PLACE_MASTERService,
        RNS_DEL_PLACE_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_DEL_PLACE_MASTERModule {}
