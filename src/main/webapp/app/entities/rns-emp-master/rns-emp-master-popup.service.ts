import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_EMP_MASTER } from './rns-emp-master.model';
import { RNS_EMP_MASTERService } from './rns-emp-master.service';

@Injectable()
export class RNS_EMP_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_EMP_MASTERService: RNS_EMP_MASTERService

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
                this.rNS_EMP_MASTERService.find(id)
                    .subscribe((rNS_EMP_MASTERResponse: HttpResponse<RNS_EMP_MASTER>) => {
                        const rNS_EMP_MASTER: RNS_EMP_MASTER = rNS_EMP_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_EMP_MASTERModalRef(component, rNS_EMP_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_EMP_MASTERModalRef(component, new RNS_EMP_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_EMP_MASTERModalRef(component: Component, rNS_EMP_MASTER: RNS_EMP_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_EMP_MASTER = rNS_EMP_MASTER;
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
