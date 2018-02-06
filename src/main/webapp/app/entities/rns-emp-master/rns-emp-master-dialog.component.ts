import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_EMP_MASTER } from './rns-emp-master.model';
import { RNS_EMP_MASTERPopupService } from './rns-emp-master-popup.service';
import { RNS_EMP_MASTERService } from './rns-emp-master.service';

@Component({
    selector: 'jhi-rns-emp-master-dialog',
    templateUrl: './rns-emp-master-dialog.component.html'
})
export class RNS_EMP_MASTERDialogComponent implements OnInit {

    rNS_EMP_MASTER: RNS_EMP_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_EMP_MASTERService: RNS_EMP_MASTERService,
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
        if (this.rNS_EMP_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_EMP_MASTERService.update(this.rNS_EMP_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_EMP_MASTERService.create(this.rNS_EMP_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_EMP_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_EMP_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_EMP_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_EMP_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-emp-master-popup',
    template: ''
})
export class RNS_EMP_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_EMP_MASTERPopupService: RNS_EMP_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_EMP_MASTERPopupService
                    .open(RNS_EMP_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_EMP_MASTERPopupService
                    .open(RNS_EMP_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
