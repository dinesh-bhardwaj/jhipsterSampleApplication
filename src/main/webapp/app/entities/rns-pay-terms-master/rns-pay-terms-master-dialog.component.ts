import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { RNS_PAY_TERMS_MASTERPopupService } from './rns-pay-terms-master-popup.service';
import { RNS_PAY_TERMS_MASTERService } from './rns-pay-terms-master.service';

@Component({
    selector: 'jhi-rns-pay-terms-master-dialog',
    templateUrl: './rns-pay-terms-master-dialog.component.html'
})
export class RNS_PAY_TERMS_MASTERDialogComponent implements OnInit {

    rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_PAY_TERMS_MASTERService: RNS_PAY_TERMS_MASTERService,
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
        if (this.rNS_PAY_TERMS_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_PAY_TERMS_MASTERService.update(this.rNS_PAY_TERMS_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_PAY_TERMS_MASTERService.create(this.rNS_PAY_TERMS_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_PAY_TERMS_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_PAY_TERMS_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_PAY_TERMS_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_PAY_TERMS_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-pay-terms-master-popup',
    template: ''
})
export class RNS_PAY_TERMS_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_PAY_TERMS_MASTERPopupService: RNS_PAY_TERMS_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_PAY_TERMS_MASTERPopupService
                    .open(RNS_PAY_TERMS_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_PAY_TERMS_MASTERPopupService
                    .open(RNS_PAY_TERMS_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
