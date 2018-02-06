import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_DEL_PLACE_MASTER } from './rns-del-place-master.model';
import { RNS_DEL_PLACE_MASTERPopupService } from './rns-del-place-master-popup.service';
import { RNS_DEL_PLACE_MASTERService } from './rns-del-place-master.service';

@Component({
    selector: 'jhi-rns-del-place-master-delete-dialog',
    templateUrl: './rns-del-place-master-delete-dialog.component.html'
})
export class RNS_DEL_PLACE_MASTERDeleteDialogComponent {

    rNS_DEL_PLACE_MASTER: RNS_DEL_PLACE_MASTER;

    constructor(
        private rNS_DEL_PLACE_MASTERService: RNS_DEL_PLACE_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_DEL_PLACE_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_DEL_PLACE_MASTERListModification',
                content: 'Deleted an rNS_DEL_PLACE_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-del-place-master-delete-popup',
    template: ''
})
export class RNS_DEL_PLACE_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_DEL_PLACE_MASTERPopupService: RNS_DEL_PLACE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_DEL_PLACE_MASTERPopupService
                .open(RNS_DEL_PLACE_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
