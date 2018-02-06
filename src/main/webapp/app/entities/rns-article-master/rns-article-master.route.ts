import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_ARTICLE_MASTERComponent } from './rns-article-master.component';
import { RNS_ARTICLE_MASTERDetailComponent } from './rns-article-master-detail.component';
import { RNS_ARTICLE_MASTERPopupComponent } from './rns-article-master-dialog.component';
import { RNS_ARTICLE_MASTERDeletePopupComponent } from './rns-article-master-delete-dialog.component';

export const rNS_ARTICLE_MASTERRoute: Routes = [
    {
        path: 'rns-article-master',
        component: RNS_ARTICLE_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_ARTICLE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-article-master/:id',
        component: RNS_ARTICLE_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_ARTICLE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_ARTICLE_MASTERPopupRoute: Routes = [
    {
        path: 'rns-article-master-new',
        component: RNS_ARTICLE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_ARTICLE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-article-master/:id/edit',
        component: RNS_ARTICLE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_ARTICLE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-article-master/:id/delete',
        component: RNS_ARTICLE_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_ARTICLE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
