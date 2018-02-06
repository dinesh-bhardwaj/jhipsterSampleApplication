import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { RNS_PCH_MASTERService } from './rns-pch-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-pch-master',
    templateUrl: './rns-pch-master.component.html'
})
export class RNS_PCH_MASTERComponent implements OnInit, OnDestroy {
rNS_PCH_MASTERS: RNS_PCH_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_PCH_MASTERService: RNS_PCH_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_PCH_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_PCH_MASTER[]>) => {
                this.rNS_PCH_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_PCH_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_PCH_MASTER) {
        return item.id;
    }
    registerChangeInRNS_PCH_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_PCH_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
