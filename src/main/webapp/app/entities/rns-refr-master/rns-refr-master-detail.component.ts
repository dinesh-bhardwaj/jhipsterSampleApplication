import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { RNS_REFR_MASTERService } from './rns-refr-master.service';

@Component({
    selector: 'jhi-rns-refr-master-detail',
    templateUrl: './rns-refr-master-detail.component.html'
})
export class RNS_REFR_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_REFR_MASTER: RNS_REFR_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_REFR_MASTERService: RNS_REFR_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_REFR_MASTERS();
    }

    load(id) {
        this.rNS_REFR_MASTERService.find(id)
            .subscribe((rNS_REFR_MASTERResponse: HttpResponse<RNS_REFR_MASTER>) => {
                this.rNS_REFR_MASTER = rNS_REFR_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_REFR_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_REFR_MASTERListModification',
            (response) => this.load(this.rNS_REFR_MASTER.id)
        );
    }
}
