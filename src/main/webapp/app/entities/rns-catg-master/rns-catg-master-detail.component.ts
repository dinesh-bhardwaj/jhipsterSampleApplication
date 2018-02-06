import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CATG_MASTER } from './rns-catg-master.model';
import { RNS_CATG_MASTERService } from './rns-catg-master.service';

@Component({
    selector: 'jhi-rns-catg-master-detail',
    templateUrl: './rns-catg-master-detail.component.html'
})
export class RNS_CATG_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_CATG_MASTER: RNS_CATG_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_CATG_MASTERService: RNS_CATG_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_CATG_MASTERS();
    }

    load(id) {
        this.rNS_CATG_MASTERService.find(id)
            .subscribe((rNS_CATG_MASTERResponse: HttpResponse<RNS_CATG_MASTER>) => {
                this.rNS_CATG_MASTER = rNS_CATG_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_CATG_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_CATG_MASTERListModification',
            (response) => this.load(this.rNS_CATG_MASTER.id)
        );
    }
}
