import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { RNS_PAY_TERMS_MASTERPopupService } from './rns-pay-terms-master-popup.service';
import { RNS_PAY_TERMS_MASTERService } from './rns-pay-terms-master.service';

@Component({
    selector: 'jhi-rns-pay-terms-master-delete-dialog',
    templateUrl: './rns-pay-terms-master-delete-dialog.component.html'
})
export class RNS_PAY_TERMS_MASTERDeleteDialogComponent {

    rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER;

    constructor(
        private rNS_PAY_TERMS_MASTERService: RNS_PAY_TERMS_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_PAY_TERMS_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_PAY_TERMS_MASTERListModification',
                content: 'Deleted an rNS_PAY_TERMS_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-pay-terms-master-delete-popup',
    template: ''
})
export class RNS_PAY_TERMS_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_PAY_TERMS_MASTERPopupService: RNS_PAY_TERMS_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_PAY_TERMS_MASTERPopupService
                .open(RNS_PAY_TERMS_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
