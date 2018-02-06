import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_CRM_REQUEST_MASTERComponent } from './rns-crm-request-master.component';
import { RNS_CRM_REQUEST_MASTERDetailComponent } from './rns-crm-request-master-detail.component';
import { RNS_CRM_REQUEST_MASTERPopupComponent } from './rns-crm-request-master-dialog.component';
import { RNS_CRM_REQUEST_MASTERDeletePopupComponent } from './rns-crm-request-master-delete-dialog.component';

export const rNS_CRM_REQUEST_MASTERRoute: Routes = [
    {
        path: 'rns-crm-request-master',
        component: RNS_CRM_REQUEST_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CRM_REQUEST_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-crm-request-master/:id',
        component: RNS_CRM_REQUEST_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CRM_REQUEST_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_CRM_REQUEST_MASTERPopupRoute: Routes = [
    {
        path: 'rns-crm-request-master-new',
        component: RNS_CRM_REQUEST_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CRM_REQUEST_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-crm-request-master/:id/edit',
        component: RNS_CRM_REQUEST_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CRM_REQUEST_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-crm-request-master/:id/delete',
        component: RNS_CRM_REQUEST_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CRM_REQUEST_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
