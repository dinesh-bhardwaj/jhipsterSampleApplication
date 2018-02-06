import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_CATG_MASTERComponent } from './rns-catg-master.component';
import { RNS_CATG_MASTERDetailComponent } from './rns-catg-master-detail.component';
import { RNS_CATG_MASTERPopupComponent } from './rns-catg-master-dialog.component';
import { RNS_CATG_MASTERDeletePopupComponent } from './rns-catg-master-delete-dialog.component';

export const rNS_CATG_MASTERRoute: Routes = [
    {
        path: 'rns-catg-master',
        component: RNS_CATG_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CATG_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-catg-master/:id',
        component: RNS_CATG_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CATG_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_CATG_MASTERPopupRoute: Routes = [
    {
        path: 'rns-catg-master-new',
        component: RNS_CATG_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CATG_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-catg-master/:id/edit',
        component: RNS_CATG_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CATG_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-catg-master/:id/delete',
        component: RNS_CATG_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_CATG_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
