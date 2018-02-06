import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { RNS_REFR_MASTERPopupService } from './rns-refr-master-popup.service';
import { RNS_REFR_MASTERService } from './rns-refr-master.service';
import { RNSREFRDETAILS, RNSREFRDETAILSService } from '../rnsrefrdetails';
import { RNSCATGMASTER, RNSCATGMASTERService } from '../rnscatgmaster';

@Component({
    selector: 'jhi-rns-refr-master-dialog',
    templateUrl: './rns-refr-master-dialog.component.html'
})
export class RNS_REFR_MASTERDialogComponent implements OnInit {

    rNS_REFR_MASTER: RNS_REFR_MASTER;
    isSaving: boolean;

    rnsrefrdetails: RNSREFRDETAILS[];

    rnscatgmasters: RNSCATGMASTER[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private rNS_REFR_MASTERService: RNS_REFR_MASTERService,
        private rNSREFRDETAILSService: RNSREFRDETAILSService,
        private rNSCATGMASTERService: RNSCATGMASTERService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.rNSREFRDETAILSService.query()
            .subscribe((res: HttpResponse<RNSREFRDETAILS[]>) => { this.rnsrefrdetails = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.rNSCATGMASTERService.query()
            .subscribe((res: HttpResponse<RNSCATGMASTER[]>) => { this.rnscatgmasters = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.rNS_REFR_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_REFR_MASTERService.update(this.rNS_REFR_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_REFR_MASTERService.create(this.rNS_REFR_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_REFR_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_REFR_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_REFR_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_REFR_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackRNSREFRDETAILSById(index: number, item: RNSREFRDETAILS) {
        return item.id;
    }

    trackRNSCATGMASTERById(index: number, item: RNSCATGMASTER) {
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
    selector: 'jhi-rns-refr-master-popup',
    template: ''
})
export class RNS_REFR_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_REFR_MASTERPopupService: RNS_REFR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_REFR_MASTERPopupService
                    .open(RNS_REFR_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_REFR_MASTERPopupService
                    .open(RNS_REFR_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
