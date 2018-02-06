import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { RNS_PCH_MASTERPopupService } from './rns-pch-master-popup.service';
import { RNS_PCH_MASTERService } from './rns-pch-master.service';

@Component({
    selector: 'jhi-rns-pch-master-dialog',
    templateUrl: './rns-pch-master-dialog.component.html'
})
export class RNS_PCH_MASTERDialogComponent implements OnInit {

    rNS_PCH_MASTER: RNS_PCH_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_PCH_MASTERService: RNS_PCH_MASTERService,
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
        if (this.rNS_PCH_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_PCH_MASTERService.update(this.rNS_PCH_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_PCH_MASTERService.create(this.rNS_PCH_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_PCH_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_PCH_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_PCH_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_PCH_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-pch-master-popup',
    template: ''
})
export class RNS_PCH_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_PCH_MASTERPopupService: RNS_PCH_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_PCH_MASTERPopupService
                    .open(RNS_PCH_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_PCH_MASTERPopupService
                    .open(RNS_PCH_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
