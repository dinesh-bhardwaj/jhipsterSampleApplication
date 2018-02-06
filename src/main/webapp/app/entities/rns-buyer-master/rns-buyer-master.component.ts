import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_BUYER_MASTER } from './rns-buyer-master.model';
import { RNS_BUYER_MASTERService } from './rns-buyer-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-buyer-master',
    templateUrl: './rns-buyer-master.component.html'
})
export class RNS_BUYER_MASTERComponent implements OnInit, OnDestroy {
rNS_BUYER_MASTERS: RNS_BUYER_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_BUYER_MASTERService: RNS_BUYER_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_BUYER_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_BUYER_MASTER[]>) => {
                this.rNS_BUYER_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_BUYER_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_BUYER_MASTER) {
        return item.id;
    }
    registerChangeInRNS_BUYER_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_BUYER_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
