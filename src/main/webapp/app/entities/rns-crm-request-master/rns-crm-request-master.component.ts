import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { RNS_CRM_REQUEST_MASTERService } from './rns-crm-request-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-crm-request-master',
    templateUrl: './rns-crm-request-master.component.html'
})
export class RNS_CRM_REQUEST_MASTERComponent implements OnInit, OnDestroy {
rNS_CRM_REQUEST_MASTERS: RNS_CRM_REQUEST_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_CRM_REQUEST_MASTERService: RNS_CRM_REQUEST_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_CRM_REQUEST_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_CRM_REQUEST_MASTER[]>) => {
                this.rNS_CRM_REQUEST_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_CRM_REQUEST_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_CRM_REQUEST_MASTER) {
        return item.id;
    }
    registerChangeInRNS_CRM_REQUEST_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_CRM_REQUEST_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
