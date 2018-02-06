import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CATG_MASTER } from './rns-catg-master.model';
import { RNS_CATG_MASTERPopupService } from './rns-catg-master-popup.service';
import { RNS_CATG_MASTERService } from './rns-catg-master.service';

@Component({
    selector: 'jhi-rns-catg-master-dialog',
    templateUrl: './rns-catg-master-dialog.component.html'
})
export class RNS_CATG_MASTERDialogComponent implements OnInit {

    rNS_CATG_MASTER: RNS_CATG_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_CATG_MASTERService: RNS_CATG_MASTERService,
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
        if (this.rNS_CATG_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_CATG_MASTERService.update(this.rNS_CATG_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_CATG_MASTERService.create(this.rNS_CATG_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_CATG_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_CATG_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_CATG_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_CATG_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-catg-master-popup',
    template: ''
})
export class RNS_CATG_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_CATG_MASTERPopupService: RNS_CATG_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_CATG_MASTERPopupService
                    .open(RNS_CATG_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_CATG_MASTERPopupService
                    .open(RNS_CATG_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
