import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_EMP_MASTER } from './rns-emp-master.model';
import { RNS_EMP_MASTERService } from './rns-emp-master.service';

@Component({
    selector: 'jhi-rns-emp-master-detail',
    templateUrl: './rns-emp-master-detail.component.html'
})
export class RNS_EMP_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_EMP_MASTER: RNS_EMP_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_EMP_MASTERService: RNS_EMP_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_EMP_MASTERS();
    }

    load(id) {
        this.rNS_EMP_MASTERService.find(id)
            .subscribe((rNS_EMP_MASTERResponse: HttpResponse<RNS_EMP_MASTER>) => {
                this.rNS_EMP_MASTER = rNS_EMP_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_EMP_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_EMP_MASTERListModification',
            (response) => this.load(this.rNS_EMP_MASTER.id)
        );
    }
}
