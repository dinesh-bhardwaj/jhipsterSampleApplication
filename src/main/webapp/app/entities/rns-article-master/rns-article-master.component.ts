import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { RNS_ARTICLE_MASTERService } from './rns-article-master.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-rns-article-master',
    templateUrl: './rns-article-master.component.html'
})
export class RNS_ARTICLE_MASTERComponent implements OnInit, OnDestroy {
rNS_ARTICLE_MASTERS: RNS_ARTICLE_MASTER[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rNS_ARTICLE_MASTERService: RNS_ARTICLE_MASTERService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.rNS_ARTICLE_MASTERService.query().subscribe(
            (res: HttpResponse<RNS_ARTICLE_MASTER[]>) => {
                this.rNS_ARTICLE_MASTERS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInRNS_ARTICLE_MASTERS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: RNS_ARTICLE_MASTER) {
        return item.id;
    }
    registerChangeInRNS_ARTICLE_MASTERS() {
        this.eventSubscriber = this.eventManager.subscribe('rNS_ARTICLE_MASTERListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
