import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_BUYER_MASTER } from './rns-buyer-master.model';
import { RNS_BUYER_MASTERPopupService } from './rns-buyer-master-popup.service';
import { RNS_BUYER_MASTERService } from './rns-buyer-master.service';

@Component({
    selector: 'jhi-rns-buyer-master-delete-dialog',
    templateUrl: './rns-buyer-master-delete-dialog.component.html'
})
export class RNS_BUYER_MASTERDeleteDialogComponent {

    rNS_BUYER_MASTER: RNS_BUYER_MASTER;

    constructor(
        private rNS_BUYER_MASTERService: RNS_BUYER_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_BUYER_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_BUYER_MASTERListModification',
                content: 'Deleted an rNS_BUYER_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-buyer-master-delete-popup',
    template: ''
})
export class RNS_BUYER_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_BUYER_MASTERPopupService: RNS_BUYER_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_BUYER_MASTERPopupService
                .open(RNS_BUYER_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
