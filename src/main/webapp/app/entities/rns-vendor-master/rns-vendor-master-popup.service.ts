import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_VENDOR_MASTER } from './rns-vendor-master.model';
import { RNS_VENDOR_MASTERService } from './rns-vendor-master.service';

@Injectable()
export class RNS_VENDOR_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_VENDOR_MASTERService: RNS_VENDOR_MASTERService

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
                this.rNS_VENDOR_MASTERService.find(id)
                    .subscribe((rNS_VENDOR_MASTERResponse: HttpResponse<RNS_VENDOR_MASTER>) => {
                        const rNS_VENDOR_MASTER: RNS_VENDOR_MASTER = rNS_VENDOR_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_VENDOR_MASTERModalRef(component, rNS_VENDOR_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_VENDOR_MASTERModalRef(component, new RNS_VENDOR_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_VENDOR_MASTERModalRef(component: Component, rNS_VENDOR_MASTER: RNS_VENDOR_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_VENDOR_MASTER = rNS_VENDOR_MASTER;
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
