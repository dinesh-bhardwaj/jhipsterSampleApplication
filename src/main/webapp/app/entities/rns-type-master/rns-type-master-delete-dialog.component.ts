import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_TYPE_MASTER } from './rns-type-master.model';
import { RNS_TYPE_MASTERPopupService } from './rns-type-master-popup.service';
import { RNS_TYPE_MASTERService } from './rns-type-master.service';

@Component({
    selector: 'jhi-rns-type-master-delete-dialog',
    templateUrl: './rns-type-master-delete-dialog.component.html'
})
export class RNS_TYPE_MASTERDeleteDialogComponent {

    rNS_TYPE_MASTER: RNS_TYPE_MASTER;

    constructor(
        private rNS_TYPE_MASTERService: RNS_TYPE_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_TYPE_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_TYPE_MASTERListModification',
                content: 'Deleted an rNS_TYPE_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-type-master-delete-popup',
    template: ''
})
export class RNS_TYPE_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_TYPE_MASTERPopupService: RNS_TYPE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_TYPE_MASTERPopupService
                .open(RNS_TYPE_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
