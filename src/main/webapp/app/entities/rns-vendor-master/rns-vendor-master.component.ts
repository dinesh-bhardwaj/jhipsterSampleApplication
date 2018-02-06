import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_VENDOR_MASTER } from './rns-vendor-master.model';
import { RNS_VENDOR_MASTERService } from './rns-vendor-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-vendor-master',
    templateUrl: './rns-vendor-master.component.html'
})
export class RNS_VENDOR_MASTERComponent implements OnInit, OnDestroy {
rNS_VENDOR_MASTERS: RNS_VENDOR_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_VENDOR_MASTERService: RNS_VENDOR_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_VENDOR_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_VENDOR_MASTER[]>) => {
                this.rNS_VENDOR_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_VENDOR_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_VENDOR_MASTER) {
        return item.id;
    }
    registerChangeInRNS_VENDOR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_VENDOR_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
