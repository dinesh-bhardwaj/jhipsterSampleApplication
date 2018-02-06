import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_EMP_MASTER } from './rns-emp-master.model';
import { RNS_EMP_MASTERPopupService } from './rns-emp-master-popup.service';
import { RNS_EMP_MASTERService } from './rns-emp-master.service';

@Component({
    selector: 'jhi-rns-emp-master-delete-dialog',
    templateUrl: './rns-emp-master-delete-dialog.component.html'
})
export class RNS_EMP_MASTERDeleteDialogComponent {

    rNS_EMP_MASTER: RNS_EMP_MASTER;

    constructor(
        private rNS_EMP_MASTERService: RNS_EMP_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_EMP_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_EMP_MASTERListModification',
                content: 'Deleted an rNS_EMP_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-emp-master-delete-popup',
    template: ''
})
export class RNS_EMP_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_EMP_MASTERPopupService: RNS_EMP_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_EMP_MASTERPopupService
                .open(RNS_EMP_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
