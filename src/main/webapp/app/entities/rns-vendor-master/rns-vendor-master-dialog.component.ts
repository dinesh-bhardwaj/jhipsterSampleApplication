import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_VENDOR_MASTER } from './rns-vendor-master.model';
import { RNS_VENDOR_MASTERPopupService } from './rns-vendor-master-popup.service';
import { RNS_VENDOR_MASTERService } from './rns-vendor-master.service';

@Component({
    selector: 'jhi-rns-vendor-master-dialog',
    templateUrl: './rns-vendor-master-dialog.component.html'
})
export class RNS_VENDOR_MASTERDialogComponent implements OnInit {

    rNS_VENDOR_MASTER: RNS_VENDOR_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_VENDOR_MASTERService: RNS_VENDOR_MASTERService,
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
        if (this.rNS_VENDOR_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_VENDOR_MASTERService.update(this.rNS_VENDOR_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_VENDOR_MASTERService.create(this.rNS_VENDOR_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_VENDOR_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_VENDOR_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_VENDOR_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_VENDOR_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-vendor-master-popup',
    template: ''
})
export class RNS_VENDOR_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_VENDOR_MASTERPopupService: RNS_VENDOR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_VENDOR_MASTERPopupService
                    .open(RNS_VENDOR_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_VENDOR_MASTERPopupService
                    .open(RNS_VENDOR_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
