import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_VENDOR_MASTERComponent } from './rns-vendor-master.component';
import { RNS_VENDOR_MASTERDetailComponent } from './rns-vendor-master-detail.component';
import { RNS_VENDOR_MASTERPopupComponent } from './rns-vendor-master-dialog.component';
import { RNS_VENDOR_MASTERDeletePopupComponent } from './rns-vendor-master-delete-dialog.component';

export const rNS_VENDOR_MASTERRoute: Routes = [
    {
        path: 'rns-vendor-master',
        component: RNS_VENDOR_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_VENDOR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-vendor-master/:id',
        component: RNS_VENDOR_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_VENDOR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_VENDOR_MASTERPopupRoute: Routes = [
    {
        path: 'rns-vendor-master-new',
        component: RNS_VENDOR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_VENDOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-vendor-master/:id/edit',
        component: RNS_VENDOR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_VENDOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-vendor-master/:id/delete',
        component: RNS_VENDOR_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_VENDOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
