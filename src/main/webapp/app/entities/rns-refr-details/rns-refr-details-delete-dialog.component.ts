import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_REFR_DETAILS } from './rns-refr-details.model';
import { RNS_REFR_DETAILSPopupService } from './rns-refr-details-popup.service';
import { RNS_REFR_DETAILSService } from './rns-refr-details.service';

@Component({
    selector: 'jhi-rns-refr-details-delete-dialog',
    templateUrl: './rns-refr-details-delete-dialog.component.html'
})
export class RNS_REFR_DETAILSDeleteDialogComponent {

    rNS_REFR_DETAILS: RNS_REFR_DETAILS;

    constructor(
        private rNS_REFR_DETAILSService: RNS_REFR_DETAILSService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_REFR_DETAILSService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_REFR_DETAILSListModification',
                content: 'Deleted an rNS_REFR_DETAILS'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-refr-details-delete-popup',
    template: ''
})
export class RNS_REFR_DETAILSDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_REFR_DETAILSPopupService: RNS_REFR_DETAILSPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_REFR_DETAILSPopupService
                .open(RNS_REFR_DETAILSDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
