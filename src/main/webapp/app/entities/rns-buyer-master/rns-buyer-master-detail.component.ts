import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_BUYER_MASTER } from './rns-buyer-master.model';
import { RNS_BUYER_MASTERService } from './rns-buyer-master.service';

@Component({
    selector: 'jhi-rns-buyer-master-detail',
    templateUrl: './rns-buyer-master-detail.component.html'
})
export class RNS_BUYER_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_BUYER_MASTER: RNS_BUYER_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_BUYER_MASTERService: RNS_BUYER_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_BUYER_MASTERS();
    }

    load(id) {
        this.rNS_BUYER_MASTERService.find(id)
            .subscribe((rNS_BUYER_MASTERResponse: HttpResponse<RNS_BUYER_MASTER>) => {
                this.rNS_BUYER_MASTER = rNS_BUYER_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_BUYER_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_BUYER_MASTERListModification',
            (response) => this.load(this.rNS_BUYER_MASTER.id)
        );
    }
}
