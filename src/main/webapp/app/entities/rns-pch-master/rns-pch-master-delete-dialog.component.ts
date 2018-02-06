import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { RNS_PCH_MASTERPopupService } from './rns-pch-master-popup.service';
import { RNS_PCH_MASTERService } from './rns-pch-master.service';

@Component({
    selector: 'jhi-rns-pch-master-delete-dialog',
    templateUrl: './rns-pch-master-delete-dialog.component.html'
})
export class RNS_PCH_MASTERDeleteDialogComponent {

    rNS_PCH_MASTER: RNS_PCH_MASTER;

    constructor(
        private rNS_PCH_MASTERService: RNS_PCH_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_PCH_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_PCH_MASTERListModification',
                content: 'Deleted an rNS_PCH_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-pch-master-delete-popup',
    template: ''
})
export class RNS_PCH_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_PCH_MASTERPopupService: RNS_PCH_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_PCH_MASTERPopupService
                .open(RNS_PCH_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
