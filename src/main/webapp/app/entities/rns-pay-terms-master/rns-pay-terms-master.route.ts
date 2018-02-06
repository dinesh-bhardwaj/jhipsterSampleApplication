import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_PAY_TERMS_MASTERComponent } from './rns-pay-terms-master.component';
import { RNS_PAY_TERMS_MASTERDetailComponent } from './rns-pay-terms-master-detail.component';
import { RNS_PAY_TERMS_MASTERPopupComponent } from './rns-pay-terms-master-dialog.component';
import { RNS_PAY_TERMS_MASTERDeletePopupComponent } from './rns-pay-terms-master-delete-dialog.component';

export const rNS_PAY_TERMS_MASTERRoute: Routes = [
    {
        path: 'rns-pay-terms-master',
        component: RNS_PAY_TERMS_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PAY_TERMS_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-pay-terms-master/:id',
        component: RNS_PAY_TERMS_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PAY_TERMS_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_PAY_TERMS_MASTERPopupRoute: Routes = [
    {
        path: 'rns-pay-terms-master-new',
        component: RNS_PAY_TERMS_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PAY_TERMS_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-pay-terms-master/:id/edit',
        component: RNS_PAY_TERMS_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PAY_TERMS_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-pay-terms-master/:id/delete',
        component: RNS_PAY_TERMS_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PAY_TERMS_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
