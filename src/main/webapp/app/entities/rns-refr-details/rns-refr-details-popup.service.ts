import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { RNS_REFR_DETAILS } from './rns-refr-details.model';
import { RNS_REFR_DETAILSService } from './rns-refr-details.service';

@Injectable()
export class RNS_REFR_DETAILSPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private rNS_REFR_DETAILSService: RNS_REFR_DETAILSService

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
                this.rNS_REFR_DETAILSService.find(id)
                    .subscribe((rNS_REFR_DETAILSResponse: HttpResponse<RNS_REFR_DETAILS>) => {
                        const rNS_REFR_DETAILS: RNS_REFR_DETAILS = rNS_REFR_DETAILSResponse.body;
                        rNS_REFR_DETAILS.cREATEDDATE = this.datePipe
                            .transform(rNS_REFR_DETAILS.cREATEDDATE, 'yyyy-MM-ddTHH:mm:ss');
                        rNS_REFR_DETAILS.lASTMODIFIEDDATE = this.datePipe
                            .transform(rNS_REFR_DETAILS.lASTMODIFIEDDATE, 'yyyy-MM-ddTHH:mm:ss');
                        this.ngbModalRef = this.rNS_REFR_DETAILSModalRef(component, rNS_REFR_DETAILS);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_REFR_DETAILSModalRef(component, new RNS_REFR_DETAILS());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_REFR_DETAILSModalRef(component: Component, rNS_REFR_DETAILS: RNS_REFR_DETAILS): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_REFR_DETAILS = rNS_REFR_DETAILS;
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
