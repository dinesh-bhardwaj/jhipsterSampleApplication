import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_REFR_DETAILS } from './rns-refr-details.model';
import { RNS_REFR_DETAILSPopupService } from './rns-refr-details-popup.service';
import { RNS_REFR_DETAILSService } from './rns-refr-details.service';
import { RNSREFRMASTER, RNSREFRMASTERService } from '../rnsrefrmaster';

@Component({
    selector: 'jhi-rns-refr-details-dialog',
    templateUrl: './rns-refr-details-dialog.component.html'
})
export class RNS_REFR_DETAILSDialogComponent implements OnInit {

    rNS_REFR_DETAILS: RNS_REFR_DETAILS;
    isSaving: boolean;

    rnsrefrmasters: RNSREFRMASTER[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private rNS_REFR_DETAILSService: RNS_REFR_DETAILSService,
        private rNSREFRMASTERService: RNSREFRMASTERService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.rNSREFRMASTERService.query()
            .subscribe((res: HttpResponse<RNSREFRMASTER[]>) => { this.rnsrefrmasters = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.rNS_REFR_DETAILS.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_REFR_DETAILSService.update(this.rNS_REFR_DETAILS));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_REFR_DETAILSService.create(this.rNS_REFR_DETAILS));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_REFR_DETAILS>>) {
        result.subscribe((res: HttpResponse<RNS_REFR_DETAILS>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_REFR_DETAILS) {
        this.eventManager.broadcast({ name: 'rNS_REFR_DETAILSListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackRNSREFRMASTERById(index: number, item: RNSREFRMASTER) {
        return item.id;
    }

    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }
}

@Component({
    selector: 'jhi-rns-refr-details-popup',
    template: ''
})
export class RNS_REFR_DETAILSPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_REFR_DETAILSPopupService: RNS_REFR_DETAILSPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_REFR_DETAILSPopupService
                    .open(RNS_REFR_DETAILSDialogComponent as Component, params['id']);
            } else {
                this.rNS_REFR_DETAILSPopupService
                    .open(RNS_REFR_DETAILSDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
