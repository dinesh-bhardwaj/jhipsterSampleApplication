import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { RNS_CRM_REQUEST_MASTERPopupService } from './rns-crm-request-master-popup.service';
import { RNS_CRM_REQUEST_MASTERService } from './rns-crm-request-master.service';

@Component({
    selector: 'jhi-rns-crm-request-master-dialog',
    templateUrl: './rns-crm-request-master-dialog.component.html'
})
export class RNS_CRM_REQUEST_MASTERDialogComponent implements OnInit {

    rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_CRM_REQUEST_MASTERService: RNS_CRM_REQUEST_MASTERService,
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
        if (this.rNS_CRM_REQUEST_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_CRM_REQUEST_MASTERService.update(this.rNS_CRM_REQUEST_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_CRM_REQUEST_MASTERService.create(this.rNS_CRM_REQUEST_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_CRM_REQUEST_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_CRM_REQUEST_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_CRM_REQUEST_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_CRM_REQUEST_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-crm-request-master-popup',
    template: ''
})
export class RNS_CRM_REQUEST_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_CRM_REQUEST_MASTERPopupService: RNS_CRM_REQUEST_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_CRM_REQUEST_MASTERPopupService
                    .open(RNS_CRM_REQUEST_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_CRM_REQUEST_MASTERPopupService
                    .open(RNS_CRM_REQUEST_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
