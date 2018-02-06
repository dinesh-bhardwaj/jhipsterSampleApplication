import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { RNS_ARTICLE_MASTERService } from './rns-article-master.service';

@Injectable()
export class RNS_ARTICLE_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_ARTICLE_MASTERService: RNS_ARTICLE_MASTERService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.rNS_ARTICLE_MASTERService.find(id)
                    .subscribe((rNS_ARTICLE_MASTERResponse: HttpResponse<RNS_ARTICLE_MASTER>) => {
                        const rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER = rNS_ARTICLE_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_ARTICLE_MASTERModalRef(component, rNS_ARTICLE_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_ARTICLE_MASTERModalRef(component, new RNS_ARTICLE_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_ARTICLE_MASTERModalRef(component: Component, rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_ARTICLE_MASTER = rNS_ARTICLE_MASTER;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
