import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_DEL_PLACE_MASTER } from './rns-del-place-master.model';
import { RNS_DEL_PLACE_MASTERPopupService } from './rns-del-place-master-popup.service';
import { RNS_DEL_PLACE_MASTERService } from './rns-del-place-master.service';

@Component({
    selector: 'jhi-rns-del-place-master-dialog',
    templateUrl: './rns-del-place-master-dialog.component.html'
})
export class RNS_DEL_PLACE_MASTERDialogComponent implements OnInit {

    rNS_DEL_PLACE_MASTER: RNS_DEL_PLACE_MASTER;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private rNS_DEL_PLACE_MASTERService: RNS_DEL_PLACE_MASTERService,
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
        if (this.rNS_DEL_PLACE_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_DEL_PLACE_MASTERService.update(this.rNS_DEL_PLACE_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_DEL_PLACE_MASTERService.create(this.rNS_DEL_PLACE_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_DEL_PLACE_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_DEL_PLACE_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_DEL_PLACE_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_DEL_PLACE_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-rns-del-place-master-popup',
    template: ''
})
export class RNS_DEL_PLACE_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_DEL_PLACE_MASTERPopupService: RNS_DEL_PLACE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_DEL_PLACE_MASTERPopupService
                    .open(RNS_DEL_PLACE_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_DEL_PLACE_MASTERPopupService
                    .open(RNS_DEL_PLACE_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
