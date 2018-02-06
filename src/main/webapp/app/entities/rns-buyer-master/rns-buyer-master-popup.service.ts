import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_BUYER_MASTER } from './rns-buyer-master.model';
import { RNS_BUYER_MASTERService } from './rns-buyer-master.service';

@Injectable()
export class RNS_BUYER_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_BUYER_MASTERService: RNS_BUYER_MASTERService

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
                this.rNS_BUYER_MASTERService.find(id)
                    .subscribe((rNS_BUYER_MASTERResponse: HttpResponse<RNS_BUYER_MASTER>) => {
                        const rNS_BUYER_MASTER: RNS_BUYER_MASTER = rNS_BUYER_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_BUYER_MASTERModalRef(component, rNS_BUYER_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_BUYER_MASTERModalRef(component, new RNS_BUYER_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_BUYER_MASTERModalRef(component: Component, rNS_BUYER_MASTER: RNS_BUYER_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_BUYER_MASTER = rNS_BUYER_MASTER;
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
