import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { RNS_PAY_TERMS_MASTERService } from './rns-pay-terms-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-pay-terms-master',
    templateUrl: './rns-pay-terms-master.component.html'
})
export class RNS_PAY_TERMS_MASTERComponent implements OnInit, OnDestroy {
rNS_PAY_TERMS_MASTERS: RNS_PAY_TERMS_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_PAY_TERMS_MASTERService: RNS_PAY_TERMS_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_PAY_TERMS_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_PAY_TERMS_MASTER[]>) => {
                this.rNS_PAY_TERMS_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_PAY_TERMS_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_PAY_TERMS_MASTER) {
        return item.id;
    }
    registerChangeInRNS_PAY_TERMS_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_PAY_TERMS_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
