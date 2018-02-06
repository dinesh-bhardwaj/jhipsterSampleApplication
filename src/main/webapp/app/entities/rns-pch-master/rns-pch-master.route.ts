import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_PCH_MASTERComponent } from './rns-pch-master.component';
import { RNS_PCH_MASTERDetailComponent } from './rns-pch-master-detail.component';
import { RNS_PCH_MASTERPopupComponent } from './rns-pch-master-dialog.component';
import { RNS_PCH_MASTERDeletePopupComponent } from './rns-pch-master-delete-dialog.component';

export const rNS_PCH_MASTERRoute: Routes = [
    {
        path: 'rns-pch-master',
        component: RNS_PCH_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PCH_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-pch-master/:id',
        component: RNS_PCH_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PCH_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_PCH_MASTERPopupRoute: Routes = [
    {
        path: 'rns-pch-master-new',
        component: RNS_PCH_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PCH_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-pch-master/:id/edit',
        component: RNS_PCH_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PCH_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-pch-master/:id/delete',
        component: RNS_PCH_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_PCH_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
