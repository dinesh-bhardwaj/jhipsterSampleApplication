/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_EMP_MASTERDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master-delete-dialog.component';
import { RNS_EMP_MASTERService } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.service';

describe('Component Tests', () => {

    describe('RNS_EMP_MASTER Management Delete Component', () => {
        let comp: RNS_EMP_MASTERDeleteDialogComponent;
        let fixture: ComponentFixture<RNS_EMP_MASTERDeleteDialogComponent>;
        let service: RNS_EMP_MASTERService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_EMP_MASTERDeleteDialogComponent],
                providers: [
                    RNS_EMP_MASTERService
                ]
            })
            .overrideTemplate(RNS_EMP_MASTERDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_EMP_MASTERDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_EMP_MASTERService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
