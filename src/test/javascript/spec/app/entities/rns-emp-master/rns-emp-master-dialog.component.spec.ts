/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_EMP_MASTERDialogComponent } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master-dialog.component';
import { RNS_EMP_MASTERService } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.service';
import { RNS_EMP_MASTER } from '../../../../../../main/webapp/app/entities/rns-emp-master/rns-emp-master.model';

describe('Component Tests', () => {

    describe('RNS_EMP_MASTER Management Dialog Component', () => {
        let comp: RNS_EMP_MASTERDialogComponent;
        let fixture: ComponentFixture<RNS_EMP_MASTERDialogComponent>;
        let service: RNS_EMP_MASTERService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_EMP_MASTERDialogComponent],
                providers: [
                    RNS_EMP_MASTERService
                ]
            })
            .overrideTemplate(RNS_EMP_MASTERDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_EMP_MASTERDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_EMP_MASTERService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_EMP_MASTER(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_EMP_MASTER = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_EMP_MASTERListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new RNS_EMP_MASTER();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.rNS_EMP_MASTER = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'rNS_EMP_MASTERListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
