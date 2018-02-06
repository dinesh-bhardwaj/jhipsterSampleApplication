import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { RNS_ARTICLE_MASTERService } from './rns-article-master.service';

@Component({
    selector: 'jhi-rns-article-master-detail',
    templateUrl: './rns-article-master-detail.component.html'
})
export class RNS_ARTICLE_MASTERDetailComponent implements OnInit, OnDestroy {

    rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private rNS_ARTICLE_MASTERService: RNS_ARTICLE_MASTERService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRNS_ARTICLE_MASTERS();
    }

    load(id) {
        this.rNS_ARTICLE_MASTERService.find(id)
            .subscribe((rNS_ARTICLE_MASTERResponse: HttpResponse<RNS_ARTICLE_MASTER>) => {
                this.rNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRNS_ARTICLE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe(
            'rNS_ARTICLE_MASTERListModification',
            (response) => this.load(this.rNS_ARTICLE_MASTER.id)
        );
    }
}
