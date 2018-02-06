import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_DEL_PLACE_MASTER } from './rns-del-place-master.model';
import { RNS_DEL_PLACE_MASTERService } from './rns-del-place-master.service';

@Component({
    selector: 'jhi-rns-del-place-master-detail',
    templateUrl: './rns-del-place-master-detail.component.html'
})
export class RNS_DEL_PLACE_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_DEL_PLACE_MASTER: RNS_DEL_PLACE_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_DEL_PLACE_MASTERService: RNS_DEL_PLACE_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_DEL_PLACE_MASTERS();
    }

    load(id) {
        this.rNS_DEL_PLACE_MASTERService.find(id)
            .subscribe((rNS_DEL_PLACE_MASTERResponse: HttpResponse<RNS_DEL_PLACE_MASTER>) => {
                this.rNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_DEL_PLACE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_DEL_PLACE_MASTERListModification',
            (response) => this.load(this.rNS_DEL_PLACE_MASTER.id)
        );
    }
}
