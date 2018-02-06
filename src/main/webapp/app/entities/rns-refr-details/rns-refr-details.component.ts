import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_REFR_DETAILS } from './rns-refr-details.model';
import { RNS_REFR_DETAILSService } from './rns-refr-details.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-refr-details',
    templateUrl: './rns-refr-details.component.html'
})
export class RNS_REFR_DETAILSComponent implements OnInit, OnDestroy {
rNS_REFR_DETAILS: RNS_REFR_DETAILS[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_REFR_DETAILSService: RNS_REFR_DETAILSService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_REFR_DETAILSService.query().subscribe(
            (res: HttpResponse<RNS_REFR_DETAILS[]>) => {
                this.rNS_REFR_DETAILS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_REFR_DETAILS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_REFR_DETAILS) {
        return item.id;
    }
    registerChangeInRNS_REFR_DETAILS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_REFR_DETAILSListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
