import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_CATG_MASTER } from './rns-catg-master.model';
import { RNS_CATG_MASTERService } from './rns-catg-master.service';

@Injectable()
export class RNS_CATG_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_CATG_MASTERService: RNS_CATG_MASTERService

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
                this.rNS_CATG_MASTERService.find(id)
                    .subscribe((rNS_CATG_MASTERResponse: HttpResponse<RNS_CATG_MASTER>) => {
                        const rNS_CATG_MASTER: RNS_CATG_MASTER = rNS_CATG_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_CATG_MASTERModalRef(component, rNS_CATG_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_CATG_MASTERModalRef(component, new RNS_CATG_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_CATG_MASTERModalRef(component: Component, rNS_CATG_MASTER: RNS_CATG_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_CATG_MASTER = rNS_CATG_MASTER;
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
