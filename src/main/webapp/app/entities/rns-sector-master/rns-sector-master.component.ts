import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_SECTOR_MASTER } from './rns-sector-master.model';
import { RNS_SECTOR_MASTERService } from './rns-sector-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-sector-master',
    templateUrl: './rns-sector-master.component.html'
})
export class RNS_SECTOR_MASTERComponent implements OnInit, OnDestroy {
rNS_SECTOR_MASTERS: RNS_SECTOR_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_SECTOR_MASTERService: RNS_SECTOR_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_SECTOR_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_SECTOR_MASTER[]>) => {
                this.rNS_SECTOR_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_SECTOR_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_SECTOR_MASTER) {
        return item.id;
    }
    registerChangeInRNS_SECTOR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_SECTOR_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
