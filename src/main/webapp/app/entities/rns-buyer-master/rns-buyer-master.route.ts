import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_BUYER_MASTERComponent } from './rns-buyer-master.component';
import { RNS_BUYER_MASTERDetailComponent } from './rns-buyer-master-detail.component';
import { RNS_BUYER_MASTERPopupComponent } from './rns-buyer-master-dialog.component';
import { RNS_BUYER_MASTERDeletePopupComponent } from './rns-buyer-master-delete-dialog.component';

export const rNS_BUYER_MASTERRoute: Routes = [
    {
        path: 'rns-buyer-master',
        component: RNS_BUYER_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_BUYER_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-buyer-master/:id',
        component: RNS_BUYER_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_BUYER_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_BUYER_MASTERPopupRoute: Routes = [
    {
        path: 'rns-buyer-master-new',
        component: RNS_BUYER_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_BUYER_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-buyer-master/:id/edit',
        component: RNS_BUYER_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_BUYER_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-buyer-master/:id/delete',
        component: RNS_BUYER_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_BUYER_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
