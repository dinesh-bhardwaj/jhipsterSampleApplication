import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { RNS_CRM_REQUEST_MASTERService } from './rns-crm-request-master.service';

@Injectable()
export class RNS_CRM_REQUEST_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_CRM_REQUEST_MASTERService: RNS_CRM_REQUEST_MASTERService

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
                this.rNS_CRM_REQUEST_MASTERService.find(id)
                    .subscribe((rNS_CRM_REQUEST_MASTERResponse: HttpResponse<RNS_CRM_REQUEST_MASTER>) => {
                        const rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_CRM_REQUEST_MASTERModalRef(component, rNS_CRM_REQUEST_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_CRM_REQUEST_MASTERModalRef(component, new RNS_CRM_REQUEST_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_CRM_REQUEST_MASTERModalRef(component: Component, rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_CRM_REQUEST_MASTER = rNS_CRM_REQUEST_MASTER;
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
