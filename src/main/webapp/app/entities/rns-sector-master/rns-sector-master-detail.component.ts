import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_SECTOR_MASTER } from './rns-sector-master.model';
import { RNS_SECTOR_MASTERService } from './rns-sector-master.service';

@Component({
    selector: 'jhi-rns-sector-master-detail',
    templateUrl: './rns-sector-master-detail.component.html'
})
export class RNS_SECTOR_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_SECTOR_MASTER: RNS_SECTOR_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_SECTOR_MASTERService: RNS_SECTOR_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_SECTOR_MASTERS();
    }

    load(id) {
        this.rNS_SECTOR_MASTERService.find(id)
            .subscribe((rNS_SECTOR_MASTERResponse: HttpResponse<RNS_SECTOR_MASTER>) => {
                this.rNS_SECTOR_MASTER = rNS_SECTOR_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_SECTOR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_SECTOR_MASTERListModification',
            (response) => this.load(this.rNS_SECTOR_MASTER.id)
        );
    }
}
