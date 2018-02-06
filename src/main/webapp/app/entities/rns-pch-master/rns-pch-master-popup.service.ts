import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { RNS_PCH_MASTERService } from './rns-pch-master.service';

@Injectable()
export class RNS_PCH_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_PCH_MASTERService: RNS_PCH_MASTERService

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
                this.rNS_PCH_MASTERService.find(id)
                    .subscribe((rNS_PCH_MASTERResponse: HttpResponse<RNS_PCH_MASTER>) => {
                        const rNS_PCH_MASTER: RNS_PCH_MASTER = rNS_PCH_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_PCH_MASTERModalRef(component, rNS_PCH_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_PCH_MASTERModalRef(component, new RNS_PCH_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_PCH_MASTERModalRef(component: Component, rNS_PCH_MASTER: RNS_PCH_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_PCH_MASTER = rNS_PCH_MASTER;
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
