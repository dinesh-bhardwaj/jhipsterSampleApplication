import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { RNS_SECTOR_MASTER } from './rns-sector-master.model';
import { RNS_SECTOR_MASTERPopupService } from './rns-sector-master-popup.service';
import { RNS_SECTOR_MASTERService } from './rns-sector-master.service';
import { RNSCATGMASTER, RNSCATGMASTERService } from '../rnscatgmaster';

@Component({
    selector: 'jhi-rns-sector-master-dialog',
    templateUrl: './rns-sector-master-dialog.component.html'
})
export class RNS_SECTOR_MASTERDialogComponent implements OnInit {

    rNS_SECTOR_MASTER: RNS_SECTOR_MASTER;
    isSaving: boolean;

    rnscatgmasters: RNSCATGMASTER[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private rNS_SECTOR_MASTERService: RNS_SECTOR_MASTERService,
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
        if (this.rNS_SECTOR_MASTER.id !== undefined) {
            this.subscribeToSaveResponse(
                this.rNS_SECTOR_MASTERService.update(this.rNS_SECTOR_MASTER));
        } else {
            this.subscribeToSaveResponse(
                this.rNS_SECTOR_MASTERService.create(this.rNS_SECTOR_MASTER));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<RNS_SECTOR_MASTER>>) {
        result.subscribe((res: HttpResponse<RNS_SECTOR_MASTER>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: RNS_SECTOR_MASTER) {
        this.eventManager.broadcast({ name: 'rNS_SECTOR_MASTERListModification', content: 'OK'});
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
    selector: 'jhi-rns-sector-master-popup',
    template: ''
})
export class RNS_SECTOR_MASTERPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_SECTOR_MASTERPopupService: RNS_SECTOR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.rNS_SECTOR_MASTERPopupService
                    .open(RNS_SECTOR_MASTERDialogComponent as Component, params['id']);
            } else {
                this.rNS_SECTOR_MASTERPopupService
                    .open(RNS_SECTOR_MASTERDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
