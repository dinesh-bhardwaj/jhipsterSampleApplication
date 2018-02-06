import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_REFR_MASTERComponent } from './rns-refr-master.component';
import { RNS_REFR_MASTERDetailComponent } from './rns-refr-master-detail.component';
import { RNS_REFR_MASTERPopupComponent } from './rns-refr-master-dialog.component';
import { RNS_REFR_MASTERDeletePopupComponent } from './rns-refr-master-delete-dialog.component';

export const rNS_REFR_MASTERRoute: Routes = [
    {
        path: 'rns-refr-master',
        component: RNS_REFR_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-refr-master/:id',
        component: RNS_REFR_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_REFR_MASTERPopupRoute: Routes = [
    {
        path: 'rns-refr-master-new',
        component: RNS_REFR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-refr-master/:id/edit',
        component: RNS_REFR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-refr-master/:id/delete',
        component: RNS_REFR_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
