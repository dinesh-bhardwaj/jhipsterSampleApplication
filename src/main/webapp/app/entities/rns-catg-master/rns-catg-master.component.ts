import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_CATG_MASTER } from './rns-catg-master.model';
import { RNS_CATG_MASTERService } from './rns-catg-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-catg-master',
    templateUrl: './rns-catg-master.component.html'
})
export class RNS_CATG_MASTERComponent implements OnInit, OnDestroy {
rNS_CATG_MASTERS: RNS_CATG_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_CATG_MASTERService: RNS_CATG_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_CATG_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_CATG_MASTER[]>) => {
                this.rNS_CATG_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_CATG_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_CATG_MASTER) {
        return item.id;
    }
    registerChangeInRNS_CATG_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_CATG_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
