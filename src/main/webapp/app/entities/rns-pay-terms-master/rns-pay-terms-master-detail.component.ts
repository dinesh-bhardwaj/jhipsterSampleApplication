import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { RNS_PAY_TERMS_MASTERService } from './rns-pay-terms-master.service';

@Component({
    selector: 'jhi-rns-pay-terms-master-detail',
    templateUrl: './rns-pay-terms-master-detail.component.html'
})
export class RNS_PAY_TERMS_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_PAY_TERMS_MASTERService: RNS_PAY_TERMS_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_PAY_TERMS_MASTERS();
    }

    load(id) {
        this.rNS_PAY_TERMS_MASTERService.find(id)
            .subscribe((rNS_PAY_TERMS_MASTERResponse: HttpResponse<RNS_PAY_TERMS_MASTER>) => {
                this.rNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_PAY_TERMS_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_PAY_TERMS_MASTERListModification',
            (response) => this.load(this.rNS_PAY_TERMS_MASTER.id)
        );
    }
}
