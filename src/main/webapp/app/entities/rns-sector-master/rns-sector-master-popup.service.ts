import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { RNS_SECTOR_MASTER } from './rns-sector-master.model';
import { RNS_SECTOR_MASTERService } from './rns-sector-master.service';

@Injectable()
export class RNS_SECTOR_MASTERPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private rNS_SECTOR_MASTERService: RNS_SECTOR_MASTERService

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
                this.rNS_SECTOR_MASTERService.find(id)
                    .subscribe((rNS_SECTOR_MASTERResponse: HttpResponse<RNS_SECTOR_MASTER>) => {
                        const rNS_SECTOR_MASTER: RNS_SECTOR_MASTER = rNS_SECTOR_MASTERResponse.body;
                        this.ngbModalRef = this.rNS_SECTOR_MASTERModalRef(component, rNS_SECTOR_MASTER);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.rNS_SECTOR_MASTERModalRef(component, new RNS_SECTOR_MASTER());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    rNS_SECTOR_MASTERModalRef(component: Component, rNS_SECTOR_MASTER: RNS_SECTOR_MASTER): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.rNS_SECTOR_MASTER = rNS_SECTOR_MASTER;
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
