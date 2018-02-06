import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_TYPE_MASTER } from './rns-type-master.model';
import { RNS_TYPE_MASTERService } from './rns-type-master.service';

@Injectable()
export class RNS_TYPE_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_TYPE_MASTERService: RNS_TYPE_MASTERService

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
                this.rNS_TYPE_MASTERService.find(id)
                    .subscribe((rNS_TYPE_MASTERResponse: HttpResponse<RNS_TYPE_MASTER>) => {
                        const rNS_TYPE_MASTER: RNS_TYPE_MASTER = rNS_TYPE_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_TYPE_MASTERModalRef(component, rNS_TYPE_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_TYPE_MASTERModalRef(component, new RNS_TYPE_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_TYPE_MASTERModalRef(component: Component, rNS_TYPE_MASTER: RNS_TYPE_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_TYPE_MASTER = rNS_TYPE_MASTER;
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
