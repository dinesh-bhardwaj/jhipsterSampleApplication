import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { RNS_CRM_REQUEST_MASTERPopupService } from './rns-crm-request-master-popup.service';
import { RNS_CRM_REQUEST_MASTERService } from './rns-crm-request-master.service';

@Component({
    selector: 'jhi-rns-crm-request-master-delete-dialog',
    templateUrl: './rns-crm-request-master-delete-dialog.component.html'
})
export class RNS_CRM_REQUEST_MASTERDeleteDialogComponent {

    rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER;

    constructor(
        private rNS_CRM_REQUEST_MASTERService: RNS_CRM_REQUEST_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_CRM_REQUEST_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_CRM_REQUEST_MASTERListModification',
                content: 'Deleted an rNS_CRM_REQUEST_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-crm-request-master-delete-popup',
    template: ''
})
export class RNS_CRM_REQUEST_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_CRM_REQUEST_MASTERPopupService: RNS_CRM_REQUEST_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_CRM_REQUEST_MASTERPopupService
                .open(RNS_CRM_REQUEST_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
