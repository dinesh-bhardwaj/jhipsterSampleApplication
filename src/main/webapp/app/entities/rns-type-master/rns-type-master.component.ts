import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_TYPE_MASTER } from './rns-type-master.model';
import { RNS_TYPE_MASTERService } from './rns-type-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-type-master',
    templateUrl: './rns-type-master.component.html'
})
export class RNS_TYPE_MASTERComponent implements OnInit, OnDestroy {
rNS_TYPE_MASTERS: RNS_TYPE_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_TYPE_MASTERService: RNS_TYPE_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_TYPE_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_TYPE_MASTER[]>) => {
                this.rNS_TYPE_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_TYPE_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_TYPE_MASTER) {
        return item.id;
    }
    registerChangeInRNS_TYPE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_TYPE_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
