import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { RNS_CRM_REQUEST_MASTERService } from './rns-crm-request-master.service';

@Component({
    selector: 'jhi-rns-crm-request-master-detail',
    templateUrl: './rns-crm-request-master-detail.component.html'
})
export class RNS_CRM_REQUEST_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_CRM_REQUEST_MASTERService: RNS_CRM_REQUEST_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_CRM_REQUEST_MASTERS();
    }

    load(id) {
        this.rNS_CRM_REQUEST_MASTERService.find(id)
            .subscribe((rNS_CRM_REQUEST_MASTERResponse: HttpResponse<RNS_CRM_REQUEST_MASTER>) => {
                this.rNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_CRM_REQUEST_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_CRM_REQUEST_MASTERListModification',
            (response) => this.load(this.rNS_CRM_REQUEST_MASTER.id)
        );
    }
}
