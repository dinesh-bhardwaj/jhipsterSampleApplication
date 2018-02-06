import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_TYPE_MASTER } from './rns-type-master.model';
import { RNS_TYPE_MASTERService } from './rns-type-master.service';

@Component({
    selector: 'jhi-rns-type-master-detail',
    templateUrl: './rns-type-master-detail.component.html'
})
export class RNS_TYPE_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_TYPE_MASTER: RNS_TYPE_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_TYPE_MASTERService: RNS_TYPE_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_TYPE_MASTERS();
    }

    load(id) {
        this.rNS_TYPE_MASTERService.find(id)
            .subscribe((rNS_TYPE_MASTERResponse: HttpResponse<RNS_TYPE_MASTER>) => {
                this.rNS_TYPE_MASTER = rNS_TYPE_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_TYPE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_TYPE_MASTERListModification',
            (response) => this.load(this.rNS_TYPE_MASTER.id)
        );
    }
}
