import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_VENDOR_MASTER } from './rns-vendor-master.model';
import { RNS_VENDOR_MASTERService } from './rns-vendor-master.service';

@Component({
    selector: 'jhi-rns-vendor-master-detail',
    templateUrl: './rns-vendor-master-detail.component.html'
})
export class RNS_VENDOR_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_VENDOR_MASTER: RNS_VENDOR_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_VENDOR_MASTERService: RNS_VENDOR_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_VENDOR_MASTERS();
    }

    load(id) {
        this.rNS_VENDOR_MASTERService.find(id)
            .subscribe((rNS_VENDOR_MASTERResponse: HttpResponse<RNS_VENDOR_MASTER>) => {
                this.rNS_VENDOR_MASTER = rNS_VENDOR_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_VENDOR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_VENDOR_MASTERListModification',
            (response) => this.load(this.rNS_VENDOR_MASTER.id)
        );
    }
}
