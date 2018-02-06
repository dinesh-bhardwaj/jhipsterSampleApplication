import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_BUYER_MASTER } from './rns-buyer-master.model';
import { RNS_BUYER_MASTERPopupService } from './rns-buyer-master-popup.service';
import { RNS_BUYER_MASTERService } from './rns-buyer-master.service';

@Component({
    selector: 'jhi-rns-buyer-master-dialog',
    templateUrl: './rns-buyer-master-dialog.component.html'
})
export class RNS_BUYER_MASTERDialogComponent implements OnInit {

    rNS_BUYER_MASTER: RNS_BUYER_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_BUYER_MASTERService: RNS_BUYER_MASTERService,
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
        if (this.rNS_BUYER_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_BUYER_MASTERService.update(this.rNS_BUYER_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_BUYER_MASTERService.create(this.rNS_BUYER_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_BUYER_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_BUYER_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_BUYER_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_BUYER_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-buyer-master-popup',
    template: ''
})
export class RNS_BUYER_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_BUYER_MASTERPopupService: RNS_BUYER_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_BUYER_MASTERPopupService
                    .open(RNS_BUYER_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_BUYER_MASTERPopupService
                    .open(RNS_BUYER_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
