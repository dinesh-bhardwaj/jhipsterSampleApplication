import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleApplicationSharedModule } from '../../shared';
import {
    RNS_ARTICLE_MASTERService,
    RNS_ARTICLE_MASTERPopupService,
    RNS_ARTICLE_MASTERComponent,
    RNS_ARTICLE_MASTERDetailComponent,
    RNS_ARTICLE_MASTERDialogComponent,
    RNS_ARTICLE_MASTERPopupComponent,
    RNS_ARTICLE_MASTERDeletePopupComponent,
    RNS_ARTICLE_MASTERDeleteDialogComponent,
    rNS_ARTICLE_MASTERRoute,
    rNS_ARTICLE_MASTERPopupRoute,
} from './';

const ENTITY_STATES = [
    ...rNS_ARTICLE_MASTERRoute,
    ...rNS_ARTICLE_MASTERPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSampleApplicationSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RNS_ARTICLE_MASTERComponent,
        RNS_ARTICLE_MASTERDetailComponent,
        RNS_ARTICLE_MASTERDialogComponent,
        RNS_ARTICLE_MASTERDeleteDialogComponent,
        RNS_ARTICLE_MASTERPopupComponent,
        RNS_ARTICLE_MASTERDeletePopupComponent,
    ],
    entryComponents: [
        RNS_ARTICLE_MASTERComponent,
        RNS_ARTICLE_MASTERDialogComponent,
        RNS_ARTICLE_MASTERPopupComponent,
        RNS_ARTICLE_MASTERDeleteDialogComponent,
        RNS_ARTICLE_MASTERDeletePopupComponent,
    ],
    providers: [
        RNS_ARTICLE_MASTERService,
        RNS_ARTICLE_MASTERPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSampleApplicationRNS_ARTICLE_MASTERModule {}
