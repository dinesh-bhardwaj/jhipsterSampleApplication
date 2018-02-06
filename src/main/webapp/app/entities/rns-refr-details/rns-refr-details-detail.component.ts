import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_REFR_DETAILS } from './rns-refr-details.model';
import { RNS_REFR_DETAILSService } from './rns-refr-details.service';

@Component({
    selector: 'jhi-rns-refr-details-detail',
    templateUrl: './rns-refr-details-detail.component.html'
})
export class RNS_REFR_DETAILSDetailComponent implements OnInit, OnDestroy {

    rNS_REFR_DETAILS: RNS_REFR_DETAILS;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_REFR_DETAILSService: RNS_REFR_DETAILSService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_REFR_DETAILS();
    }

    load(id) {
        this.rNS_REFR_DETAILSService.find(id)
            .subscribe((rNS_REFR_DETAILSResponse: HttpResponse<RNS_REFR_DETAILS>) => {
                this.rNS_REFR_DETAILS = rNS_REFR_DETAILSResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_REFR_DETAILS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_REFR_DETAILSListModification',
            (response) => this.load(this.rNS_REFR_DETAILS.id)
        );
    }
}
