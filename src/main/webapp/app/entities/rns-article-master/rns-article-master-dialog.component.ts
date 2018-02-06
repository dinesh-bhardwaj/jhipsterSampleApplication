import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { RNS_ARTICLE_MASTERPopupService } from './rns-article-master-popup.service';
import { RNS_ARTICLE_MASTERService } from './rns-article-master.service';

@Component({
    selector: 'jhi-rns-article-master-dialog',
    templateUrl: './rns-article-master-dialog.component.html'
})
export class RNS_ARTICLE_MASTERDialogComponent implements OnInit {

    rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_ARTICLE_MASTERService: RNS_ARTICLE_MASTERService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.rNS_ARTICLE_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_ARTICLE_MASTERService.update(this.rNS_ARTICLE_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_ARTICLE_MASTERService.create(this.rNS_ARTICLE_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_ARTICLE_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_ARTICLE_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_ARTICLE_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_ARTICLE_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-article-master-popup',
    template: ''
})
export class RNS_ARTICLE_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_ARTICLE_MASTERPopupService: RNS_ARTICLE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_ARTICLE_MASTERPopupService
                    .open(RNS_ARTICLE_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_ARTICLE_MASTERPopupService
                    .open(RNS_ARTICLE_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
