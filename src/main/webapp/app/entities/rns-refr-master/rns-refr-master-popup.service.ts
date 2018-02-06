import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { RNS_REFR_MASTERService } from './rns-refr-master.service';

@Injectable()
export class RNS_REFR_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private rNS_REFR_MASTERService: RNS_REFR_MASTERService

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
                this.rNS_REFR_MASTERService.find(id)
                    .subscribe((rNS_REFR_MASTERResponse: HttpResponse<RNS_REFR_MASTER>) => {
                        const rNS_REFR_MASTER: RNS_REFR_MASTER = rNS_REFR_MASTERResponse.body;
                        rNS_REFR_MASTER.cREATEDDATE = this.datePipe
                            .transform(rNS_REFR_MASTER.cREATEDDATE, 'yyyy-MM-ddTHH:mm:ss');
                        rNS_REFR_MASTER.lASTMODIFIEDDATE = this.datePipe
                            .transform(rNS_REFR_MASTER.lASTMODIFIEDDATE, 'yyyy-MM-ddTHH:mm:ss');
                        this.ngbModalRef = this.rNS_REFR_MASTERModalRef(component, rNS_REFR_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_REFR_MASTERModalRef(component, new RNS_REFR_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_REFR_MASTERModalRef(component: Component, rNS_REFR_MASTER: RNS_REFR_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_REFR_MASTER = rNS_REFR_MASTER;
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
