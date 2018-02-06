import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { RNS_REFR_MASTERPopupService } from './rns-refr-master-popup.service';
import { RNS_REFR_MASTERService } from './rns-refr-master.service';

@Component({
    selector: 'jhi-rns-refr-master-delete-dialog',
    templateUrl: './rns-refr-master-delete-dialog.component.html'
})
export class RNS_REFR_MASTERDeleteDialogComponent {

    rNS_REFR_MASTER: RNS_REFR_MASTER;

    constructor(
        private rNS_REFR_MASTERService: RNS_REFR_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_REFR_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_REFR_MASTERListModification',
                content: 'Deleted an rNS_REFR_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-refr-master-delete-popup',
    template: ''
})
export class RNS_REFR_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_REFR_MASTERPopupService: RNS_REFR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_REFR_MASTERPopupService
                .open(RNS_REFR_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
