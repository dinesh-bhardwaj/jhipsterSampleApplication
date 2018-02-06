import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { RNS_REFR_DETAILSComponent } from './rns-refr-details.component';
import { RNS_REFR_DETAILSDetailComponent } from './rns-refr-details-detail.component';
import { RNS_REFR_DETAILSPopupComponent } from './rns-refr-details-dialog.component';
import { RNS_REFR_DETAILSDeletePopupComponent } from './rns-refr-details-delete-dialog.component';

export const rNS_REFR_DETAILSRoute: Routes = [
    {
        path: 'rns-refr-details',
        component: RNS_REFR_DETAILSComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_DETAILS'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'rns-refr-details/:id',
        component: RNS_REFR_DETAILSDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_DETAILS'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rNS_REFR_DETAILSPopupRoute: Routes = [
    {
        path: 'rns-refr-details-new',
        component: RNS_REFR_DETAILSPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_DETAILS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-refr-details/:id/edit',
        component: RNS_REFR_DETAILSPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_DETAILS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'rns-refr-details/:id/delete',
        component: RNS_REFR_DETAILSDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'RNS_REFR_DETAILS'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
