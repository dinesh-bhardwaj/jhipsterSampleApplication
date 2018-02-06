import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_VENDOR_MASTER } from './rns-vendor-master.model';
import { RNS_VENDOR_MASTERPopupService } from './rns-vendor-master-popup.service';
import { RNS_VENDOR_MASTERService } from './rns-vendor-master.service';

@Component({
    selector: 'jhi-rns-vendor-master-delete-dialog',
    templateUrl: './rns-vendor-master-delete-dialog.component.html'
})
export class RNS_VENDOR_MASTERDeleteDialogComponent {

    rNS_VENDOR_MASTER: RNS_VENDOR_MASTER;

    constructor(
        private rNS_VENDOR_MASTERService: RNS_VENDOR_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_VENDOR_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_VENDOR_MASTERListModification',
                content: 'Deleted an rNS_VENDOR_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-vendor-master-delete-popup',
    template: ''
})
export class RNS_VENDOR_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_VENDOR_MASTERPopupService: RNS_VENDOR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_VENDOR_MASTERPopupService
                .open(RNS_VENDOR_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
