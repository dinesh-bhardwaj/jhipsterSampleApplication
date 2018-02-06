import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_TYPE_MASTERComponent } from './rns-type-master.component';
import { RNS_TYPE_MASTERDetailComponent } from './rns-type-master-detail.component';
import { RNS_TYPE_MASTERPopupComponent } from './rns-type-master-dialog.component';
import { RNS_TYPE_MASTERDeletePopupComponent } from './rns-type-master-delete-dialog.component';

export const rNS_TYPE_MASTERRoute: Routes = [
    {
        path: 'rns-type-master',
        component: RNS_TYPE_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_TYPE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-type-master/:id',
        component: RNS_TYPE_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_TYPE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_TYPE_MASTERPopupRoute: Routes = [
    {
        path: 'rns-type-master-new',
        component: RNS_TYPE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_TYPE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-type-master/:id/edit',
        component: RNS_TYPE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_TYPE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-type-master/:id/delete',
        component: RNS_TYPE_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_TYPE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
