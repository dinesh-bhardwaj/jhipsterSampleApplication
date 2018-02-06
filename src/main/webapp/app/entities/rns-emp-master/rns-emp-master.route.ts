import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_EMP_MASTERComponent } from './rns-emp-master.component';
import { RNS_EMP_MASTERDetailComponent } from './rns-emp-master-detail.component';
import { RNS_EMP_MASTERPopupComponent } from './rns-emp-master-dialog.component';
import { RNS_EMP_MASTERDeletePopupComponent } from './rns-emp-master-delete-dialog.component';

export const rNS_EMP_MASTERRoute: Routes = [
    {
        path: 'rns-emp-master',
        component: RNS_EMP_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_EMP_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-emp-master/:id',
        component: RNS_EMP_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_EMP_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_EMP_MASTERPopupRoute: Routes = [
    {
        path: 'rns-emp-master-new',
        component: RNS_EMP_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_EMP_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-emp-master/:id/edit',
        component: RNS_EMP_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_EMP_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-emp-master/:id/delete',
        component: RNS_EMP_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_EMP_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
