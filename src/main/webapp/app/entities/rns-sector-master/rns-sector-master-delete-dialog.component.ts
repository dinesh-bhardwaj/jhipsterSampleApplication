import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_SECTOR_MASTER } from './rns-sector-master.model';
import { RNS_SECTOR_MASTERPopupService } from './rns-sector-master-popup.service';
import { RNS_SECTOR_MASTERService } from './rns-sector-master.service';

@Component({
    selector: 'jhi-rns-sector-master-delete-dialog',
    templateUrl: './rns-sector-master-delete-dialog.component.html'
})
export class RNS_SECTOR_MASTERDeleteDialogComponent {

    rNS_SECTOR_MASTER: RNS_SECTOR_MASTER;

    constructor(
        private rNS_SECTOR_MASTERService: RNS_SECTOR_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_SECTOR_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_SECTOR_MASTERListModification',
                content: 'Deleted an rNS_SECTOR_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-sector-master-delete-popup',
    template: ''
})
export class RNS_SECTOR_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_SECTOR_MASTERPopupService: RNS_SECTOR_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_SECTOR_MASTERPopupService
                .open(RNS_SECTOR_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
