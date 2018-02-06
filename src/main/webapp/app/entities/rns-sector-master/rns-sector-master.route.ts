import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_SECTOR_MASTERComponent } from './rns-sector-master.component';
import { RNS_SECTOR_MASTERDetailComponent } from './rns-sector-master-detail.component';
import { RNS_SECTOR_MASTERPopupComponent } from './rns-sector-master-dialog.component';
import { RNS_SECTOR_MASTERDeletePopupComponent } from './rns-sector-master-delete-dialog.component';

export const rNS_SECTOR_MASTERRoute: Routes = [
    {
        path: 'rns-sector-master',
        component: RNS_SECTOR_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_SECTOR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-sector-master/:id',
        component: RNS_SECTOR_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_SECTOR_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_SECTOR_MASTERPopupRoute: Routes = [
    {
        path: 'rns-sector-master-new',
        component: RNS_SECTOR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_SECTOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-sector-master/:id/edit',
        component: RNS_SECTOR_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_SECTOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-sector-master/:id/delete',
        component: RNS_SECTOR_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_SECTOR_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
