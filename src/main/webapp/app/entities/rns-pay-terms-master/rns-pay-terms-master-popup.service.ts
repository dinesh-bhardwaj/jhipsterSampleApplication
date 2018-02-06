import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { RNS_PAY_TERMS_MASTERService } from './rns-pay-terms-master.service';

@Injectable()
export class RNS_PAY_TERMS_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_PAY_TERMS_MASTERService: RNS_PAY_TERMS_MASTERService

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
                this.rNS_PAY_TERMS_MASTERService.find(id)
                    .subscribe((rNS_PAY_TERMS_MASTERResponse: HttpResponse<RNS_PAY_TERMS_MASTER>) => {
                        const rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_PAY_TERMS_MASTERModalRef(component, rNS_PAY_TERMS_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_PAY_TERMS_MASTERModalRef(component, new RNS_PAY_TERMS_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_PAY_TERMS_MASTERModalRef(component: Component, rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_PAY_TERMS_MASTER = rNS_PAY_TERMS_MASTER;
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
