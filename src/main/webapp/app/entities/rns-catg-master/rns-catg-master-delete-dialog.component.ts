import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_CATG_MASTER } from './rns-catg-master.model';
import { RNS_CATG_MASTERPopupService } from './rns-catg-master-popup.service';
import { RNS_CATG_MASTERService } from './rns-catg-master.service';

@Component({
    selector: 'jhi-rns-catg-master-delete-dialog',
    templateUrl: './rns-catg-master-delete-dialog.component.html'
})
export class RNS_CATG_MASTERDeleteDialogComponent {

    rNS_CATG_MASTER: RNS_CATG_MASTER;

    constructor(
        private rNS_CATG_MASTERService: RNS_CATG_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_CATG_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_CATG_MASTERListModification',
                content: 'Deleted an rNS_CATG_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-catg-master-delete-popup',
    template: ''
})
export class RNS_CATG_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_CATG_MASTERPopupService: RNS_CATG_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_CATG_MASTERPopupService
                .open(RNS_CATG_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
