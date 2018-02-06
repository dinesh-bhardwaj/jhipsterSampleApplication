import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { RNS_ARTICLE_MASTERPopupService } from './rns-article-master-popup.service';
import { RNS_ARTICLE_MASTERService } from './rns-article-master.service';

@Component({
    selector: 'jhi-rns-article-master-delete-dialog',
    templateUrl: './rns-article-master-delete-dialog.component.html'
})
export class RNS_ARTICLE_MASTERDeleteDialogComponent {

    rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER;

    constructor(
        private rNS_ARTICLE_MASTERService: RNS_ARTICLE_MASTERService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rNS_ARTICLE_MASTERService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'rNS_ARTICLE_MASTERListModification',
                content: 'Deleted an rNS_ARTICLE_MASTER'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rns-article-master-delete-popup',
    template: ''
})
export class RNS_ARTICLE_MASTERDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private rNS_ARTICLE_MASTERPopupService: RNS_ARTICLE_MASTERPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.rNS_ARTICLE_MASTERPopupService
                .open(RNS_ARTICLE_MASTERDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
