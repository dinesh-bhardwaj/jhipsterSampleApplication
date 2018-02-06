import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { RNS_REFR_MASTERService } from './rns-refr-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-refr-master',
    templateUrl: './rns-refr-master.component.html'
})
export class RNS_REFR_MASTERComponent implements OnInit, OnDestroy {
rNS_REFR_MASTERS: RNS_REFR_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_REFR_MASTERService: RNS_REFR_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_REFR_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_REFR_MASTER[]>) => {
                this.rNS_REFR_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_REFR_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_REFR_MASTER) {
        return item.id;
    }
    registerChangeInRNS_REFR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_REFR_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
