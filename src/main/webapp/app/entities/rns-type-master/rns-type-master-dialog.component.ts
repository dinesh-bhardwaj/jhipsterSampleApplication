import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_TYPE_MASTER } from './rns-type-master.model';
import { RNS_TYPE_MASTERPopupService } from './rns-type-master-popup.service';
import { RNS_TYPE_MASTERService } from './rns-type-master.service';
import { RNSCATGMASTER, RNSCATGMASTERService } from '../rnscatgmaster';

@Component({
    selector: 'jhi-rns-type-master-dialog',
    templateUrl: './rns-type-master-dialog.component.html'
})
export class RNS_TYPE_MASTERDialogComponent implements OnInit {

    rNS_TYPE_MASTER: RNS_TYPE_MASTER;
    isSaving: boolean;

    rnscatgmasters: RNSCATGMASTER[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private rNS_TYPE_MASTERService: RNS_TYPE_MASTERService,
        private rNSCATGMASTERService: RNSCATGMASTERService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.rNSCATGMASTERService.query()
            .subscribe((res: HttpResponse<RNSCATGMASTER[]>) => { this.rnscatgmasters = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.rNS_TYPE_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_TYPE_MASTERService.update(this.rNS_TYPE_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_TYPE_MASTERService.create(this.rNS_TYPE_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_TYPE_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_TYPE_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_TYPE_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_TYPE_MASTERListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackRNSCATGMASTERById(index: number, item: RNSCATGMASTER) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-rns-type-master-popup',
    template: ''
})
export class RNS_TYPE_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_TYPE_MASTERPopupService: RNS_TYPE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_TYPE_MASTERPopupService
                    .open(RNS_TYPE_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_TYPE_MASTERPopupService
                    .open(RNS_TYPE_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
