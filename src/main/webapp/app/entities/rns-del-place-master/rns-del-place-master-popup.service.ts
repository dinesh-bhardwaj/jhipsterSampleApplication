import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_DEL_PLACE_MASTER } from './rns-del-place-master.model';
import { RNS_DEL_PLACE_MASTERService } from './rns-del-place-master.service';

@Injectable()
export class RNS_DEL_PLACE_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_DEL_PLACE_MASTERService: RNS_DEL_PLACE_MASTERService

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
                this.rNS_DEL_PLACE_MASTERService.find(id)
                    .subscribe((rNS_DEL_PLACE_MASTERResponse: HttpResponse<RNS_DEL_PLACE_MASTER>) => {
                        const rNS_DEL_PLACE_MASTER: RNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_DEL_PLACE_MASTERModalRef(component, rNS_DEL_PLACE_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_DEL_PLACE_MASTERModalRef(component, new RNS_DEL_PLACE_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_DEL_PLACE_MASTERModalRef(component: Component, rNS_DEL_PLACE_MASTER: RNS_DEL_PLACE_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_DEL_PLACE_MASTER = rNS_DEL_PLACE_MASTER;
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
