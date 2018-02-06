import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { RNS_PCH_MASTERService } from './rns-pch-master.service';

@Component({
    selector: 'jhi-rns-pch-master-detail',
    templateUrl: './rns-pch-master-detail.component.html'
})
export class RNS_PCH_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_PCH_MASTER: RNS_PCH_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_PCH_MASTERService: RNS_PCH_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_PCH_MASTERS();
    }

    load(id) {
        this.rNS_PCH_MASTERService.find(id)
            .subscribe((rNS_PCH_MASTERResponse: HttpResponse<RNS_PCH_MASTER>) => {
                this.rNS_PCH_MASTER = rNS_PCH_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_PCH_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_PCH_MASTERListModification',
            (response) => this.load(this.rNS_PCH_MASTER.id)
        );
    }
}
