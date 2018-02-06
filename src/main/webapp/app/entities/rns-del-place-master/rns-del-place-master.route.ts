import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_DEL_PLACE_MASTERComponent } from './rns-del-place-master.component';
import { RNS_DEL_PLACE_MASTERDetailComponent } from './rns-del-place-master-detail.component';
import { RNS_DEL_PLACE_MASTERPopupComponent } from './rns-del-place-master-dialog.component';
import { RNS_DEL_PLACE_MASTERDeletePopupComponent } from './rns-del-place-master-delete-dialog.component';

export const rNS_DEL_PLACE_MASTERRoute: Routes = [
    {
        path: 'rns-del-place-master',
        component: RNS_DEL_PLACE_MASTERComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_DEL_PLACE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-del-place-master/:id',
        component: RNS_DEL_PLACE_MASTERDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_DEL_PLACE_MASTERS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_DEL_PLACE_MASTERPopupRoute: Routes = [
    {
        path: 'rns-del-place-master-new',
        component: RNS_DEL_PLACE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_DEL_PLACE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-del-place-master/:id/edit',
        component: RNS_DEL_PLACE_MASTERPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_DEL_PLACE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-del-place-master/:id/delete',
        component: RNS_DEL_PLACE_MASTERDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_DEL_PLACE_MASTERS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
