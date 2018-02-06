import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_DEL_PLACE_MASTER } from './rns-del-place-master.model';
import { RNS_DEL_PLACE_MASTERService } from './rns-del-place-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-del-place-master',
    templateUrl: './rns-del-place-master.component.html'
})
export class RNS_DEL_PLACE_MASTERComponent implements OnInit, OnDestroy {
rNS_DEL_PLACE_MASTERS: RNS_DEL_PLACE_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_DEL_PLACE_MASTERService: RNS_DEL_PLACE_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_DEL_PLACE_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_DEL_PLACE_MASTER[]>) => {
                this.rNS_DEL_PLACE_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_DEL_PLACE_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_DEL_PLACE_MASTER) {
        return item.id;
    }
    registerChangeInRNS_DEL_PLACE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_DEL_PLACE_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
